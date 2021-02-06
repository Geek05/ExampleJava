package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class Permutations {

    public static void generatePermutations(int[] input, List<Integer> partial, boolean[] used) {
        if (partial.size() == input.length) {
            System.out.println(partial);
            return;
        } else {
            for (int i = 0; i < input.length; i++) {
                if (!used[i]) {
                    partial.add(input[i]);
                    used[i] = true;
                    generatePermutations(input, partial, used);
                    used[i] = false;
                    partial.remove(partial.size() - 1);
                }
            }
        }
    }

    public void testPermutations() {
        int[] input = new int[]{1, 2, 3};
        generatePermutations(input, new ArrayList<>(), new boolean[input.length]);
    }

    public static void stringPermutations(char[] input, List<Character> partial, boolean[] used) {
        if (partial.size() == input.length) {
            System.out.println(partial);
            return;
        } else {
            for (int i = 0; i < input.length; i++) {
                if(!used[i]){
                    partial.add(input[i]);
                    used[i] = true;
                    stringPermutations(input, partial, used);
                    used[i] = false;
                    partial.remove(partial.size()-1);
                }
            }
        }

    }

    public static void main(String[] args) {
        String input = "abc";
        stringPermutations(input.toCharArray(), new ArrayList<>(), new boolean[input.length()]);
    }
}
