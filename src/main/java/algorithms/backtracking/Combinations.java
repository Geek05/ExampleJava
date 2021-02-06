package algorithms.backtracking;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class Combinations {

    public static void generateCombinations(int[] input, Set<Integer> partial, int k, int start) {
        if (partial.size() == k) {
            System.out.println(partial);
        }
        if (start == input.length)
            return;

        for (int i = start; i < input.length; i++) {
            partial.add(input[i]);
            generateCombinations(input, partial, k, i + 1);
            partial.remove(input[i]);
        }
    }

    public static void generateCombinationsTest() {
        int[] input = new int[]{3, 2, 5, 8};
        int k = 3;
        generateCombinations(input, new HashSet<>(), k, 0);
    }

    public static void subsetSum(int[] input, ArrayList<Integer> partial, int currentSum, int targetSum, int start) {
        if (currentSum == targetSum) {
            System.out.println(partial);
        }

        if (start == input.length)
            return;

        for (int i = start; i < input.length; i++) {
            int candidate = input[i];
            if (currentSum + candidate > targetSum || i > start && input[i] == input[i - 1])
                continue;
            partial.add(candidate);
            subsetSum(input, partial, currentSum + candidate , targetSum, i + 1);
            partial.remove(partial.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int targetSum = 8;
        int currentSum = 0;
        subsetSum(input, new ArrayList<>(), currentSum, targetSum, 0);
    }
}
