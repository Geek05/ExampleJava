package DesignPatterns.ChainOfResponsibility4.actions;

import DesignPatterns.ChainOfResponsibility4.domain.ServiceLevel;
import DesignPatterns.ChainOfResponsibility4.ServiceRequest;
import DesignPatterns.ChainOfResponsibility4.SupportServiceItf;

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

        if(!request.getServiceLevel().equals(request.getCurrentServiceLevel())){
            System.out.println("THis is Level Three, moving it to level three state");
            request.setCurrentServiceLevel(ServiceLevel.LEVEL_THREE);
        }

        if(request.getServiceLevel() == ServiceLevel.LEVEL_THREE) {
            request.setConclusion("Manager solved level three reuqest !!");
        }
        else {
            if(next != null){
                System.out.println("This request was not solved at Level Three, moving to "+request.getServiceLevel() +" , current level "+request.getCurrentServiceLevel());
                next.handleRequest(request);
            }
            else {
                throw new IllegalArgumentException("No handler found for :: " + request.getServiceLevel());
            }
        }
    }
}
