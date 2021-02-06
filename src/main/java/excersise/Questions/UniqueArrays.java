package excersise.Questions;

import java.util.*;

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

    /**
     * sort by frequency
     * ex: 1 2 2 3 3 3 4 4 5 5 5 5 6 6 6 7 8 9 10
     * output:5 5 5 5 3 3 3 6 6 6 2 2 4 4 1 7 8 9 10
     */
    public static void sortByFrequency() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    }

    public static void removeDuplicatesFromArray() {
        int[] array = new int[]{1, 2, 1, 2, 3, 4, 5};
        int[] resultArray = new int[array.length];
        Arrays.fill(resultArray, -1);
        Set<Integer> uniqueIntegers = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!uniqueIntegers.contains(array[i])) {
                resultArray[i] = array[i];
                uniqueIntegers.add(array[i]);
            }
        }
        System.out.println(Arrays.toString(resultArray));
    }

    /**
     * There is an array with every element repeated twice except one. Find that element?
     * {1, 1, 2, 2, 3, 4, 4, 5, 5} then your program should return 3.
     */
    public static void findUniqueFromArray() {
        int[] array = new int[]{0, 1, 1, 2, 2, 3, 4, 4, 5, 5};
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            if (!((i + 1 < length && array[i] == array[i + 1]) || (i - 1 >= 0 && array[i] == array[i - 1]))) {
                System.out.println(array[i]);
                return;
            }
        }
        System.out.println("No Unique element");
    }

    /**
     * Intersection of 3 arrays
     * input1 = {1, 5, 10, 20, 40, 80}
     * input2 = {6, 7, 20, 80, 100}
     * input3 = {3, 4, 15, 20, 30, 70, 80, 120}
     * Output: 20, 80
     */
    public static void Intersectionof3arrays() {
        Integer[] array1 = new Integer[]{1, 5, 10, 20, 40, 80};
        Integer[] array2 = new Integer[]{6, 7, 20, 80, 100};
        Integer[] array3 = new Integer[]{3, 4, 15, 20, 30, 70, 80, 120};
        Integer[] firstiIntersection = findIntersection(array1, array2);
        Integer[] finalIntersection = findIntersection(firstiIntersection, array3);
        System.out.println(Arrays.toString(finalIntersection));
    }

    private static Integer[] findIntersection(Integer[] array1, Integer[] array2) {
        Set<Integer> unique = new HashSet<>();
        List<Integer> intersection = new ArrayList<Integer>();
        for (int i = 0; i < array1.length; i++) {
            unique.add(array1[i]);
        }

        for (int i = 0; i < array2.length; i++) {
            if (unique.contains(array2[i])) {
                intersection.add(array2[i]);
            }
        }
        return intersection.toArray(new Integer[0]);
    }

    /**
     * How to rearrange array in alternating positive and negative number?
     * Input: {1, 2, 3, -4, -1, 4}
     * Output: {-4, 1, -1, 2, 3, 4}
     * <p>
     * Input: {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
     * output: {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
     */
    public static void alternatingPositiveNegative() {
        int[] array = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int[] consumedTracker = new int[array.length];
        int[] finalArray = new int[array.length];
        int element = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                try {
                    element = findNegative(array, consumedTracker);
                    finalArray[i] = element;
                } catch (Exception e) {
                    addRemainingElementsToArray(array, i, consumedTracker, finalArray);
                    break;
                }
            } else {
                try {
                    element = findPositive(array, consumedTracker);
                    finalArray[i] = element;
                } catch (Exception e) {
                    addRemainingElementsToArray(array, i, consumedTracker, finalArray);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(finalArray));
    }

    private static void addRemainingElementsToArray(int[] array, int currentIndex, int[] consumedTracker, int[] finalArray) {
        for (int i = 0; i < array.length; i++) {
            if (consumedTracker[i] == -1)
                continue;
            finalArray[currentIndex] = array[i];
            consumedTracker[i] = -1;
            currentIndex++;
        }
    }

    private static int findPositive(int[] array, int[] consumedTracker) throws Exception {
        int foundValue = -1;
        for (int i = 0; i < array.length; i++) {
            if (consumedTracker[i] != -1 && array[i] >= 0) {
                foundValue = array[i];
                consumedTracker[i] = -1;
                return foundValue;
            }
        }
        throw new Exception("Not Found");
    }

    private static int findNegative(int[] array, int[] consumedTracker) throws Exception {
        int foundValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (consumedTracker[i] != -1 && array[i] < 0) {
                foundValue = array[i];
                consumedTracker[i] = -1;
                return foundValue;
            }
        }
        throw new Exception("Not Found");
    }

    /**
     * How to merge sorted array?
     */
    public static void mergeSortedArray() {
        int[] array1 = new int[]{0, 0, 0, 1, 2, 3};
        int[] array2 = new int[]{0, 0, 0, 1, 2, 3};
        int[] finalArray = new int[array1.length + array2.length];
        int array1Index = 0;
        int array2Index = 0;
        int finalArrayIndex = 0;
        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                finalArray[finalArrayIndex] = array1[array1Index];
                array1Index++;
            } else {
                finalArray[finalArrayIndex] = array2[array2Index];
                array2Index++;
            }
            finalArrayIndex++;
        }

        while (array1Index < array1.length) {
            finalArray[finalArrayIndex] = array1[array1Index];
            finalArrayIndex++;
            array1Index++;
        }

        while (array2Index < array2.length) {
            finalArray[finalArrayIndex] = array2[array2Index];
            finalArrayIndex++;
            array2Index++;
        }
        System.out.println(Arrays.toString(finalArray));
    }

    /**
     * How To Sort Array Elements By Frequency In Java?
     * <p>
     * input: [7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3]
     * output : [ 1 1 1 1 7 7 7 3 3 4 4 5 9 ]
     */
    public static void SortArrayElementsByFrequency() {
        int[] array = new int[]{7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3};
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : entries) {
            int frequency = entry.getValue();
            while (frequency >= 1) {
                System.out.print(entry.getKey() + " , ");
                frequency--;
            }
        }
        System.out.println();
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

    public static void main(String[] args) {
        SortArrayElementsByFrequency();
    }
}
