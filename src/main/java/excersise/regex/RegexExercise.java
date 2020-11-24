package excersise.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class RegexExercise {

    public static void regexExample(){
        String EXAMPLE_TEST = "This is my small 18 example string which I'm going to singing use for pattern matching.";
        Pattern pattern = Pattern.compile("\\b");
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args) {
        regexExample();
    }
}
