package FixAndRetryTests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Bharath.MC
 * @since Jul-2020
 */
public class RetryTests implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount++ < maxRetryCount)
            return true;
        return false;
    }
}
