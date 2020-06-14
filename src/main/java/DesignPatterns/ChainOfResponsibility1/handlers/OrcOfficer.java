package DesignPatterns.ChainOfResponsibility1.handlers;

import DesignPatterns.ChainOfResponsibility1.Request;
import DesignPatterns.ChainOfResponsibility1.RequestHandler;
import DesignPatterns.ChainOfResponsibility1.RequestType;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class OrcOfficer  extends RequestHandler {
    public OrcOfficer(RequestHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest(Request req) {
        if (req.getRequestType().equals(RequestType.TORTURE_PRISONER)) {
            printHandling(req);
            req.markHandled(false);
        } else {
            super.handleRequest(req);
        }
    }

    @Override
    public String toString() {
        return "Orc Officer";
    }
}
