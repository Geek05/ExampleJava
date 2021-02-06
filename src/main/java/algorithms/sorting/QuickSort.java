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
     * <p>
     * Detailed video is in drive inter directory
     */
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
            while (i <= j && array[i] <= pivot)
                i = i + 1;

            while (i <= j && array[j] > pivot)
                j = j - 1;

            if (i < j)
                swap(array, i, j);

        } while (i < j);

        swap(array, low, j);

        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] array = {3, 5, 8, 9, 6, 2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
