package algorithms.Searching;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class SearchingDemo {

    public static int binarySearch(int[] array, int key, int l, int r) {
        if (l > r) {
            return -1;
        } else {
            int mid = (l + r) / 2;
            if (key == array[mid]) {
                return mid;
            } else if (key < array[mid]) {
                return binarySearch(array, key, l, mid - 1);
            } else if (key > array[mid]) {
                return binarySearch(array, key, mid + 1, r);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 9, 10, 20, 25, 35, 90, 100, 150};
        int index = binarySearch(array, 99, 0, array.length - 1);
        System.out.println(index);
    }
}
