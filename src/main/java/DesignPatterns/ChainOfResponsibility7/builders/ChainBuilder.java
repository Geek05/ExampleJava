package DesignPatterns.ChainOfResponsibility7.builders;

import DesignPatterns.ChainOfResponsibility7.handlers.*;

/**
 * @author Bharath.MC
 * @since Jan-2020
 */
public class ChainBuilder {
    DispenseChain chainHead = new CashDispenser();
    DispenseChain currentLink = chainHead;
    DispenseChain nextLink = chainHead;

    public static ChainBuilder Builder(){
        return new ChainBuilder();
    }

    public DispenseChain Build(){
        return chainHead;
    }

    public ChainBuilder and(){
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with2kDispenser(){
        nextLink = new Dollar2000Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with1kDispenser(){
        nextLink = new Dollar1000Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with500Dispenser(){
        nextLink = new Dollar500Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with100Dispenser(){
        nextLink = new Dollar100Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with50Dispenser(){
        nextLink = new Dollar50Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with20Dispenser(){
        nextLink = new Dollar20Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }

    public ChainBuilder with10Dispenser(){
        nextLink = new Dollar10Dispenser();
        currentLink.setNextChain(nextLink);
        currentLink = nextLink;
        return this;
    }
}
