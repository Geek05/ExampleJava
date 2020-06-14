package DesignPatterns.ChainOfResponsibility2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class FrontDeskSupport implements SupportServiceItf {

    private SupportServiceItf next = new SupervisorSupport();
    public SupportServiceItf getNext() {
        return next;
    }
    public void setNext(SupportServiceItf next) {
        this.next = next;
    }

    @Override
    public void handleRequest(ServiceRequest service) {
        if(service.getType() == ServiceLevel.LEVEL_ONE) {
            System.out.println("THis is Level One");
            service.setConclusion("Front desk solved level one reuqest !!");
        }
        else
        {
            if(next != null){
                System.out.println("This request was not solved at Level One, moving to "+service);
                next.handleRequest(service);
            }
            else {
                throw new IllegalArgumentException("No handler found for :: " + service.getType());
            }
        }
    }
}
