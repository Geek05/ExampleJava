package algorithms.sorting;

import java.util.Arrays;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class SelectionSort {

    private static int[] selectionSort(final int[] unsortedArray) {
        int[] array = unsortedArray.clone();
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            position = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[position])
                    position = j;
            }
            int temp = array[i];
            array[i] = array[position];
            array[position] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {1, 7, 3, 5, 1};
        int[] sortedArray = selectionSort(unsortedArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}
