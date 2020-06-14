package DesignPatterns.ChainOfResponsibility6.chain;

import org.apache.commons.chain.impl.CatalogBase;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class AtmCatalog extends CatalogBase {

    public AtmCatalog() {
        super();
        addCommand("atmWithdrawalChain", new AtmWithdrawalChain());
    }
}