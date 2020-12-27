package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class MergeSort {

    /**
     * Divide and concur approach
     * <p>
     * 1. Divide the collection of elements into smaller subsets
     * 2. Recursively sort the subset
     * 3. combine and merge the result into solution
     */

    private static void mergeSort(int[] array, int left, int right) {
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            //System.out.println(String.format("left = %s, mid=%s", left, mid));
            mergeSort(array, left, mid);
            //System.out.println(String.format("mid+1=%s, right=%s", mid+1, right));
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int[] tempArray = new int[right + 1];

        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tempArray[k] = array[i];
                i++;
            } else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            tempArray[k] = array[i];
            i++;
            k++;
        }

        while (j <= right) {
            tempArray[k] = array[j];
            j++;
            k++;
        }

        for (int x = left; x < right + 1; x++) {
            array[x] = tempArray[x];
        }
    }


    public static void main(String[] args) {
        int[] unsortedArray = {3, 5, 8, 9, 6, 2};
        mergeSort(unsortedArray, 0, unsortedArray.length-1);
        System.out.println(Arrays.toString(unsortedArray));
    }
}
