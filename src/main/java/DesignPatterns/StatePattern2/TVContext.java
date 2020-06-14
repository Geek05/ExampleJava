package DesignPatterns.StatePattern2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class TVContext implements State {
    State tvState;

    public void setState(State state) {
        this.tvState=state;
    }

    public State getState() {
        return this.tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }
}
