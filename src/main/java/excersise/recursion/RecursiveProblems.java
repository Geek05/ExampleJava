package excersise.recursion;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class RecursiveProblems {

    /**
     * Check if elements in array are in sequence
     * 1,2,3,4,5 = true
     * 3,4,5,6 = true
     * 4,6,7,8,9 = false
     */
    public static boolean isArrayInSequence(int[] array, int index, int length) {
        if (index >= length)
            return true;
        if (index < length && array[index] + 1 != array[index + 1])
            return false;
        return isArrayInSequence(array, index + 1, length);
    }

    /**
     * Sum of array
     * 1,2,3,4,5
     */
    public static int sumOfArray(int[] array, int index, int length) {
        if (index > length)
            return 0;
        return array[index] + sumOfArray(array, index + 1, length);
    }

    /**
     * Sum of digits
     * 1,2,3,4,5
     */
    public static int sumOfDigits(int number) {
        if (number == 0)
            return 0;
        int digit = number % 10;
        return digit + sumOfDigits(number / 10);
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        //System.out.println(sumOfArray(array, 0, array.length - 1));
        System.out.println(sumOfDigits(-123456));
    }
}
