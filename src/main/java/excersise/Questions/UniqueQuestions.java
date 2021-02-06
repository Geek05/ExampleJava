package excersise.Questions;

import java.util.*;

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
     * longest substring without repeating characters
     */
    public static void longestUniqueSubstring() {

    }

    /**
     * longest palindromic substring in str
     */
    public static void longestPalindromicSubstring() {

    }

    public static void TabLikeFunctionality() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int switchTabIndex = 3;
        int switchedElement = array[switchTabIndex];
        for (int i = switchTabIndex; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = switchedElement;
        System.out.println(Arrays.toString(array));
    }

    /**
     * Kadane’s Algorithm
     * Find Contiguous subarray with maximum sum
     * INput: {2, -3, 7, -4, 2, 5, -8, 6, -1}
     * Output: {7, -4, 2, 5}
     * Explaination: https://javaconceptoftheday.com/contiguous-subarray-with-maximum-sum-in-java/
     */
    public static void ContiguousSubarrayWithMaximumSum() {
        int[] array = new int[]{2, -3, 7, -4, 2, 5, -8, 6, -1};

        int bestSum = array[0];
        int bestStart = 0;
        int bestEnd = 0;

        int currentSum = 0;
        int currentStart = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum = currentSum + array[i];

            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
            if (currentSum > bestSum) {
                bestSum = currentSum;
                bestStart = currentStart;
                bestEnd = i;
            }
        }

        for (int i = bestStart; i <= bestEnd; i++) {
            System.out.print(array[i] + " , ");
        }
        System.out.println();
    }

    public static void smallestSumSubarr() {
        int[] array = new int[]{3, -4, 2, -3, -1, 7, -5};

        int bestSum = array[0];
        int bestStart = 0;
        int bestEnd = 0;

        int currentSum = 0;
        int currentStart = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum = currentSum + array[i];

            if (currentSum > 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
            if (currentSum < bestSum) {
                bestSum = currentSum;
                bestStart = currentStart;
                bestEnd = i;
            }
        }
        for (int i = bestStart; i <= bestEnd; i++) {
            System.out.print(array[i] + " , ");
        }
        System.out.println();
    }

    /**
     * brakets problem - parse the brackets are right
     * [()](())[[]]
     */
    public static boolean parseBraces(String input) {

        if (input == null || input.isEmpty())
            return true;

        Stack<Character> roundBraces = new Stack<>();
        Stack<Character> squareBraces = new Stack<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (input.charAt(i) == '(') {
                roundBraces.push('(');
                continue;
            } else if (input.charAt(i) == '[') {
                squareBraces.push('[');
                continue;
            } else if (input.charAt(i) == ')') {
                if (roundBraces.isEmpty())
                    return false;
                Character ch = roundBraces.pop();
                if (ch != '(') {
                    return false;
                }
            } else if (input.charAt(i) == ']') {
                if (squareBraces.isEmpty())
                    return false;
                Character ch = squareBraces.pop();
                if (ch != '[') {
                    return false;
                }
            }
        }
        return roundBraces.size() == 0 && squareBraces.size() == 0;
    }

    public static void testParseBraces() {
        System.out.println(parseBraces("[()](())[[]]"));
        System.out.println(parseBraces("[(](())[[]]"));
        System.out.println(parseBraces("()()"));
        System.out.println(parseBraces("([)()]"));
        System.out.println(parseBraces("))(("));
        System.out.println(parseBraces("[)[](]"));
        System.out.println(parseBraces("apple"));
        System.out.println(parseBraces(""));
        System.out.println(parseBraces(null));
    }


    /***
     * Java program to find missing number in an integer array
     * 1, 2, 3, 4, 5, 6
     * sum = n(n+1)/2
     * use binary search algorithm to find it - O(log n)
     */

    public static void main(String[] args) {
        smallestSumSubarr();
    }

}
