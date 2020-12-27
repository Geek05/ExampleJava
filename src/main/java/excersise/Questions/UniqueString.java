package excersise.Questions;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class UniqueString {

    /**
     * Given a string str containing alphanumeric characters.
     * The task is to calculate the sum of all the numbers present in the string.
     */
    public static long findSum(){
        String s = "1abc23";
        int sum =0;
        String[] nonWords = s.split("\\D+");
        for(String nonWord : nonWords){
            if(!nonWord.isEmpty())
                sum = sum + Integer.parseInt(nonWord);
        }
        System.out.println(sum);
        return sum;
    }

    static int RedOrGreen(String S) {
        int redCount = 0;
        int greenCount = 0;
        for(char ch : S.toCharArray()) {
            if(ch=='G'){
                greenCount++;
                continue;
            }

            if(ch=='R'){
                redCount++;
                continue;
            }
        }
        return Math.min(redCount,greenCount);
    }

    /**
     * Given a string s, find the minimum number of changes required to it so that all substrings of the string become distinct.
     * ex:
     * aab : 1
     * aebaecedabbee : 8
     * ab : 0
     */
    static int minimumNumberOfChanges(String input){
        Set<Character> charSet = new HashSet<>();
        int reduceCounter = 0;
        for(char ch : input.toCharArray()){
            if(!charSet.contains(ch)){
                charSet.add(ch);
            } else {
                reduceCounter++;
            }
        }
        return reduceCounter;
    }

    public static void dummy() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestcases = scanner.nextInt();
        int iteration = 0;
        List<Integer> outputList = new ArrayList<>();
        while(iteration < numberOfTestcases){
            String input = scanner.nextLine();
            if(!input.isEmpty()){
                int output = 10;
                outputList.add(output);
                iteration++;
            }
        }

        for(Integer output : outputList)
            System.out.println(output);
    }

    /**
     * Given an integer N which has odd number of digits, find whether the given number is a balanced or not.
     * An odd digit number is called a balanced number if the sum of all digits to the left of the middle digit and the sum of all digits to the right of the middle digit is equal.
     * 1234006 : 1
     * 1234006 : 0
     */
    Boolean balancedNumber(String N) {
        int leftIndex = 0;
        int rightIndex = N.length()-1;
        int leftSum =0;
        int rightSum = 0;
        while(leftIndex<rightIndex){
            leftSum = leftSum + Integer.valueOf(N.charAt(leftIndex));
            rightSum = rightSum + Integer.valueOf(N.charAt(rightIndex));

            leftIndex++;
            rightIndex--;
        }
        return leftSum == rightSum;
    }

    public static void main(String[] args) {
        String s = String.valueOf(123);
        System.out.println(s);
    }
}
