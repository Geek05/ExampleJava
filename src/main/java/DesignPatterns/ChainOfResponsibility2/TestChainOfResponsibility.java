package DesignPatterns.ChainOfResponsibility2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class TestChainOfResponsibility {
    public static void main(String[] args) {
        ServiceRequest request = new ServiceRequest();
        request.setType(ServiceLevel.LEVEL_THREE);
        SupportService supportService = new SupportService();
        supportService.handleRequest(request);
        System.out.println(request.getConclusion());
    }
}
