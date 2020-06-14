package DesignPatterns.statepattern1.ConcreteStates;

import DesignPatterns.statepattern1.DeliveryContext;
import DesignPatterns.statepattern1.PackageState;

/**
 * @author Bharath.MC
 * @since Nov-2019
 *
 * Concrete States – The classes which contain the state specific behavior.
 */
public class Acknowledged implements PackageState {
    //Singleton
    private static Acknowledged instance = new Acknowledged();

    private Acknowledged() {}

    public static Acknowledged instance() {
        return instance;
    }

    //Business logic and state transition
    @Override
    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Package is acknowledged !!");
        ctx.setCurrentState(Shipped.instance());
    }
}
