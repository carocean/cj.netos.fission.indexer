package cj.netos.fission.program;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;

/**
 * @author caroceanjofers
 */
@CjService(name = "/home.html")
public class Home implements IGatewayAppSiteWayWebView {

    @Override
    public void flow(Frame frame, Circuit circuit, IGatewayAppSiteResource resource) throws CircuitException {

        circuit.content().writeBytes("800 拒绝访问".getBytes());
    }

}
