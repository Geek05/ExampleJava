package DesignPatterns.ChainOfResponsibility1.handlers;

import DesignPatterns.ChainOfResponsibility1.Request;
import DesignPatterns.ChainOfResponsibility1.RequestHandler;
import DesignPatterns.ChainOfResponsibility1.RequestType;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class OrcSoldier extends RequestHandler {
    public OrcSoldier(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.COLLECT_TAX)) {
            printHandling(req);
            req.markHandled(true);
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc Soldier";
    }
}
