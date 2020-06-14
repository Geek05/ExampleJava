package DesignPatterns.ChainOfResponsibility7.handlers;


import DesignPatterns.ChainOfResponsibility7.domain.Currency;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class Dollar2000Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 2000) {
            int num = cur.getAmount() / 2000;
            int remainder = cur.getAmount() % 2000;
            System.out.println("Dispensing " + num + " 2000$ note");
            if (remainder != 0) this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }
}