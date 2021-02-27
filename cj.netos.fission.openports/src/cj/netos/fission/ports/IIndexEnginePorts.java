package cj.netos.fission.ports;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenports;

@CjOpenports(usage = "索引引擎服务")
public interface IIndexEnginePorts extends IOpenportService {
    @CjOpenport(usage = "重建索引")
    void reindex(ISecuritySession securitySession) throws CircuitException;

    @CjOpenport(usage = "清空索引并立即重建")
    void empty(ISecuritySession securitySession) throws CircuitException;
}
