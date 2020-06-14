package DesignPatterns.ChainOfResponsibility2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class SupervisorSupport implements SupportServiceItf {

    private SupportServiceItf next = new ManagerSupport();
    public SupportServiceItf getNext() {
        return next;
    }
    public void setNext(SupportServiceItf next) {
        this.next = next;
    }

    @Override
    public void handleRequest(ServiceRequest request) {
        if(request.getType() == ServiceLevel.LEVEL_TWO) {
            request.setConclusion("Supervisor solved level two reuqest !!");
        }else if (request.getType() == ServiceLevel.REJECTED_AT_LEVEL_TWO){
            request.setConclusion("Supervisor Rejected at level two reuqest !!");
        }
        else
        {
            if(next != null){
                System.out.println("This request was not solved at Level Two, moving to "+request);
                next.handleRequest(request);
            }
            else {
                throw new IllegalArgumentException("No handler found for :: " + request.getType());
            }
        }
    }
}