package excersise.temp;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class Temp01 {


    /**
     * Sum of 2 - Brute force = n2.
     */
    public static void sumOf2Bruteforce() {

    }

    public static int BinaraySearch(int[] array, int left, int right, int key) {
        if (left < right) {
            int mid = (left + right) / 2;
            if (key == array[mid])
                return mid;
            else if (key < array[mid]) {
                return BinaraySearch(array, left, mid, key);
            } else if (key > array[mid]) {
                return BinaraySearch(array, mid + 1, right, key);
            }
        }
        return -1;
    }

    private static void BinaraySearchTest() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 3;
        int foundIndex = BinaraySearch(array, 0, array.length - 1, key);
        System.out.println(foundIndex);
    }

    private static void QuickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            QuickSort(array, low, partitionIndex - 1);
            QuickSort(array, partitionIndex + 1, high);
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

            if (i < j) {
                swap(array, i, j);
            }
        } while (i < j);

        swap(array, j, low);

        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void QuickSortTest() {
        int[] array = {4, 5, 1, 2, 8, 9, 10, 3, 6, 7};
        QuickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void MergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(array, left, mid);
            MergeSort(array, mid + 1, right);
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

        for (int l = left; l <= right; l++) {
            array[l] = tempArray[l];
        }
    }

    private static void MergeSortTest() {
        int[] array = {200, 4, 5, 1, 2, 100, 8, 9, 10, 3, 6, 7};
        MergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void SelectionSort(int[] array) {
        int smallestIndex = 0;
        for (int i = 0; i < array.length; i++) {
            smallestIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;

        }
    }

    private static void SelectionSortTest() {
        int[] array = {200, 4, 5, 1, 2, 100, 8, 9, 10, 3, 6, 7};
        SelectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void BubbleSort(int[] array) {
        for (int pass = array.length - 1; pass >= 0; pass--) {
            for (int i = 0; i < pass; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    private static void BubbleSortTest() {
        int[] array = {200, 4, 5, 1, 2, 100, 8, 9, 10, 3, 6, 7};
        BubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * Find Contiguous subarray with maximum sum
     */
    public static void kadanesAlgorithm() {
        int[] array = new int[]{2, -3, 7, -4, 2, 5, -8, 6, -1};
        int bestSum = 0;
        int currentSum = 0;
        int bestStartIndex = 0;
        int bestEndIndex = 0;

        for (int i = 0; i < array.length; i++) {

            currentSum = currentSum + array[i];
            if (currentSum < 0) {
                currentSum = 0;
                bestStartIndex = i + 1;
            }

            if (currentSum > bestSum) {
                bestSum = currentSum;
                bestEndIndex = i;
            }
        }

        for (int i = bestStartIndex; i <= bestEndIndex; i++) {
            System.out.print(array[i] + " , ");
        }
        System.out.println();
    }


    public static <T> void printAnything(T t){
        System.out.println(t);
    }


    public static void main(String[] args) {
        printAnything(new String("APPLE"));
        printAnything(new Integer(100));
        printAnything(new Double(100.109));
    }

}
