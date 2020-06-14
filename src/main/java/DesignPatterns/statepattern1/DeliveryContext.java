package DesignPatterns.statepattern1;

import lombok.Data;
import DesignPatterns.statepattern1.ConcreteStates.Acknowledged;

/**
 * @author Bharath.MC
 * @since Nov-2019
 *
 * Context – Defines an interface to client to interact.
 * It maintains references to concrete state object which may be used to define current state of object.
 * It delegates state-specific behavior to different State objects.
 */
@Data
public class DeliveryContext {
    private PackageState currentState;
    private String packageId;

    public DeliveryContext(PackageState currentState, String packageId) {
        super();
        this.currentState = currentState;
        this.packageId = packageId;

        if(currentState == null) {
            this.currentState = Acknowledged.instance();
        }
    }

    public void update() {
        currentState.updateState(this);
    }
}
