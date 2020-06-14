package DesignPatterns.ChainOfResponsibility3.actions;

import DesignPatterns.ChainOfResponsibility3.ArthematicOperations;
import DesignPatterns.ChainOfResponsibility3.CalculatorChain;
import DesignPatterns.ChainOfResponsibility3.Numbers;

import java.util.Objects;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class DivisionOperation implements CalculatorChain {
    CalculatorChain nextCalculatorChain;

    @Override
    public void calculate(Numbers numbers) {
        if(numbers.getArthematicOperations().equals(ArthematicOperations.DIVIDE)){
            System.out.println(numbers.getNumber1()+" "+ArthematicOperations.DIVIDE+" "+numbers.getNumber2()+" = "+
                    (numbers.getNumber1() / numbers.getNumber2()));
        }else{
            if(Objects.isNull(nextCalculatorChain)) {
                nextCalculatorChain.calculate(numbers);
            }else {
                System.out.println("Reached final state.");
            }
        }
    }

    @Override
    public void nextCalculatorChain(CalculatorChain nextCalculatorChain) {
        this.nextCalculatorChain = nextCalculatorChain;
    }
}
