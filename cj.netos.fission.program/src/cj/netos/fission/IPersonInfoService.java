package cj.netos.fission;

import cj.netos.fission.model.Person;
import cj.netos.fission.model.PersonInfo;
import cj.studio.ecm.net.CircuitException;

public interface IPersonInfoService {


    void createGeoIndex();

    void indexAll();

    PersonInfo loadPersonInfo(Person person);

    void emptyIndexAll() throws CircuitException;

}
