package TestJenkins;

import jenkins.utils.JenkinsJobInitilizer;
import org.testng.annotations.Test;

import java.lang.ref.SoftReference;

/**
 * @author Bharath.MC
 * @since Jun-2020
 */
public class TestJenkins implements JenkinsJobInitilizer {

    @Test
    public void testJenkinsArgs() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(String.format("This is invoked from Jenkins job and the current Phase is [%s]",
                GetSystemProperty("CurrentPhase", "Property 'CurrentPhase' Not Found")));
        System.out.println("------------------------------------------------------------------------");
    }
}
