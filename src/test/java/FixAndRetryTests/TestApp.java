package FixAndRetryTests;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author Bharath.MC
 * @since Jul-2020
 */
@Listeners(DataIssueListner.class)
public class TestApp {
    public final Integer Expected_Minimum_Age = 20;

    @Test(retryAnalyzer = RetryTests.class)
    public void TestApplication() {
        Assert.assertEquals(SampleDataBase.GetAgeFromDataBase(), Expected_Minimum_Age,
                "Minimum allowed age is not as expected by the Application");
    }
}
