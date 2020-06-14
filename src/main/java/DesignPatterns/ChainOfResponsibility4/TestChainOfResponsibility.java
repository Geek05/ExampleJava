package DesignPatterns.ChainOfResponsibility4;

import DesignPatterns.ChainOfResponsibility4.actions.SupportService;
import DesignPatterns.ChainOfResponsibility4.domain.ServiceLevel;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class TestChainOfResponsibility {
    public static void main(String[] args) {
        ServiceRequest request = new ServiceRequest();
        request.setCurrentServiceLevel(ServiceLevel.LEVEL_ONE);
        request.setServiceLevel(ServiceLevel.LEVEL_THREE);
        SupportService supportService = new SupportService();
        supportService.handleRequest(request);
        System.out.println(request.getConclusion());
    }
}
