package cj.netos.fission.program;

import cj.netos.fission.IIndexEngine;
import cj.netos.fission.IUpdaterManager;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.gateway.socket.Destination;
import cj.studio.gateway.socket.app.GatewayAppSiteProgram;
import cj.studio.gateway.socket.app.ProgramAdapterType;

@CjService(name = "$.cj.studio.gateway.app", isExoteric = true)
public class AppSiteProgram extends GatewayAppSiteProgram {

    @Override
    protected void onstart(Destination dest, String assembliesHome, ProgramAdapterType type) throws CircuitException {
        IIndexEngine engine = (IIndexEngine) site.getService("indexEngine");
        engine.reindex();
        IUpdaterManager updaterManager= (IUpdaterManager) site.getService("updaterManager");
        updaterManager.start();
    }

}
