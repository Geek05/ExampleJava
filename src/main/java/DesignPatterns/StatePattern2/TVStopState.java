package DesignPatterns.StatePattern2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class TVStopState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is in turned OFF.");
    }
}
