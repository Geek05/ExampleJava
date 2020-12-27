package excersise.Questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class UniqueQuestions {

    //Product of all elements except the mentioned index value
    public static void ProductOfArray2() {
        int[] array = new int[]{10, 3, 5, 6, 3, 2};
        int[] productArray = new int[array.length];
        int excludeIndex = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            product = 1;
            excludeIndex = i;
            for (int j = 0; j < array.length; j++) {
                if (excludeIndex != j) {
                    product = product * array[j];
                    System.out.print(array[j] + " ");
                }
            }
            productArray[i] = product;
        }
        System.out.println(Arrays.toString(productArray));
    }

    /**
     * Boyersmore algorithm
     * Thisiscoolandsimplesentencewheresimpleisverysimpleandcool
     */
    public static void searchText() {
        String input = "Thisiscoolandsimplesentencewheresimpleisverysimpleandcool";
        String token = "simple";
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            k = 0;
            for (int j = 0; j < token.length(); j++) {
                if (token.charAt(j) == input.charAt(i + k)) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == token.length())
                System.out.println("Token found at index " + i);
        }
    }

    /**
     * print duplicate characters from a string
     */
    public static void printDuplicates() {
        String input = "Programming";
        input = input.toLowerCase();
        String duplicates = "";
        Set<Character> unique = new HashSet<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (!unique.contains(input.charAt(i))) {
                unique.add(input.charAt(i));
            } else {
                duplicates += input.charAt(i);
            }
        }
        System.out.println(duplicates);
    }

    /**
     * strings are anagrams
     */
    public static void anagrams() {
        String input1 = "made for Each Other";
        String input2 = "Each for Made Other";
        input1 = input1.trim().toLowerCase();
        input2 = input2.trim().toLowerCase();
        StringBuilder input2sb = new StringBuilder(input2);
        for (int i = 0; i < input1.toCharArray().length; i++) {
            if (input2sb.indexOf(String.valueOf(input1.charAt(i))) == -1) {
                System.out.println("Strings are not anagrams!");
                return;
            } else {
                input2sb.deleteCharAt(input2sb.indexOf(String.valueOf(input1.charAt(i))));
            }
        }
        if (input2sb.length() == 0) {
            System.out.println("Strings are anagrams!");
            return;
        }
    }

    /**
     * string be reversed using recursion
     */
    public static String reverse(String input) {
        if (input.length() <= 0)
            return "";
        return reverse(input.substring(1)) + input.charAt(0);
    }

    /**
     * check if a string contains only digits
     * -1123.4 , -11234 , 12.34, 1234. , .1234, .1234. , 1.2.3.4 , 123..4 , 11234
     */
    public static void checkStringContainsDigits(String input) {
        //input = "12.345";
        boolean charFound = false;
        char current = input.charAt(0);
        char previous = current;
        int inputLength = input.toCharArray().length;

        if (input.split("\\.").length > 2) {
            charFound = true;
        } else {
            for (int i = 0; i < inputLength; i++) {
                current = input.charAt(i);
                if (current == '.') {
                    if (isDigit(previous) &&
                            i + 1 < inputLength && isDigit(input.charAt(i + 1))) {
                        continue;
                    } else {
                        charFound = true;
                        break;
                    }
                } else if (current == '-') {
                    if (i != 0) {
                        charFound = true;
                        break;
                    } else
                        continue;
                }
                if (!(isDigit(current))) {
                    charFound = true;
                    break;
                }
                previous = current;
            }
        }
        if (charFound)
            System.out.println(input + " Contains characters as well");
        else
            System.out.println(input + " Contains only Digits");

    }

    public static boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    /**
     * occurrence of a given character in a string
     * aaabbccd : a3b2c2d1
     */
    public static void stringCompression() {
        String input = "aaabbccda";
        String output = "";
        int count = 0;
        char current = input.charAt(0);
        for (int i = 0; i < input.length(); i++) {
            if (current != input.charAt(i)) {
                output = output + current + count;
                current = input.charAt(i);
                count = 1;
                if (i == input.length() - 1)
                    output = output + current + count;
            } else {
                count++;
            }
        }
        System.out.println(output);
    }

    /**
     * remove the duplicate character from String
     */
    public static void removeDuplicateCharacterFromString() {
        String input = "Programming";
        input = input.trim().toLowerCase();
        String uniqueString = "";
        for (int i = 0; i < input.length(); i++) {
            if (uniqueString.indexOf(input.charAt(i)) == -1) {
                uniqueString = uniqueString + input.charAt(i);
            }
        }
        System.out.println("UniqueString = " + uniqueString);
    }

    /**
     * longest substring without repeating characters
     */
    public static void longestUniqueSubstring() {

    }

    /**
     * longest palindromic substring in str
     */
    public static void longestPalindromicSubstring() {

    }

    public static void main(String[] args) {
    }

}
