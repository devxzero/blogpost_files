package net.contextfw.benchmark;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebStart {

    private static final int HTTP_PORT = 8080;
    private static final String WAR_PATH = "src/main/webapp";
    private static final String CONTEXT_PATH = "/";

    public static void main(String[] args) throws Exception {
        
        Server server = new Server();
        
        WebAppContext wac = new WebAppContext();
        wac.setContextPath(CONTEXT_PATH);
        wac.setWar(WAR_PATH);
        server.setHandler(wac);
        
        SelectChannelConnector scc = new SelectChannelConnector();
        scc.setPort(HTTP_PORT);
        server.addConnector(scc);
        server.start();
    }
}