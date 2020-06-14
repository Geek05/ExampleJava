package DesignPatterns.ChainOfResponsibility4.actions;

import DesignPatterns.ChainOfResponsibility4.ServiceRequest;
import DesignPatterns.ChainOfResponsibility4.SupportServiceItf;

import java.util.Objects;

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
        switch(Objects.requireNonNull(request.getCurrentServiceLevel())){
            case LEVEL_ONE:
                handler = new FrontDeskSupport();
                break;
            case LEVEL_TWO:
                handler = new SupervisorSupport();
                break;
            case LEVEL_THREE:
                handler = new ManagerSupport();
                break;
            case LEVEL_FOUR:
                handler = new DirectorSupport();
                break;
        }
        handler.handleRequest(request);
    }
}