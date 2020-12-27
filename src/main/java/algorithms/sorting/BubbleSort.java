package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class BubbleSort {

    /**
     * Largest element goes to last
     * Big bubble goes to end
     *
     * 1, 7, 3, 5, 0
     * 1,3,5,0,7
     * 1,3,0,5,7
     * 1,0,3,5,7
     * 0,1,3,5,7
     */

    private static int[] insertionSort(int[] unsortedArray) {
        int[] array = unsortedArray.clone();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    private static int[] insertionSort2(int[] unsortedArray) {
        int[] array = unsortedArray.clone();

        for (int pass = array.length - 1; pass >= 0; pass--) {
            for (int i = 0; i < pass; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

        }
        return array;
    }


    public static void main(String[] args) {
        int[] unsortedArray = {1, 7, 3, 5, 0, 19, 90, 99, 1, 2, 3};
        int[] sortedArray = insertionSort2(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }


}
