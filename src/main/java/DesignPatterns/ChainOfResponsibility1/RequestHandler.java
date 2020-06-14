package DesignPatterns.ChainOfResponsibility1;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public abstract class RequestHandler {
    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    public void handleRequest(Request req) {
        if (next != null) {
            next.handleRequest(req);
        }
    }

    protected void printHandling(Request req) {
        System.out.println(String.format("%s handling request \"%s\"", this, req));
    }

    @Override
    public abstract String toString();
}
