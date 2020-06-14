package DesignPatterns.statepattern1;

/**
 * @author Bharath.MC
 * @since Nov-2019
 */
public class Main {
    public static void main(String[] args) {
        DeliveryContext ctx = new DeliveryContext(null, "Test123");

        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
        ctx.update();
    }
}
