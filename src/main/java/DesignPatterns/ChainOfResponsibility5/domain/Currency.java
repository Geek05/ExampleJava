package DesignPatterns.ChainOfResponsibility5.domain;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class Currency {

    private int amount;

    public Currency(int amt) {
        this.amount = amt;
    }

    public int getAmount() {
        return this.amount;
    }
}
