package cj.netos.fission;

import cj.netos.fission.model.Person;
import cj.netos.fission.model.PersonInfo;
import cj.studio.ecm.net.CircuitException;

import java.util.Map;

public interface IPersonInfoService {


    Map<String, Object> getGisReCodes() throws CircuitException;

    Map<String, Object> getGisCodes() throws CircuitException;

    void createGeoIndex();

    void indexAll();

    PersonInfo loadPersonInfo(Person person);

    void indexPerson(PersonInfo info);

    void emptyIndexAll() throws CircuitException;

    PersonInfo load(String person);

    void emptyPersonIndex(PersonInfo info);

}
