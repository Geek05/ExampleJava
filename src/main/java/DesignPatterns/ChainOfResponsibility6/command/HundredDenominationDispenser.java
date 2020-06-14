package DesignPatterns.ChainOfResponsibility6.command;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class HundredDenominationDispenser implements Command {

    @Override
    public boolean execute(Context context) throws Exception {
        int amountLeftToBeWithdrawn = (int) context.get("amountLeftToBeWithdrawn");
        if (amountLeftToBeWithdrawn >= 100) {
            context.put("noOfHundredsDispensed", amountLeftToBeWithdrawn / 100);
            context.put("amountLeftToBeWithdrawn", amountLeftToBeWithdrawn % 100);
        }
        return false;
    }
}