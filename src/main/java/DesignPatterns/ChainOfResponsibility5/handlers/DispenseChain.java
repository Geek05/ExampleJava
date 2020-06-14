package DesignPatterns.ChainOfResponsibility5.handlers;

import DesignPatterns.ChainOfResponsibility5.domain.Currency;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public interface DispenseChain {
    void dispense(Currency cur);
    void setNextChain(DispenseChain nextChain);
}