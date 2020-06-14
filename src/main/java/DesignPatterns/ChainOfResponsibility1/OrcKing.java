package DesignPatterns.ChainOfResponsibility1;

import DesignPatterns.ChainOfResponsibility1.handlers.OrcCommander;
import DesignPatterns.ChainOfResponsibility1.handlers.OrcOfficer;
import DesignPatterns.ChainOfResponsibility1.handlers.OrcSoldier;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class OrcKing {
    RequestHandler chain;

    public OrcKing() {
        buildChain();
    }

    private void buildChain() {
        chain = new OrcCommander(new OrcOfficer(new OrcSoldier(null)));
    }

    public void makeRequest(Request req) {
        chain.handleRequest(req);
    }
}
