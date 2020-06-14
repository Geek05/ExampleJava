package DesignPatterns.StatePattern2;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class TVRemote {
    public static void main(String[] args) {
        TVContext tvContext = new TVContext();
        tvContext.setState(new TVStartState());
        tvContext.doAction();
        tvContext.setState(new TVStopState());
        tvContext.doAction();
    }
}
