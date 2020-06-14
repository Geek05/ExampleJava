package DesignPatterns.ChainOfResponsibility7.handlers;


import DesignPatterns.ChainOfResponsibility7.domain.Currency;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public interface DispenseChain {
    void dispense(Currency cur);
    void setNextChain(DispenseChain nextChain);
}