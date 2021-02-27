package cj.netos.fission;

import cj.lns.chip.sos.cube.framework.ICube;
import cj.studio.ecm.annotation.CjServiceRef;

public class AbstractService {
    @CjServiceRef(refByName = "mongodb.netos.home")
    ICube home;

    public ICube getHome() {
        return home;
    }
}
