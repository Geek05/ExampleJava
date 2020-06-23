package jenkins.utils;

import java.util.Objects;

/**
 * @author Bharath.MC
 * @since Jun-2020
 */
public interface JenkinsJobInitilizer {
    default String GetSystemProperty(String propertyName, String defaultValue){
        String propertyValue = System.getProperty(propertyName);
        if(Objects.isNull(propertyValue))
            propertyValue = System.getenv(propertyName);
        return Objects.nonNull(propertyValue) ? propertyValue : defaultValue;
    }
}
