package DesignPatterns.ChainOfResponsibility2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class DirectorSupport implements SupportServiceItf {

    private SupportServiceItf next = null;
    public SupportServiceItf getNext() {
        return next;
    }
    public void setNext(SupportServiceItf next) {
        this.next = next;
    }

    @Override
    public void handleRequest(ServiceRequest request) {
        if(request.getType() == ServiceLevel.LEVEL_FOUR) {
            request.setConclusion("Director solved level four reuqest !!");
        }
        else
        {
            if(next != null){
                System.out.println("This request was not solved at Level Four, moving to "+request);
                next.handleRequest(request);
            }
            else
            {
                request.setConclusion("You problem is none of our business");
                throw new IllegalArgumentException("You problem is none of our business :: " + request.getType());
            }
        }
    }
}
