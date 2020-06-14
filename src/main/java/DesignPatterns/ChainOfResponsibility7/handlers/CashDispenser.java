package DesignPatterns.ChainOfResponsibility7.handlers;

import DesignPatterns.ChainOfResponsibility7.domain.Currency;

/**
 * @author Bharath.MC
 * @since Jan-2020
 */
public class CashDispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void dispense(Currency cur) {
        this.chain.dispense(cur);
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        System.out.println(nextChain);
        this.chain = nextChain;
    }
}
