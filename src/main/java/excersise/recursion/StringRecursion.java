package excersise.recursion;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class StringRecursion {

    public static String reverseString(String input) {
        if (input.length() == 0)
            return "";
        return input.charAt(input.length() - 1) + reverseString(input.substring(0, input.length() - 1));
    }

    public static boolean isPalindrome(String input, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex)
            return true;
        if (input.charAt(leftIndex) != input.charAt(rightIndex))
            return false;
        return isPalindrome(input, leftIndex + 1 , rightIndex -1);
    }

    public static void main(String[] args) {
        String input = "apple";
        System.out.println(reverseString(input));
    }
}
