package DesignPatterns.ChainOfResponsibility3;

import DesignPatterns.ChainOfResponsibility3.actions.*;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class TestCOR3 {
    public static void main(String[] args) {

        Numbers numbers = Numbers.builder()
                .number1(20).number2(5)
                .arthematicOperations(ArthematicOperations.DIVIDE)
                .build();

        CalculatorChain calculatorChain = new CalcService();
        calculatorChain.calculate(numbers);
    }
}
