package excersise.dynamicProgramming;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class StringPermutation {

    /**
     * Explanation : https://www.youtube.com/watch?v=TnZHaH9i6-0
     * https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
     */
    public static void permute(String input, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex)
            System.out.println(input);
        for (int i = leftIndex; i < rightIndex; i++) {
            String swappedString = swap(input, leftIndex, i);
            permute(swappedString, leftIndex + 1, rightIndex);
        }
    }

    public static String swap(String input, int i, int j) {
        char[] charArray = input.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String input = "ABC";
        permute(input, 0, input.length());
    }

}
