package DesignPatterns.ChainOfResponsibility2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class ManagerSupport implements SupportServiceItf {

    private SupportServiceItf next = new DirectorSupport();
    public SupportServiceItf getNext() {
        return next;
    }
    public void setNext(SupportServiceItf next) {
        this.next = next;
    }

    @Override
    public void handleRequest(ServiceRequest request) {
        if(request.getType() == ServiceLevel.LEVEL_THREE)
        {
            request.setConclusion("Manager solved level three reuqest !!");
        }
        else
        {
            if(next != null){
                System.out.println("This request was not solved at Level Three, moving to "+request);
                next.handleRequest(request);
            }
            else {
                throw new IllegalArgumentException("No handler found for :: " + request.getType());
            }
        }
    }
}
