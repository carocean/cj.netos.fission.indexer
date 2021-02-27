package cj.netos.fission;

import cj.netos.fission.model.Person;

import java.util.List;

public interface IPersonService {
    public  static  String _KEY_COL="fission.mf.persons";
    void createGeoIndex();

    List<Person> page(int limit, long offset);

}
