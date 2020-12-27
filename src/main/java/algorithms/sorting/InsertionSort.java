package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class InsertionSort {

    private static int[] insertionSort(int[] unsortedArray) {
        int[] array = unsortedArray.clone();

        for (int i = 0; i < array.length; i++) {
             
        }
        return array;
    }


    public static void main(String[] args) {
        int[] unsortedArray = {1, 7, 3, 5, 0, 19, 90, 99, 1, 2, 3};
        int[] sortedArray = insertionSort(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}
