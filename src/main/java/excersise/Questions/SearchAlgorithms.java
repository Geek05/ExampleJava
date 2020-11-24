package excersise.Questions;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class SearchAlgorithms {

    private static int binarySearch(int[] array, int left, int right , int key) {
        if(right >= left){
            int mid = (left + right)/2;

            if(array[mid] == key)
                return mid;

            if(array[mid] < key)
                return binarySearch(array, mid+1 , right, key);

            if(array[mid] > key)
                return binarySearch(array, left, mid-1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int found = binarySearch(array, 0, array.length-1, 18);
        System.out.println(found);
    }
}
