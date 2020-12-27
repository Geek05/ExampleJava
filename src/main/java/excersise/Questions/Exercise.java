package excersise.Questions;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class Exercise {

    //Find The Sum of All Digits
    public static void findSumOfAllDigits() {
        int number = 1234;
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        System.out.println(sum);
    }

    //Reverse number
    public static void reverseAllDigits() {
        int number = 1234;
        int reversedNumber = 0;
        while (number > 0) {
            reversedNumber = reversedNumber * 10;
            reversedNumber = reversedNumber + (number % 10);
            number = number / 10;
        }
        System.out.println(reversedNumber);
    }

    /**
     * Check if it is Armstrong number (sum of cubes of each digit is equal to number)
     * 153 is armstrong number
     * (1*1*1) + (5*5*5) + (3*3*3) = 1 + 125 + 27 = 153
     */
    public static void ArmstrongNumber() {
        int number = 154;
        int originalNumber = number;
        int digit = 0;
        int sumofDigit = 0;
        while (number > 0) {
            digit = number % 10;
            sumofDigit += digit * digit * digit;
            number = number / 10;
        }
        System.out.println("isArmstrongNumber = " + (sumofDigit == originalNumber));
    }

    public static void reverseString() {
        String inputText = "apple";
        int startIndex = 0, endIndex = inputText.length() - 1;
        char[] charArray = inputText.toCharArray();
        char temp;
        while (endIndex > startIndex) {
            temp = charArray[startIndex];
            charArray[startIndex] = charArray[endIndex];
            charArray[endIndex] = temp;
            endIndex--;
            startIndex++;
        }
        System.out.println(String.valueOf(charArray));
    }

    public static void checkPalindromeNumber() {
        int number = 123421;
        int originalNumber = number;
        int reverseNumber = 0;
        while (number > 0) {
            reverseNumber = reverseNumber * 10;
            reverseNumber = reverseNumber + (number % 10);
            number = number / 10;
        }
        System.out.println("isPalindrome = " + (reverseNumber == originalNumber));
    }

    public static void checkPalindromeString() {
        String input = "malayalamm";
        int startIndex = 0, endIndex = input.length() - 1;
        while (endIndex > startIndex) {
            if (input.charAt(startIndex++) != input.charAt(endIndex--)) {
                System.out.println("Strings are not palindrome");
                return;
            }
        }
        System.out.println("Strings are palindrome");
    }

    public static void findFactorial() {
        int n = 5;
        int factorial = 1;
        while (n > 0) {
            factorial = factorial * n;
            n = n - 1;
        }
        System.out.println(factorial);
    }

    public static int Factorial(int n) {
        if (n <= 0)
            return 1;
        return n * Factorial(n - 1);
    }

    //number which is divisible by itself
    public static boolean checkIfPrimeNumber(int number) {
        int i;
        for (i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static void checkDuplicateNumberInArray() {
        int[] array = {1, 2, 4, 5, 1, 4, 3, 5};
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j] && i != j)
                    System.out.print(array[i] + ",");
            }
        }
    }

    public static boolean checkArrayEquals() {
        int[] array1 = {1, 2, 4, 5, 1, 4, 3, 5};
        int[] array2 = {1, 2, 4, 5, 1, 4, 3, 5};
        if (array1.length != array2.length)
            return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i])
                return false;
        }
        return true;
    }

    /**
     * fibonacci series:
     * 0, 1 , 1, 2, 3, 5, 8
     */
    public static void generateFibonacciSeries() {
        int number = 5;
        int n1 = 0, n2 = 1;
        int fibNumber = 0;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i < number; i++) {
            fibNumber = n1 + n2;
            System.out.print(fibNumber + " ");
            n1 = n2;
            n2 = fibNumber;
        }
    }

    /**
     * fibonacci series:
     * 0, 1 , 1, 2, 3, 5, 8
     */
    static int n1 = 0, n2 = 1, fibNumber = 0;

    public static void fibonacciSeries(int count) {
        if (count <= 0)
            return;
        fibNumber = n1 + n2;
        System.out.print(fibNumber + " ");
        n1 = n2;
        n2 = fibNumber;
        fibonacciSeries(count - 1);
    }

    /**
     * fibonacci series:
     * 0, 1 , 1, 2, 3, 5, 8
     */
    public static int fibonacciSeries2(int n) {
        if (n <= 1)
            return 1;
        return fibonacciSeries2(n - 2) + fibonacciSeries2(n - 1);
    }

    /**
     * fibonacci series: memorisation
     * 0, 1 , 1, 2, 3, 5, 8
     * @return
     */
    public static int[] fibonacciSeries3(int n){

        if(n<=1)
            return new int[]{n};
        int[] array = new int[n];
        array[0] =0; array[1] =1;
        for (int i = 2; i <n; i++) {
            array[i] = array[i-2] + array[i-1];
        }
        return array;
    }


    public static void removeDuplicatesFromString() {
        String inputText = "This is banana";
        String finalString = "";
        char[] charArray = inputText.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (finalString.indexOf(charArray[i]) == -1) {
                finalString = finalString + charArray[i];
            }
        }
        System.out.println(finalString);
    }

    static boolean isAnagram(String a, String b) {
        if(a==null || b==null || a.isEmpty() || b.isEmpty())
            return false;

        if(a.length()!=b.length())
            return false;


        a = a.replace(" ", "").toLowerCase();
        b = b.replace(" ", "").toLowerCase();

        char[] aCharArray = a.toCharArray();
        for(int i=0;i<aCharArray.length; i++){
            if(b.indexOf(aCharArray[i])==-1){
                return false;
            } else {
                int index = b.indexOf(aCharArray[i]);
                b = b.substring(0,index) + b.substring(index+1);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(scan.nextInt());
        System.out.println(scan.nextDouble());
        scan.nextLine();
        System.out.println(scan.nextLine());
    }
}
