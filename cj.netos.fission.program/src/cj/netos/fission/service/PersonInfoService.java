package cj.netos.fission.service;

import cj.netos.fission.*;
import cj.netos.fission.model.*;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import redis.clients.jedis.JedisCluster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "personInfoService")
public class PersonInfoService implements IPersonInfoService, IndexPoolConstants {

    @CjServiceRef(refByName = "@.redis.cluster")
    JedisCluster jedisCluster;
    @CjServiceRef
    IPersonService personService;
    @CjServiceRef
    ITagService tagService;
    @CjServiceRef
    IAreaService areaService;
    @CjServiceRef
    ICashierBalanceService cashierBalanceService;
    @CjServiceRef
    ICashierService cashierService;
    @CjServiceSite
    IServiceSite site;

    @Override
    public void createGeoIndex() {
        personService.createGeoIndex();
    }

    @Override
    public void indexAll() {
        CJSystem.logging().info(getClass(), "开始构建索引...");
        int limit = 100;
        long offset = 0;
        while (true) {
            List<Person> persons = personService.page(limit, offset);
            if (persons.isEmpty()) {
                break;
            }
            for (Person person : persons) {
                CJSystem.logging().info(getClass(), String.format("\t\t正在索引用户:%s[%s] ...", person.getNickName(), person.getId()));
                PersonInfo info = loadPersonInfo(person);
                indexPerson(info);
            }
            offset += persons.size();
        }
        CJSystem.logging().info(getClass(), "完成构建索引");
    }

    @Override
    public PersonInfo loadPersonInfo(Person person) {
        if (person == null) {
            return null;
        }
        String unionid = person.getId();
        Cashier cashier = cashierService.getCashier(unionid);
        List<Tag> propTags = tagService.listPropTag(unionid);
        List<LimitTag> limitTags = tagService.listLimitTag(unionid);
        List<String> payerTagIds = new ArrayList<>();
        List<String> payeeTagIds = new ArrayList<>();
        for (LimitTag limitTag : limitTags) {
            switch (limitTag.getDirect()) {
                case "payer":
                    payerTagIds.add(limitTag.getTag());
                    break;
                case "payee":
                    payeeTagIds.add(limitTag.getTag());
                    break;
            }
        }
        List<Tag> payerTags = tagService.listTagIn(payerTagIds);
        List<Tag> payeeTags = tagService.listTagIn(payeeTagIds);
        List<Area> areas = areaService.listLimitArea(unionid);
        Area payerArea = null;
        Area payeeArea = null;
        for (Area area : areas) {
            switch (area.getDirect()) {
                case "payer":
                    payerArea = area;
                    break;
                case "payee":
                    payeeArea = area;
                    break;
            }
        }
        CashierBalance balance = cashierBalanceService.getBalance(unionid);
        if (balance == null) {
            balance = new CashierBalance();
            balance.setPerson(unionid);
            balance.setBalance(0L);
        }
        PersonInfo info = new PersonInfo();
        info.setPerson(person);
        info.setCashier(cashier);
        info.setPropTags(propTags);
        info.setPayerArea(payerArea);
        info.setPayerTags(payerTags);
        info.setPayeeArea(payeeArea);
        info.setPayeeTags(payeeTags);
        info.setBalance(balance.getBalance());
        return info;
    }

    private void indexPerson(PersonInfo info) {
        Person person = info.getPerson();
        List<Tag> propTags = info.getPropTags();
        List<Tag> payerTags = info.getPayerTags();
        Area payerArea = info.getPayerArea();
        Cashier cashier = info.getCashier();
        long balance = info.getBalance();
        String openedAmount = site.getProperty("recommender.user.opened.amount");
        if (StringUtil.isEmpty(openedAmount)) {
            openedAmount = "60";
        }
        if (cashier.getState() == 1 || balance < Long.valueOf(openedAmount)/*只要大于6毛钱视为开放，就可推荐给他人了，如果设得太高，会使参与的用户变得太少*/) {
            CJSystem.logging().info(getClass(), String.format("\t\t\t\t跳过处理用户，因不符合条件。状态：%s %s<%s", cashier.getState(), balance, cashier.getCacAverage() * 2));
            return;
        }

        if (payerArea != null) {//有限定地区则放入区域池
            switch (payerArea.getAreaType()) {
                case "province":
                    if (!StringUtil.isEmpty(payerArea.getAreaCode())) {
                        CJSystem.logging().info(getClass(), String.format("\t\t\t\t限定到省：%s", payerArea.getAreaTitle()));
                        indexAreaProvince(payerArea.getAreaCode(), person.getId(), balance);
                    }
                    break;
                case "city":
                    if (!StringUtil.isEmpty(payerArea.getAreaCode())) {
                        CJSystem.logging().info(getClass(), String.format("\t\t\t\t限定到市：%s", payerArea.getAreaTitle()));
                        indexAreaCity(payerArea.getAreaCode(), person.getId(), balance);
                    }
                    break;
                case "district":
                    if (!StringUtil.isEmpty(payerArea.getAreaCode())) {
                        CJSystem.logging().info(getClass(), String.format("\t\t\t\t限定到区县：%s", payerArea.getAreaTitle()));
                        indexAreaDistrict(payerArea.getAreaCode(), person.getId(), balance);
                    }
                    break;
            }
        } else {//没有限定区域则按用户位置所属区域放入区域池
            if (!StringUtil.isEmpty(person.getProvinceCode())) {
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t到省：%s", person.getProvince()));
                indexAreaProvince(person.getProvinceCode(), person.getId(), balance);
                if (!StringUtil.isEmpty(person.getCityCode())) {
                    CJSystem.logging().info(getClass(), String.format("\t\t\t\t到市：%s", person.getCity()));
                    String cityFull = String.format("%s·%s", person.getProvinceCode(), person.getCityCode());
                    indexAreaCity(cityFull, person.getId(), balance);
                    if (!StringUtil.isEmpty(person.getDistrictCode())) {
                        CJSystem.logging().info(getClass(), String.format("\t\t\t\t到区县：%s", person.getDistrict()));
                        String districtFull = String.format("%s·%s·%s", person.getProvinceCode(), person.getCityCode(), person.getDistrictCode());
                        indexAreaDistrict(districtFull, person.getId(), balance);
                    }
                }
            }
        }
        if (!payerTags.isEmpty()) {//有限定标签则放入标签池
            indexTag(payerTags, person.getId(), balance, true);
        }

        if (!propTags.isEmpty() && (payerArea == null && payerTags.isEmpty())) {//没有限定标签和限定的拉新条件且有属性标签则放入标签池
            indexTag(propTags, person.getId(), balance, false);
        }

        if (payerArea != null || !payerTags.isEmpty()) {//不论是否具有区域条件限定，或是具有拉新条件限定，只是有条件了，则不放常规池，此处反回
            return;
        }
        //放入常规池
        indexNormal(person.getId(), balance);
    }

    /*
    用户拉取算法：
    * 投资最多的用户在最顶：
    - 先在推荐过的表中求金额最高的用户，在redis中即可直接取大于该金额的指定数目的记录给客户，如果不够则向下取
    - 然后以小于这个最大金额往下取指定记录数，接着求出目标集合金额最大值与最小值还有用户id集合，以此为条件在推荐过表中查不存在的。
    - 如果不够则再循环，直到没有可取记录
    - 如果怕查询多次，可以求两边区间的记录数是否相等，不等就说明中间有变化，当然如果in性能比这更好，可以只按第2步直接查不存在的
    * 随机推荐：
    - 这个方案比较公平，缺点是大家不充大金额机会一样多，对平台收入没好处
    - 算法上，随机出来的更难判断是否已推荐过，一样得遍历，而且遍历的次数无法限定
     */
    private void indexNormal(String person, long balance) {
        CJSystem.logging().info(getClass(), String.format("\t\t\t\t到常规：是"));
        jedisCluster.zadd(_KEY_POOL_NORMAL, balance * 1.0, person);
    }

    private void indexTag(List<Tag> tags, String person, long balance, boolean isLimit) {
        for (Tag tag : tags) {
            CJSystem.logging().info(getClass(), String.format("\t\t\t\t%s到标签：%s", isLimit ? "限定" : "", tag.getName()));
            jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_TAG, tag.getId()), balance, person);
        }
    }

    private void indexAreaDistrict(String areaCode, String person, long balance) {//注意district格式是：省·市·区县
        jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_PROVINCE, areaCode), balance, person);
    }

    private void indexAreaCity(String areaCode, String person, long balance) {//注意city格式是：省·市
        jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_CITY, areaCode), balance, person);
    }

    private void indexAreaProvince(String areaCode, String person, long balance) {
        jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_DISTRICT, areaCode), balance, person);
    }

    @Override
    public void emptyIndexAll() throws CircuitException {
        CJSystem.logging().info(getClass(), "开始清除索引...");
        CJSystem.logging().info(getClass(), "\t\t\t\t清除常规");
        jedisCluster.del(_KEY_POOL_NORMAL);
        List<Tag> tags = tagService.listAllTag();
        for (Tag tag : tags) {
            CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除标签:%s", tag.getName()));
            jedisCluster.del(String.format("%s.%s", _KEY_POOL_TAG, tag.getId()));
        }
        //清除省、市、区县
        String home = site.getProperty("home.dir");
        String jsonFile = String.format("%s%sareas/data.json", home, File.separator);
        String data = null;
        try {
            data = readFileContent(jsonFile);
        } catch (IOException e) {
            throw new CircuitException("500", e);
        }
        Map<String, Object> map = new Gson().fromJson(data, HashMap.class);
        Map<String, Object> provinces = (Map<String, Object>) map.get("0");
        for (Map.Entry<String, Object> entryProvince : provinces.entrySet()) {
            String provinceCode = entryProvince.getKey();
            CJSystem.logging().info(getClass(), String.format("\t\t清除省:%s", entryProvince.getValue()));
            jedisCluster.del(String.format("%s.%s", _KEY_POOL_AREA_PROVINCE, provinceCode));
            String fullProvince = String.format("0,%s", provinceCode);
            Map<String, Object> cities = (Map<String, Object>) map.get(fullProvince);
            for (Map.Entry<String, Object> entryCity : cities.entrySet()) {
                String cityCode = entryCity.getKey();
                String cityIt = String.format("%s·%s", provinceCode, cityCode);
                String fullCity = String.format("0,%s,%s", provinceCode, cityCode);
                if (map.get(fullCity) instanceof List) {
                    continue;
                }
                Map<String, Object> districts = (Map<String, Object>) map.get(fullCity);
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除市:%s·%s", entryProvince.getValue(), entryCity.getValue()));
                jedisCluster.del(String.format("%s.%s", _KEY_POOL_AREA_CITY, cityIt));
                for (Map.Entry<String, Object> district : districts.entrySet()) {
                    String districtIt = String.format("%s·%s·%s", provinceCode, cityCode, district.getKey());
                    CJSystem.logging().info(getClass(), String.format("\t\t\t\t\t\t清除区县:%s·%s·%s", entryProvince.getValue(), entryCity.getValue(), district.getValue()));
                    jedisCluster.del(String.format("%s.%s", _KEY_POOL_AREA_DISTRICT, districtIt));
                }
            }
        }
        CJSystem.logging().info(getClass(), "清除索引完毕");
    }

    private static String readFileContent(String fileName) throws IOException {
        File file = new File(fileName);
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String content = "";
        StringBuilder sb = new StringBuilder();
        while (content != null) {
            content = bf.readLine();
            if (content == null) {
                break;
            }
            sb.append(content.trim());
        }
        bf.close();
        return sb.toString();
    }
}
