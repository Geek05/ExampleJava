package DesignPatterns.ChainOfResponsibility3.actions;

import DesignPatterns.ChainOfResponsibility3.ArthematicOperations;
import DesignPatterns.ChainOfResponsibility3.CalculatorChain;
import DesignPatterns.ChainOfResponsibility3.Numbers;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class CalcService implements CalculatorChain {
    CalculatorChain nextCalculatorChain;

    @Override
    public void calculate(Numbers numbers) {
        if (numbers.getArthematicOperations().equals(ArthematicOperations.ADDITION)) {
            nextCalculatorChain = new AddOperation();
        }else if (numbers.getArthematicOperations().equals(ArthematicOperations.SUBTRACT)) {
            nextCalculatorChain = new SubOperation();
        }else if (numbers.getArthematicOperations().equals(ArthematicOperations.MULTIPLY)) {
            nextCalculatorChain = new MultiplyOperation();
        }else if (numbers.getArthematicOperations().equals(ArthematicOperations.DIVIDE)) {
            nextCalculatorChain = new DivisionOperation();
        }
        nextCalculatorChain.calculate(numbers);
    }

    @Override
    public void nextCalculatorChain(CalculatorChain nextChain) {
        nextCalculatorChain = nextChain;
    }
}
