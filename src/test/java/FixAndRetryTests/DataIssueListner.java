package FixAndRetryTests;

import lombok.SneakyThrows;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Arrays;

/**
 * @author Bharath.MC
 * @since Jul-2020
 */
public class DataIssueListner implements ITestListener {

    @Override
    public void onTestSkipped(ITestResult testResult) {
        //Fix the data here (database or Elasticsearch)
        new SampleDataBase().setAge(20);
    }
}
