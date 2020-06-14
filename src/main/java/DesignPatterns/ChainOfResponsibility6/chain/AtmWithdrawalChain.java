package DesignPatterns.ChainOfResponsibility6.chain;

import DesignPatterns.ChainOfResponsibility6.command.FiftyDenominationDispenser;
import DesignPatterns.ChainOfResponsibility6.command.HundredDenominationDispenser;
import DesignPatterns.ChainOfResponsibility6.command.TenDenominationDispenser;
import org.apache.commons.chain.impl.ChainBase;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class AtmWithdrawalChain extends ChainBase {

    public AtmWithdrawalChain() {
        super();
        addCommand(new HundredDenominationDispenser());
        addCommand(new FiftyDenominationDispenser());
        addCommand(new TenDenominationDispenser());
        addCommand(new AuditFilter());
    }
}