package DesignPatterns.ChainOfResponsibility4.actions;

import DesignPatterns.ChainOfResponsibility4.domain.ServiceLevel;
import DesignPatterns.ChainOfResponsibility4.ServiceRequest;
import DesignPatterns.ChainOfResponsibility4.SupportServiceItf;

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

        if(!request.getServiceLevel().equals(request.getCurrentServiceLevel())){
            System.out.println("THis is Level two, moving it to level two state");
            request.setCurrentServiceLevel(ServiceLevel.LEVEL_TWO);
        }

        if(request.getServiceLevel() == ServiceLevel.LEVEL_TWO) {
            request.setConclusion("Supervisor solved level two reuqest !!");
        }else if (request.getServiceLevel() == ServiceLevel.REJECTED_AT_LEVEL_TWO){
            request.setConclusion("Supervisor Rejected at level two reuqest !!");
        }
        else
        {
            if(next != null){
                System.out.println("This request was not solved at Level Two, moving to "+request.getServiceLevel() +" , current level "+request.getCurrentServiceLevel());
                next.handleRequest(request);
            }
            else {
                throw new IllegalArgumentException("No handler found for :: " + request.getServiceLevel());
            }
        }
    }
}