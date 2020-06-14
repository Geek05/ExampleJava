package DesignPatterns.ChainOfResponsibility6;

import DesignPatterns.ChainOfResponsibility6.chain.AtmCatalog;
import DesignPatterns.ChainOfResponsibility6.context.AtmRequestContext;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Bharath.MC
 * @since Dec-2019
 *
 * The ATM takes a number as an input and passes it down to handlers responsible for performing different actions.
 * Those involve calculating numbers of bank notes to be dispensed, and sending a notification to the bank and customer about the transaction.
 *
 */
public class ApacheChainsDemo {

    @Test
    public void givenInputsToContext_whenAppliedChain_thenExpectedContext() throws Exception {
        Context context = new AtmRequestContext();
        context.put("totalAmountToBeWithdrawn", 460);
        context.put("amountLeftToBeWithdrawn", 460);

        Catalog catalog = new AtmCatalog();
        Command atmWithdrawalChain = catalog.getCommand("atmWithdrawalChain");

        atmWithdrawalChain.execute(context);

        assertEquals(460, (int) context.get("totalAmountToBeWithdrawn"));
        assertEquals(0, (int) context.get("amountLeftToBeWithdrawn"));
        assertEquals(4, (int) context.get("noOfHundredsDispensed"));
        assertEquals(1, (int) context.get("noOfFiftiesDispensed"));
        assertEquals(1, (int) context.get("noOfTensDispensed"));
    }
}
