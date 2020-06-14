package DesignPatterns.statepattern1;

/**
 * @author Bharath.MC
 * @since Nov-2019
 *
 * State – The interface define operations which each state must handle.
 */
public interface PackageState {
    void updateState(DeliveryContext ctx);
}
