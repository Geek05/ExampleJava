package DesignPatterns.ChainOfResponsibility2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class SupportService implements SupportServiceItf {

    private SupportServiceItf handler = new FrontDeskSupport();

    public SupportServiceItf getHandler() {
        return handler;
    }

    public void setHandler(SupportServiceItf handler) {
        this.handler = handler;
    }

    @Override
    public void handleRequest(ServiceRequest request) {
        System.out.println("Handling request "+request);
        handler.handleRequest(request);
    }
}