package DesignPatterns.ChainOfResponsibility3.actions;

import DesignPatterns.ChainOfResponsibility3.ArthematicOperations;
import DesignPatterns.ChainOfResponsibility3.CalculatorChain;
import DesignPatterns.ChainOfResponsibility3.Numbers;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class MultiplyOperation implements CalculatorChain {
    CalculatorChain nextCalculatorChain;

    @Override
    public void calculate(Numbers numbers) {
        if(numbers.getArthematicOperations().equals(ArthematicOperations.MULTIPLY)){
            System.out.println(numbers.getNumber1()+" "+ArthematicOperations.MULTIPLY+" "+numbers.getNumber2()+" = "+
                    (numbers.getNumber1() * numbers.getNumber2()));
        }else{
            nextCalculatorChain = new DivisionOperation();
            nextCalculatorChain.calculate(numbers);
        }
    }

    @Override
    public void nextCalculatorChain(CalculatorChain nextCalculatorChain) {
        this.nextCalculatorChain = new DivisionOperation();
    }
}
