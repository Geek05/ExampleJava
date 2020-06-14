package DesignPatterns.ChainOfResponsibility3;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public interface CalculatorChain {
    void calculate(Numbers numbers);
    void nextCalculatorChain(CalculatorChain nextChain);
}
