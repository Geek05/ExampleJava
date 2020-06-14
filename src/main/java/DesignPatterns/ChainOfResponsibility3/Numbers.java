package DesignPatterns.ChainOfResponsibility3;

import lombok.Builder;
import lombok.Data;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
@Data
@Builder
public class Numbers {
    int number1;
    int number2;
    int result;
    ArthematicOperations arthematicOperations;
}
