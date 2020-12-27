package excersise.Questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class UniqueArrays {

    /**
     * Given a sorted array arr[] of distinct integers.
     * Sort the array into a wave-like array and return it.
     * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
     * (considering the increasing lexicographical order)
     * arr[] = {1,2,3,4,5}
     * Output: 2 1 4 3 5
     */
    public static void convertToWave(int arr[], int n) {
        if (arr.length <= 0 || n <= 0)
            return;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0 && arr[i] <= arr[i + 1])
                swap(i, i + 1, arr);
            if (i % 2 != 0 && arr[i] >= arr[i + 1])
                swap(i, i + 1, arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int indexX, int indexY, int arr[]) {
        int temp = arr[indexX];
        arr[indexX] = arr[indexY];
        arr[indexY] = temp;
    }

    /**
     * Given an array Arr of N elements which is first increasing and then may be decreasing, find the maximum element in the array.
     * Note: If the array is increasing then just print then last element will be the maximum value.
     */
    public static int findMaximum() {
        int[] arr = new int[]{1, 15, 25, 45, 42, 21, 17, 12, 11};
        int n = arr.length;
        if (arr.length <= 0 || n <= 0)
            return 0;
        int i;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            } else {
                return arr[i];
            }
        }
        return arr[i];
    }



    public static void main(String[] args) {
    }
}
