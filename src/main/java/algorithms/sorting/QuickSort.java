package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class QuickSort {

    /**
     * Divide and concur approach
     * <p>
     * 1. Divide the collection of elements into smaller subsets or partitions
     * 2. partition based on pivot (all elements towards left are smaller and towards right are largest)
     * 3. Recursively sort the partition using quicksort
     * 4. combine and merge the result into solution
     */

    private static void mergeSort(int[] array, int left, int right) {

    }


    public static void main(String[] args) {
        int[] unsortedArray = {3, 5, 8, 9, 6, 2};
        mergeSort(unsortedArray, 0, unsortedArray.length-1);
        System.out.println(Arrays.toString(unsortedArray));
    }
}
