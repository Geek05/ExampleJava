package DesignPatterns.ChainOfResponsibility4.actions;

import DesignPatterns.ChainOfResponsibility4.ServiceRequest;
import DesignPatterns.ChainOfResponsibility4.SupportServiceItf;
import DesignPatterns.ChainOfResponsibility4.domain.ServiceLevel;

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

        if (!request.getServiceLevel().equals(request.getCurrentServiceLevel()) || next == null) {
            System.out.println("THis is Level One, moving it to level one state");
            request.setCurrentServiceLevel(ServiceLevel.LEVEL_FOUR);
        }

        if (request.getServiceLevel() == ServiceLevel.LEVEL_FOUR) {
            request.setConclusion("Director solved level four reuqest !!");
        } else {
            if (next != null) {
                System.out.println("This request was not solved at Level Four, moving to " + request.getServiceLevel() + " , current level " + request.getCurrentServiceLevel());
                next.handleRequest(request);
            } else {
                request.setConclusion("You problem is none of our business");
                throw new IllegalArgumentException("You problem is none of our business :: " + request.getServiceLevel());
            }
        }
    }
}
