package excersise.arrays;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class Arrays01 {

    /**
     * 1, 2, 3, 4, 5, 6, 7, 8
     * shift(once) = 2, 3, 4, 5, 6, 7, 8 , 1
     */
    public static void shiftElementsInArray(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        int firstElement = array[0];
        int i =0;
        for (i = 0; i < array.length-1; i++) {
            array[i] = array[i+1];
        }
        array[i] = firstElement;
        System.out.println(Arrays.toString(array));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);

        String chunk="";
        for(int i=0; i<=s.length()-k;i++){
            chunk = s.substring(i,i+k);
            if(smallest.compareTo(chunk)>0)
                smallest = chunk;
            if(largest.compareTo(chunk)<0)
                largest = chunk;
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        String strA = "welcometojava", strB = "banana";
        System.out.println(getSmallestAndLargest(strA, 3));
    }

}
