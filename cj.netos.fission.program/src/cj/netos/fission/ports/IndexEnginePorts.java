package cj.netos.fission.ports;

import cj.netos.fission.IIndexEngine;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;

@CjService(name = "indexEnginePorts")
public class IndexEnginePorts implements IIndexEnginePorts {
    @CjServiceRef
    IIndexEngine indexEngine;

    private void _checkRights(ISecuritySession securitySession) throws CircuitException {
        if (!securitySession.roleIn("platform:administrators")) {
            throw new CircuitException("800", "拒绝访问");
        }
    }

    @Override
    public void reindex(ISecuritySession securitySession) throws CircuitException {
        _checkRights(securitySession);
        indexEngine.reindex();
    }


    @Override
    public void empty(ISecuritySession securitySession) throws CircuitException {
        _checkRights(securitySession);
        indexEngine.empty();
        indexEngine.reindex();
    }
}
