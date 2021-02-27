package cj.netos.fission.model;

import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.Map;

/**
 * Table: person
 */
public class Person {

    /**
     * Column: id
     * Remark: 微信用户的unionid
     */
    private String id;

    /**
     * Column: nick_name
     * Remark: 用户昵称
     */
    private String nickName;

    /**
     * Column: avatar_url
     * Remark: 用户头像图片的 URL。URL 最后一个数值代表正方形头像大小（有 0、46、64、96、132 数值可选，0 代表 640x640 的正方形头像，46 表示 46x46 的正方形头像，剩余数值以此类推。默认132），用户没有头像时该项为空。若用户更换头像，原有头像 URL 将失效
     */
    private String avatarUrl;

    /**
     * Column: gender
     * Remark: 0	未知	 1	男性	 2	女性
     */
    private Integer gender;

    /**
     * Column: country
     */
    private String country;

    /**
     * Column: province
     */
    private String province;
    private String provinceCode;
    /**
     * Column: city
     */
    private String city;
    private String cityCode;
    /**
     * Column: district
     */
    private String district;
    private String districtCode;
    /**
     * Column: town
     */
    private String town;
    private String townCode;
    /**
     * Column: location
     */
    private LatLng location;

    /**
     * Column: language
     * Remark: en	英文	 zh_CN	简体中文	 zh_TW	繁体中文
     */
    private String language;

    /**
     * Column: ctime
     */
    private String ctime;
    private String openid;

    public static Person parse(Map<String, Object> subject, Map<String, Object> token) {
        Person person = new Person();
        person.id = (String) subject.get("accountCode");
        person.nickName = (String) subject.get("nickName");
        person.avatarUrl = (String) subject.get("avatar");
        String sex=(String) subject.get("sex");
        int gender=0;
        if ("male".equals(sex)) {
            gender=1;
        }else if ("female".equals(sex)) {
            gender=2;
        }

        person.gender = gender;
        person.country = (String) subject.get("country");
        person.province = (String) subject.get("province");
        person.district = (String) subject.get("district");
        person.town = (String) subject.get("town");
        person.language = (String) subject.get("language");
        person.ctime = (String) subject.get("ctime");
        person.openid = (String) subject.get("openid");
        return person;
    }

    public static Person load(Map<String, Object> tuple) {
        String json = new Gson().toJson(tuple);
        return new Gson().fromJson(json, Person.class);
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location ;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }
}