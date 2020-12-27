package excersise.Questions;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class CommonExercise01 {

    static void printPrimeNumbers() {
        int n = 10;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                System.out.println(i);
        }
    }

    private static boolean isPrime(int n) {
        boolean isPrime = true;
        for (int i = 2; i <= n; i++) {
            if (n != i && n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    /**
     * Count of each word
     */
    public static void countWords() {
        String input = "   Hello, this is the 1st example sentence!. " +
                "I have 100$ ?";
        String[] tokens = input.trim().split("\\s+");

        for (String token : tokens) {
            System.out.println(token.replaceAll("[.,]", ""));
        }
    }

    public static void findDuplicateIn2Arrays() {
        int[] arrayA = new int[]{7, 1, 5, 2, 3, 6};
        int[] arrayB = new int[]{3, 8, 6, 20, 7, 9, 10, 1, 200};
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] == arrayB[j]) {
                    System.out.println("duplicate " + arrayA[i]);
                }
            }
        }
    }

    //efficient
    public static void findDuplicateIn2Arrays2() {
        int[] arrayA = new int[]{7, 1, 5, 2, 3, 6};
        int[] arrayB = new int[]{3, 8, 6, 20, 7};
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = new HashSet<>();
        for (int i = 0; i < arrayA.length; i++) {
            if (uniqueElements.contains(arrayA[i])) {
                duplicateElements.add(arrayA[i]);
                uniqueElements.remove(arrayA[i]);
            } else {
                uniqueElements.add(arrayA[i]);
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            if (uniqueElements.contains(arrayB[i])) {
                duplicateElements.add(arrayB[i]);
                uniqueElements.remove(arrayB[i]);
            } else {
                uniqueElements.add(arrayB[i]);
            }
        }

        System.out.println("duplicate = " + duplicateElements);
        System.out.println("unique = " + uniqueElements);
    }

    public static void findUniqueIn2Arrays() {
        int[] arrayA = new int[]{7, 1, 5, 2, 3, 6};
        int[] arrayB = new int[]{3, 8, 6, 20, 7, 9, 10, 1, 200};
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i = 0; i < arrayA.length; i++) {
            uniqueElements.add(arrayA[i]);
        }

        for (int i = 0; i < arrayB.length; i++) {
            uniqueElements.add(arrayB[i]);
        }

        for (Integer uniqueElement : uniqueElements) {
            System.out.println(uniqueElement);
        }
    }

    public static void uniqueCharsInString() {
        String input = "Hello";
        char[] charArray = input.toCharArray();
        int[] intArray = new int[255];
        for (int i = 0; i < charArray.length; i++) {
            if (intArray[charArray[i]] == 0) {
                intArray[charArray[i]] = 1;
            } else {
                intArray[charArray[i]] = intArray[charArray[i]] + 1;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != 0 && intArray[i] == 1) {
                System.out.print((char) i + " ");
            }
        }
        System.out.println();
    }

    public static void stringCompression() {
        String input = "hello";
        char[] charArray = input.toCharArray();
        char currentChar = charArray[0];
        int counter = 0;
        String compressedData = "";
        for (int i = 0; i < charArray.length; i++) {
            if (currentChar != charArray[i]) {
                compressedData = compressedData + currentChar + counter;
                currentChar = charArray[i];
                counter = 1;
            } else {
                counter++;
            }
        }
        compressedData = compressedData + currentChar + counter;
        System.out.println(compressedData);
    }

    public static void maxArray() {
        int[] arrayA = new int[]{3, 8, 6, 20, 7, 9, 10, 1, 200};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] > max)
                max = arrayA[i];

            if (arrayA[i] < min)
                min = arrayA[i];
        }
        System.out.println("max Value = " + max);
        System.out.println("min Value = " + min);
    }

    /**
     * Product of all elements except the mentioned index value
     * ONly unique array
     */
    public static void ProductOfArray() {
        int[] array = new int[]{10, 3, 5, 6, 2};
        int[] productArray = new int[array.length];
        int exclude = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            product = 1;
            exclude = array[i];
            for (int j = 0; j < array.length; j++) {
                if (exclude != array[j]) {
                    product = product * array[j];
                }
            }
            productArray[i] = product;
        }
        System.out.println(Arrays.toString(productArray));
    }

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

    public static void pintAllSubstrings() {
        String input = "hello";
        char[] charArray = input.toCharArray();
        for (int i = 0; i <= charArray.length; i++) {
            for (int j = i + 1; j <= charArray.length; j++) {
                System.out.println(input.substring(i, j));
            }
        }
    }

    public static void permutate(String prefix, String input) {
        int n = input.length();
        if (n == 0)
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++) {
                permutate(prefix + input.charAt(i) , input.substring(0, i) + input.substring(i + 1, n));
            }
        }
    }

    public static void main(String[] args) {
        permutate("", "abc");
    }
}
