package DesignPatterns.ChainOfResponsibility6.context;

import lombok.Data;
import org.apache.commons.chain.impl.ContextBase;

/**
 * @author Bharath.MC
 * @since Dec-2019
 *
 * The context represents the current state of an application, storing information about the transaction.
 *
 * For our ATM withdrawal request, the information we need is:
 *
 * Total amount to be withdrawn
 * Number of 100 denomination notes
 * Number of 50 denomination notes
 * Number of 10 denomination notes
 * Amount left to be withdrawn
 */
@Data
public class AtmRequestContext extends ContextBase {
    int totalAmountToBeWithdrawn;
    int noOfHundredsDispensed;
    int noOfFiftiesDispensed;
    int noOfTensDispensed;
    int amountLeftToBeWithdrawn;
}