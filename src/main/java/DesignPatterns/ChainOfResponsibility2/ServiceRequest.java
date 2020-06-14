package DesignPatterns.ChainOfResponsibility2;

import lombok.Data;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
@Data
public class ServiceRequest {
    private ServiceLevel type;
    private String conclusion = null;
}