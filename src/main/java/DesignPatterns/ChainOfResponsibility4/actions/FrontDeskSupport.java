package DesignPatterns.ChainOfResponsibility4.actions;

import DesignPatterns.ChainOfResponsibility4.domain.ServiceLevel;
import DesignPatterns.ChainOfResponsibility4.ServiceRequest;
import DesignPatterns.ChainOfResponsibility4.SupportServiceItf;

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
    public void handleRequest(ServiceRequest request) {

        if(!request.getServiceLevel().equals(request.getCurrentServiceLevel())){
            System.out.println("THis is Level One, moving it to level one state");
            request.setCurrentServiceLevel(ServiceLevel.LEVEL_ONE);
        }

        if(request.getServiceLevel() == ServiceLevel.LEVEL_ONE) {
            System.out.println("THis is Level One");
            request.setConclusion("Front desk solved level one reuqest !!");
        }
        else
        {
            if(next != null){
                System.out.println("This request was not solved at Level One, moving to "+request.getServiceLevel() +" , current level "+request.getCurrentServiceLevel());

                next.handleRequest(request);
            }
            else {
                throw new IllegalArgumentException("No handler found for :: " + request.getServiceLevel());
            }
        }
    }
}
