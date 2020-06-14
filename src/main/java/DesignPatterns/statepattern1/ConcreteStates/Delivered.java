package DesignPatterns.statepattern1.ConcreteStates;

import DesignPatterns.statepattern1.DeliveryContext;
import DesignPatterns.statepattern1.PackageState;

/**
 * @author Bharath.MC
 * @since Nov-2019
 *
 * Concrete States – The classes which contain the state specific behavior.
 */
public class Delivered implements PackageState
{
    //Singleton
    private static Delivered instance = new Delivered();

    private Delivered() {}

    public static Delivered instance() {
        return instance;
    }

    //Business logic
    @Override
    public void updateState(DeliveryContext ctx)
    {
        System.out.println("Package is delivered!!");
    }
}