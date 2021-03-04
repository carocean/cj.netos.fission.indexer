package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.netos.fission.*;
import cj.netos.fission.model.*;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.annotation.CjServiceSite;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.CheckAccessTokenException;
import cj.ultimate.gson2.com.google.gson.Gson;
import cj.ultimate.util.StringUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明
 * <pre>
 * - 更新位置 website&cashier
 * 参数：用户标识、位置
 * - 更新余额
 * 充值 cashier
 * 提现 cashier
 * 收益 cashier
 * 支付 cashier
 * 统一个事件，参数：用户标识、动作（无意义，但保留）
 * - 添加属性标签 website&cashier
 * 参数：用户标识、动作、标签
 * - 移除属性标签 website&cashier
 * 参数：用户标识、动作、标签
 * - 添加地域限定 cashier
 * 参数：用户标识、动作、地域类型、地域代码
 * - 移除地域限定 cashier
 * 参数：用户标识、动作、地域类型、地域代码
 * - 添加标签限定 cashier
 * 参数：用户标识、动作、标签
 * - 移除标签限定 cashier
 * 参数：用户标识、动作、标签
 * </pre>
 */
@CjService(name = "updaterManager")
public class UpdaterManager extends AbstractService implements IUpdaterManager, IndexPoolConstants {
    static final String _COL = "fission.mf.update.events";
    @CjServiceSite
    IServiceSite site;

    @CjServiceRef(refByName = "@.redis.cluster")
    JedisCluster jedisCluster;
    @CjServiceRef
    ICashierBalanceService cashierBalanceService;
    @CjServiceRef
    ITagService tagService;
    @CjServiceRef
    IAreaService areaService;
    @CjServiceRef
    IPersonService personService;
    @CjServiceRef
    IPersonInfoService personInfoService;
    OkHttpClient client;

    @Override
    public void start() {
        client = new OkHttpClient();
        String sleep = site.getProperty("updateManager.sleep");
        if (StringUtil.isEmpty(sleep)) {
            sleep = "600";//10分钟
        }
        CJSystem.logging().info(getClass(), String.format("启动更新管理器，轮询间隔：%s秒", sleep));
        long sleepLong = Long.valueOf(sleep) * 1000;
        int limit = 50;
        long offset = 0;
        long minCtime = 0;
        long maxCtime = 0;
        while (!Thread.interrupted()) {
            CJSystem.logging().info(getClass(), String.format("\t开始一轮..."));
            List<UpdateEvent> events = pageEvent(limit, offset);
            if (events.isEmpty()) {
                try {
                    offset = 0;
                    CJSystem.logging().info(getClass(), String.format("\t完成一轮"));
                    Thread.sleep(sleepLong);
                    continue;
                } catch (InterruptedException e) {
                    break;
                }
            }
            CJSystem.logging().info(getClass(), String.format("\t发现更新事件：%s个", events.size()));
            for (UpdateEvent event : events) {
                if (event.getCtime() > maxCtime) {
                    maxCtime = event.getCtime();
                }
                if (event.getCtime() < minCtime) {
                    minCtime = event.getCtime();
                }
                try {
                    doUpdateEvent(event);
                } catch (CircuitException e) {
                    CJSystem.logging().error(getClass(), e);
                }
            }
            removeEvents(minCtime, maxCtime);
            offset += events.size();
        }
        CJSystem.logging().info(getClass(), String.format("\t已退出处理"));
    }

    private void removeEvents(long minCtime, long maxCtime) {
        getHome().deleteDocs(_COL, String.format("{'tuple.ctime':{'$gte':%s},'tuple.ctime':{'$lte':%s}}", minCtime, maxCtime));
    }

    private List<UpdateEvent> pageEvent(int limit, long offset) {
        String cjql = String.format("select {'tuple':'*'}.limit(%s).skip(%s) from tuple %s %s where {}", limit, offset, _COL, UpdateEvent.class.getName());
        IQuery<UpdateEvent> query = getHome().createQuery(cjql);
        List<IDocument<UpdateEvent>> documents = query.getResultList();
        List<UpdateEvent> events = new ArrayList<>();
        for (IDocument<UpdateEvent> document : documents) {
            events.add(document.tuple());
        }
        return events;
    }

    private void doUpdateEvent(UpdateEvent event) throws CircuitException {
        switch (event.getEvent()) {
            case "update-balance":
                onUpdateBalance(event);
                break;
            case "update-state"://更新营业状态
                onUpdateState(event);
                break;
            case "update-location":
                onUpdateLocation(event);
                break;
            case "add-prop-tag":
                onAddPropTag(event);
                break;
            case "remove-prop-tag":
                onRemovePropTag(event);
                break;
            case "add-limit-tag":
                onAddLimitTag(event);
                break;
            case "remove-limit-tag":
                onRemoveLimitTag(event);
                break;
            case "set-limit-area":
                onSetLimitArea(event);
                break;
            case "empty-limit-area":
                onEmptyLimitArea(event);
                break;
            default:
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t不支持更新事件：%s", event.getEvent()));
                break;
        }
    }


    private void onRemovePropTag(UpdateEvent event) {
        Map<String, Object> data = event.getData();
        String tagId = (String) data.get("tagId");
        Tag tag = tagService.getTag(tagId);
        if (tag == null) {
            return;
        }
        CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在标签：%s", event.getPerson(), tag.getName()));
        jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_TAG, tagId), event.getPerson());
    }

    private void onAddPropTag(UpdateEvent event) {
        Map<String, Object> data = event.getData();
        String tagId = (String) data.get("tagId");
        Tag tag = tagService.getTag(tagId);
        if (tag == null) {
            return;
        }
        CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到标签：%s", event.getPerson(), tag.getName()));
        CashierBalance balance = cashierBalanceService.getBalance(event.getPerson());
        jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_TAG, tagId), balance.getBalance(), event.getPerson());
    }

    private void onRemoveLimitTag(UpdateEvent event) {
        Map<String, Object> data = event.getData();
        String tagId = (String) data.get("tagId");
        Tag tag = tagService.getTag(tagId);
        if (tag == null) {
            return;
        }
        CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在限定标签：%s", event.getPerson(), tag.getName()));
        jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_TAG, tagId), event.getPerson());
    }

    private void onAddLimitTag(UpdateEvent event) {
        Map<String, Object> data = event.getData();
        String tagId = (String) data.get("tagId");
        Tag tag = tagService.getTag(tagId);
        if (tag == null) {
            return;
        }
        CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到限定标签：%s", event.getPerson(), tag.getName()));
        CashierBalance balance = cashierBalanceService.getBalance(event.getPerson());
        jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_TAG, tagId), balance.getBalance(), event.getPerson());
    }

    private void onEmptyLimitArea(UpdateEvent event) {
        Map<String, Object> data = event.getData();
        String direct = (String) data.get("direct");
        String type = (String) data.get("type");
        String title = (String) data.get("title");
        String value = (String) data.get("value");
        switch (type) {
            case "province":
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在限定省：%s", event.getPerson(), title));
                jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_AREA_PROVINCE, value), event.getPerson());
                break;
            case "city":
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在限定市：%s", event.getPerson(), title));
                jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_AREA_CITY, value), event.getPerson());
                break;
            case "district":
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在限定区县：%s", event.getPerson(), title));
                jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_AREA_DISTRICT, value), event.getPerson());
                break;
        }
    }

    private void onSetLimitArea(UpdateEvent event) {
        Map<String, Object> data = event.getData();
        String title = (String) data.get("title");
        String type = (String) data.get("type");
        String value = (String) data.get("value");
        CashierBalance cashierBalance = cashierBalanceService.getBalance(event.getPerson());
        long balance = cashierBalance.getBalance();
        switch (type) {
            case "province":
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到限定省：%s", event.getPerson(), title));
                jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_PROVINCE, value), balance, event.getPerson());
                break;
            case "city":
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到限定市：%s", event.getPerson(), title));
                jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_CITY, value), balance, event.getPerson());
                break;
            case "district":
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到限定区县：%s", event.getPerson(), title));
                jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_DISTRICT, value), balance, event.getPerson());
                break;
        }
    }

    private void onUpdateLocation(UpdateEvent event) throws CircuitException {
        //判断行政区是否为空，为空则通过高德设置；不为空则重建索引
        Person person = personService.getPerson(event.getPerson());
        if (person == null) {
            return;
        }
        Map<String, Object> data = event.getData();
        Object longitude = data.get("longitude");
        Object latitude = data.get("latitude");
        Map<String, Object> recodes = getRecodeByAmap(longitude, latitude);
//        System.out.println("高德返回：" + recodes);
        Map<String, Object> geoMap = (Map<String, Object>) recodes.get("regeocode");
        Map<String, Object> comp = (Map<String, Object>) geoMap.get("addressComponent");
        String province = null;
        if (!(comp.get("province") instanceof List)) {
            province = (String) comp.get("province");
        }
        String city = null;
        if (!(comp.get("city") instanceof List)) {
            city = (String) comp.get("city");
        }
        String district = null;
        if (!(comp.get("district") instanceof List)) {
            district = (String) comp.get("district");
        }
        Map<String, Object> gisCodes = personInfoService.getGisReCodes();
        String provinceCode = (String) gisCodes.get(province);
        String cityCode = null;
        if (!StringUtil.isEmpty(city)) {
            cityCode = (String) gisCodes.get(String.format("%s,%s", province, city));
        }
        String districtCode = null;
        if (!StringUtil.isEmpty(city) && !StringUtil.isEmpty(district)) {
            districtCode = (String) gisCodes.get(String.format("%s,%s,%s", province, city, district));
        }
        if (!StringUtil.isEmpty(provinceCode) && !provinceCode.equals(person.getProvinceCode())) {
            personService.updateProvince(person.getId(), province, provinceCode);

            if (!StringUtil.isEmpty(person.getProvince())) {
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在省：%s", event.getPerson(), person.getProvince()));
                jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_AREA_PROVINCE, person.getProvinceCode()), event.getPerson());
            }

            person.setProvince(province);
            person.setProvinceCode(provinceCode);

            CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到省：%s", event.getPerson(), province));
            CashierBalance balance = cashierBalanceService.getBalance(person.getId());
            jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_PROVINCE, provinceCode), balance.getBalance(), event.getPerson());
        }
        if (!StringUtil.isEmpty(cityCode) && !cityCode.equals(person.getCityCode())) {
            personService.updateCity(person.getId(), city, cityCode);

            if (!StringUtil.isEmpty(person.getProvince()) && !StringUtil.isEmpty(person.getCity())) {
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在市：%s", event.getPerson(), String.format("%s·%s", person.getProvince(), person.getCity())));
                jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_AREA_CITY, String.format("%s·%s", person.getProvinceCode(), person.getCityCode())), event.getPerson());
            }

            person.setCity(city);
            person.setCityCode(cityCode);

            CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到市：%s", event.getPerson(), String.format("%s·%s", province, city)));
            CashierBalance balance = cashierBalanceService.getBalance(person.getId());
            jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_CITY, String.format("%s·%s", provinceCode, cityCode)), balance.getBalance(), event.getPerson());
        }
        if (!StringUtil.isEmpty(districtCode) && !districtCode.equals(person.getDistrictCode())) {
            personService.updateDistrict(person.getId(), district, districtCode);

            if (!StringUtil.isEmpty(person.getProvince()) && !StringUtil.isEmpty(person.getCity()) && !StringUtil.isEmpty(person.getDistrict())) {
                CJSystem.logging().info(getClass(), String.format("\t\t\t\t清除用户：%s 索引在区县：%s", event.getPerson(), String.format("%s·%s·%s", person.getProvince(), person.getCity(), person.getDistrict())));
                jedisCluster.zrem(String.format("%s.%s", _KEY_POOL_AREA_DISTRICT, String.format("%s·%s·%s", person.getProvinceCode(), person.getCityCode(), person.getDistrictCode())), event.getPerson());
            }

            person.setDistrict(district);
            person.setDistrictCode(districtCode);

            CJSystem.logging().info(getClass(), String.format("\t\t\t\t建立用户：%s 索引到区县：%s", event.getPerson(), String.format("%s·%s·%s", province, city, district)));
            CashierBalance balance = cashierBalanceService.getBalance(person.getId());
            jedisCluster.zadd(String.format("%s.%s", _KEY_POOL_AREA_DISTRICT, String.format("%s·%s·%s", provinceCode, cityCode, districtCode)), balance.getBalance(), event.getPerson());
        }
        CJSystem.logging().info(getClass(), String.format("\t\t\t\t已更新用户：%s 位置", person.getNickName()));
    }


    private void onUpdateState(UpdateEvent event) {
        //如果状态变为营业，则建立索引，否则移除索引
        Map<String, Object> data = event.getData();
        int state = Double.valueOf(data.get("state") + "").intValue();
        if (state == 0) {
            reindexPerson(event.getPerson());
        } else {
            emptyPersonIndex(event.getPerson());
        }
    }

    private void onUpdateBalance(UpdateEvent event) {
        //如果小于临界值，则从各索引库中移除
        //由于各索引集合需要按balance进行排序，所以每次余额更新都要重建用户在各个集合中的索引
//        Map<String, Object> data = event.getData();
//        long balance = Double.valueOf(data.get("balance")+"").longValue();
//        String openedAmount = site.getProperty("recommender.user.opened.amount");
//        if (StringUtil.isEmpty(openedAmount)) {
//            openedAmount = "60";
//        }
//        if (balance < Long.valueOf(openedAmount)) {
        emptyPersonIndex(event.getPerson());
        reindexPerson(event.getPerson());
//        }
    }

    private void reindexPerson(String person) {
        PersonInfo info = personInfoService.load(person);
        if (info == null) {
            return;
        }
        CJSystem.logging().info(getClass(), String.format("\t\t\t重建用户：%s索引...", info.getPerson().getNickName()));
        personInfoService.indexPerson(info);
    }

    private void emptyPersonIndex(String person) {
        PersonInfo info = personInfoService.load(person);
        if (info == null) {
            return;
        }
        personInfoService.emptyPersonIndex(info);
    }

    Map<String, Object> getRecodeByAmap(Object longitude, Object latitude) throws CircuitException {
        String amapKey = site.getProperty("amap.key");
        String url = String.format("https://restapi.amap.com/v3/geocode/regeo?key=%s&location=%s,%s&poitype=&radius=50&extensions=base&batch=false&roadlevel=0",
                amapKey, longitude, latitude
        );
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call call = client.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        if (response.code() >= 400) {
            throw new CircuitException("1002", String.format("远程访问失败:%s", response.message()));
        }
        String json = null;
        try {
            json = response.body().string();
        } catch (IOException e) {
            throw new CircuitException("1002", e);
        }
        return new Gson().fromJson(json, HashMap.class);
    }
}
