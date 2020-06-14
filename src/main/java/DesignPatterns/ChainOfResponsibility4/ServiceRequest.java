package DesignPatterns.ChainOfResponsibility4;

import DesignPatterns.ChainOfResponsibility4.domain.ServiceLevel;
import lombok.Data;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
@Data
public class ServiceRequest {
    private ServiceLevel serviceLevel;
    private String conclusion = null;
    private ServiceLevel currentServiceLevel;
}