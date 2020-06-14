package DesignPatterns.ChainOfResponsibility6.chain;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.Filter;

/**
 * @author Bharath.MC
 * @since Dec-2019
 */
public class AuditFilter implements Filter {

    @Override
    public boolean postprocess(Context context, Exception exception) {
        // send notification to bank and user
        return false;
    }

    @Override
    public boolean execute(Context context) throws Exception {
        return false;
    }
}