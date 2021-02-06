package excersise.temp;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Feb-2021
 */
public class AllInOne01 {

    public static void mostFrequent() {
        int[] array = new int[]{1, 2, 3, 1, 4, 2, 1, 41, 32, 1, 2, 2, 3, 2};
        Map<Integer, Integer> map = new HashMap<>();
        int maxOccuredCount = 0;
        int maxOccuredElement = 0;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
            if (map.get(array[i]) > maxOccuredCount) {
                maxOccuredCount = map.get(array[i]);
                maxOccuredElement = array[i];
            }
        }
        System.out.println(maxOccuredElement + " , " + maxOccuredCount);
    }


    public static void mergeSortedArrays() {
        int[] array1 = new int[]{1, 3, 4, 6, 7, 9};
        int[] array2 = new int[]{1, 2, 4, 5, 9, 10};
        int[] finalArray = new int[array1.length + array2.length];
        int array1Index = 0;
        int array2Index = 0;
        int finalArrayIndex = 0;
        while (array1Index < array1.length || array2Index < array2.length) {
            if (array1Index < array1.length && array1[array1Index] < array2[array2Index]) {
                finalArray[finalArrayIndex] = array1[array1Index];
                array1Index++;
            } else if (array2Index < array2.length) {
                finalArray[finalArrayIndex] = array2[array2Index];
                array2Index++;
            }
            finalArrayIndex++;
        }
        System.out.println(Arrays.toString(finalArray));
    }


    /**
     * Is array1 is rotation of array2 ? - no duplicates
     * pick first element in array1 and search in array 2.
     * once we find the index in array2, start comparing with array1 from that index
     */
    public static void isRotatedArray() {
        boolean isRotatedArray = true;
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] array2 = new int[]{4, 5, 6, 7, 1, 2, 3};
        int array1Index = 0;
        int array2Index = 0;

        for (int i = 0; i < array2.length; i++) {
            if (array2[i] == array1[0]) {
                array2Index = i;
                break;
            }
        }

        for (int i = 0; i < array1.length; i++) {
            if (array2Index >= array2.length)
                array2Index = 0;
            if (array1[i] != array2[array2Index]) {
                isRotatedArray = false;
                break;
            }
            array2Index++;
        }

        System.out.println("isRotatedArray=" + isRotatedArray);
    }

    /**
     * return non repeating character
     * aabcb
     */
    public static void nonRepeatingCharacter() {
        String input = "aabacbxyz";
        String nonRepeatingChar = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i) + 1));
                nonRepeatingChar = nonRepeatingChar.replace(String.valueOf(input.charAt(i)), "");
            } else {
                map.put(input.charAt(i), 1);
                nonRepeatingChar = nonRepeatingChar + String.valueOf(input.charAt(i));
            }
        }
        System.out.println(nonRepeatingChar);
    }

    /**
     * one diff away
     * given 2 strings, at max one change can be done to make sure strings are same.
     * operations permitted to make strings equal : change, add, delete - one char max
     * <p>
     * change example: s1= abcde s2 = abfde
     * add example: s1= abcde s2 = abde
     * delete example: s1= xyz s2 = xyaz
     */
    public static boolean isOneAway(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1)
            return false;

        if (s1.equals(s2))
            return true;

        if (s1.length() == s2.length()) {
            int diffCount = 0;
            for (int i = 0; i < s1.toCharArray().length; i++) {
                if (s1.indexOf(s2.charAt(i)) == -1) {
                    diffCount++;
                    if (diffCount > 1)
                        return false;
                }
            }
        }

        if (s1.length() > s2.length())
            return isDiffOne(s1, s2);
        else
            return isDiffOne(s2, s1);
    }

    public static boolean isDiffOne(String largeString, String smallString) {
        int diffCount = 0;
        int smallStringIndex = 0;
        for (int i = 0; i < smallString.toCharArray().length; i++) {
            if (largeString.charAt(i + diffCount) != smallString.charAt(i)) {
                diffCount++;
                if (diffCount > 1)
                    return false;
            }
        }
        return true;
    }

    public static void testIsOneAway() {
        System.out.println(isOneAway("abcde", "abfde") + " Expected True");
        System.out.println(isOneAway("abcde", "abde") + " Expected True");
        System.out.println(isOneAway("abc", "bcc") + " Expected True");
        System.out.println(isOneAway("abcde", "abc") + " Expected True");
        System.out.println(isOneAway("abc", "abcde") + " Expected True");
        System.out.println(isOneAway("abcde", "abcd") + " Expected True");  // should return true
        System.out.println(isOneAway("abde", "abcde") + " Expected True");  // should return true
        System.out.println(isOneAway("a", "a") + " Expected True");  // should return true
        System.out.println(isOneAway("abcdef", "abqdef") + " Expected True");  // should return true
        System.out.println(isOneAway("abcdef", "abccef") + " Expected True");  // should return true
        System.out.println(isOneAway("abcdef", "abcde") + " Expected True");  // should return true
        System.out.println(isOneAway("aaa", "abc") + " Expected False");  // should return false
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1;
        int j = high;

        do {
            while (i <= j && array[i] <= pivot) {
                i = i + 1;
            }

            while (i <= j && array[j] > pivot) {
                j = j - 1;
            }

            if (i < j)
                swap(array, i, j);
        } while (i < j);

        swap(array, j, low);

        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void quickSortDemo() {
        int[] array = {3, 5, 8, 9, 6, 2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static int fibDP(int n, int[] cache) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (cache[n] != 0)
            return cache[n];
        int result = fibDP(n - 1, cache) + fibDP(n - 2, cache);
        cache[n] = result;
        return result;
    }

    private static void fibIterative(int n) {
        int[] cache = new int[n];
        cache[0] = 0;
        cache[1] = 1;
        System.out.print(cache[0] +" , "+cache[1] + " , ");
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
            System.out.print(cache[i] + " , ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        fibIterative(5);
    }
}
