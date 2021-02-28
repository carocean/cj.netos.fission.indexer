package cj.netos.fission;

import cj.netos.fission.model.Person;

import java.util.List;

public interface IPersonService {
    public  static  String _KEY_COL="fission.mf.persons";
    void createGeoIndex();

    List<Person> page(int limit, long offset);

    Person getPerson(String person);

    void updateProvince(String id, String province, String provinceCode);

    void updateCity(String id, String city, String cityCode);

    void updateDistrict(String id, String district, String districtCode);

}
