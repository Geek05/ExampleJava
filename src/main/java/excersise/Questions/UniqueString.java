package excersise.Questions;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class UniqueString {

    /**
     * Given a string str containing alphanumeric characters.
     * The task is to calculate the sum of all the numbers present in the string.
     */
    public static long findSum() {
        String s = "1abc23";
        int sum = 0;
        String[] nonWords = s.split("\\D*");
        for (String nonWord : nonWords) {
            if (!nonWord.isEmpty())
                sum = sum + Integer.parseInt(nonWord);
        }
        System.out.println(sum);
        return sum;
    }

    static int RedOrGreen(String S) {
        int redCount = 0;
        int greenCount = 0;
        for (char ch : S.toCharArray()) {
            if (ch == 'G') {
                greenCount++;
                continue;
            }

            if (ch == 'R') {
                redCount++;
                continue;
            }
        }
        return Math.min(redCount, greenCount);
    }

    /**
     * Given a string s, find the minimum number of changes required to it so that all substrings of the string become distinct.
     * ex:
     * aab : 1
     * aebaecedabbee : 8
     * ab : 0
     */
    static int minimumNumberOfChanges(String input) {
        Set<Character> charSet = new HashSet<>();
        int reduceCounter = 0;
        for (char ch : input.toCharArray()) {
            if (!charSet.contains(ch)) {
                charSet.add(ch);
                continue;
            }
            reduceCounter++;
        }
        return reduceCounter;
    }

    public static void dummy() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestcases = scanner.nextInt();
        int iteration = 0;
        List<Integer> outputList = new ArrayList<>();
        while (iteration < numberOfTestcases) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                int output = 10;
                outputList.add(output);
                iteration++;
            }
        }

        for (Integer output : outputList)
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
        int rightIndex = N.length() - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (leftIndex < rightIndex) {
            leftSum = leftSum + Integer.valueOf(N.charAt(leftIndex));
            rightSum = rightSum + Integer.valueOf(N.charAt(rightIndex));

            leftIndex++;
            rightIndex--;
        }
        return leftSum == rightSum;
    }

    /**
     * strings are anagrams
     */
    public static void anagrams() {
        String input1 = "made for Each Other";
        String input2 = "Each for Made Other";
        input1 = input1.trim().toLowerCase();
        input2 = input2.trim().toLowerCase();
        StringBuilder input2sb = new StringBuilder(input2);
        for (int i = 0; i < input1.toCharArray().length; i++) {
            if (input2sb.indexOf(String.valueOf(input1.charAt(i))) == -1) {
                System.out.println("Strings are not anagrams!");
                return;
            } else {
                input2sb.deleteCharAt(input2sb.indexOf(String.valueOf(input1.charAt(i))));
            }
        }
        if (input2sb.length() == 0) {
            System.out.println("Strings are anagrams!");
            return;
        }
    }

    public static boolean isAnagram(String S1, String S2) {
        if (S1.length() != S2.length())
            return false;
        for (int i = 0; i < S1.length(); i++) {
            int index = S2.indexOf(S1.charAt(i));
            if (index != -1) {
                S2 = S2.substring(0, index) + S2.substring(index + 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> Anagrams(String[] string_list) {
        List<List<String>> output = new ArrayList<>();
        List<String> inputList = new ArrayList<>(Arrays.asList(string_list));
        String currentWord = "";
        while (inputList.size() > 0) {
            currentWord = inputList.get(0);
            List<String> anagramsList = new ArrayList<>();
            anagramsList.add(currentWord);
            for (int i = 1; i < inputList.size(); i++) {
                if (!currentWord.equals(inputList.get(i)) && isAnagram(currentWord, inputList.get(i))) {
                    anagramsList.add(inputList.get(i));
                    inputList.remove(i);
                }
                if (inputList.size() == 2) //last element
                    i = 0;
            }
            inputList.remove(currentWord);

            if (anagramsList.size() > 0)
                output.add(anagramsList);
        }
        return output;
    }

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }

    private static List<List<String>> AnagramsOpt(String[] strings) {
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        String sortedWord = "";
        for (String word : strings) {
            sortedWord = sortString(word);
            if (!anagramMap.containsKey(sortedWord)) {
                anagramMap.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            } else {
                List<String> temp = anagramMap.get(sortedWord);
                temp.add(word);
                anagramMap.put(sortedWord, temp);
            }
        }
        for (String key : anagramMap.keySet()) {
            output.add(anagramMap.get(key));
        }
        return output;
    }

    /**
     * find the largest subset of unique string/characters
     * aabbcc = abc
     */
    public static void uniqueString() {
        String inputText = "aabcc";
        char[] charArray = inputText.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        int maxDistinctLength = 0;
        String maxDistinctString = "";
        for (int i = 0; i < charArray.length; i++) {
            if (!map.containsKey(charArray[i])) {
                map.put(charArray[i], i);
            } else {
                if (maxDistinctLength < map.size()) {
                    maxDistinctLength = map.size();
                    maxDistinctString = map.keySet().toString();
                }
                map.clear();
                map.put(charArray[i], 1);
            }
        }
        System.out.println(maxDistinctString);
    }


    /**
     * Longest palindromic substring
     */
    public static void longestPalindromeEasy() {
        String input = "forgeeksskeegforisinmalayaayalam";
        char[] inputChar = input.toCharArray();
        String longestPalindrome = "";
        for (int i = 0; i < inputChar.length; i++) {
            for (int j = i; j <= inputChar.length; j++) {
                if (input.substring(i, j).length() < longestPalindrome.length())
                    continue;
                if (isPalindrome(input.substring(i, j)) && longestPalindrome.length() < input.substring(i, j).length()) {
                    longestPalindrome = input.substring(i, j);
                }
            }
        }
        System.out.println(longestPalindrome);
    }

    private static boolean isPalindrome(String longestPalindrome) {
        int startIndex = 0, endIndex = longestPalindrome.length() - 1;
        boolean isPalindrome = true;
        while (startIndex < endIndex) {
            if (longestPalindrome.charAt(startIndex) != longestPalindrome.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return isPalindrome;
    }

    /**
     * one diff away
     * given 2 strings, at max one change can be dont to make sure strings are same.
     * operations permitted to make strings equal : change, add, delete - one char max
     * <p>
     * change example: s1= abcde s2 = abfde
     * add example: s1= abcde s2 = abde
     * delete example: s1= xyz s2 = xyaz
     */
    public static boolean isOneAway(String s1, String s2) {
        if (!(Math.abs(s1.length() - s2.length()) <= 1))
            return false;

        if(s1.length() == s2.length()){
            int diffCount = 0;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i)!=s2.charAt(i)){
                    diffCount ++;
                    if(diffCount>1)
                        return false;
                }
            }
            return true;
        }

        String largeString = s1.length() > s2.length() ? s1 : s2;
        String smallString = s1.length() < s2.length() ? s1 : s2;
        int diffCount = 0;
        int Index = 0;
        while(smallString.length() > Index) {
            if(largeString.charAt(Index + diffCount)!=smallString.charAt(Index)) {
                diffCount++;
                if(diffCount>1)
                    return false;
            }
            Index++;
        }

        return diffCount <= 1;
    }

    public static void testIsOneAway() {
        long startTime = System.currentTimeMillis();
        System.out.println(isOneAway("abcde", "abfde"));
        System.out.println(isOneAway("abcde", "abde"));
        System.out.println(isOneAway("abc", "bcc"));
        System.out.println(isOneAway("abcde", "abc"));
        System.out.println(isOneAway("abc", "abcde"));

        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true

        System.out.println(isOneAway("aaa", "abc"));  // should return false

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }


    /**
     * https://javarevisited.blogspot.com/2015/01/top-20-string-coding-interview-question-programming-interview.html#axzz6km0m7Ex0
     * 15) How to check if a String is a valid shuffle of two String? (solution)
     *
     * first = "abc" and second = "def",  third = "dabecf"  is a valid shuffle
     *
     */
    public static void validShuffle() {
        String first = "abc";
        String second = "def";
        String third = "daebfc";
        int firstIndex =0;
        int secondIndex =0;

        if(first.length()+ second.length() != third.length()) {
            System.out.println("invalid shuffle");
            return;
        }

        for (int i = 0; i < third.length(); i++) {
            if(firstIndex < first.length() &&  third.charAt(i)==first.charAt(firstIndex)){
                firstIndex++;
                continue;
            } else if(secondIndex < second.length() && third.charAt(i)==second.charAt(secondIndex)) {
                secondIndex++;
                continue;
            }
            System.out.println("invalid shuffle");
            return;
        }
        System.out.println("Valid Shuffle");
    }

    public static void firstNonRepeatingChar() {
        String input = "abacdefghija";
        List<Character> nonRepeating = new ArrayList<>();
        Set<Character> repeating = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (repeating.contains(ch)) {
                continue;
            }
            if (nonRepeating.contains(ch)) {
                nonRepeating.remove((Character) ch);
                repeating.add(ch);
            }
            nonRepeating.add(ch);
        }
        System.out.println(nonRepeating);
    }

    /**
     * O(n)  - efficient
     * return non repeating character
     * aabcb
     */
    public static void nonRepeatingCharacter() {
        String input = "aabacbxyz";
        String nonRepeatingChar = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.toCharArray().length; i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i) + 1));
                nonRepeatingChar = nonRepeatingChar.replace(String.valueOf(input.charAt(i)), "");
            } else {
                map.put(input.charAt(i), 1);
                nonRepeatingChar = nonRepeatingChar + String.valueOf(input.charAt(i));
            }
        }
        System.out.println(nonRepeatingChar);
    }

    public static void printFirstNonRepeatedCharacterFromString(){
        String input = "mmorning";
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (Character ch : input.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if(entry.getValue()==1) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }

    /**
     * Boyersmore algorithm
     * Thisiscoolandsimplesentencewheresimpleisverysimpleandcool
     */
    public static void searchText() {
        String input = "Thisiscoolandsimplesentencewheresimpleisverysimpleandcool";
        String token = "simple";
        int k = 0;
        for (int i = 0; i < input.length(); i++) {
            k = 0;
            for (int j = 0; j < token.length(); j++) {
                if (token.charAt(j) == input.charAt(i + k)) {
                    k++;
                } else {
                    break;
                }
            }
            if (k == token.length())
                System.out.println("Token found at index " + i);
        }
    }

    /**
     * string be reversed using recursion
     */
    public static String reverse(String input) {
        if (input.length() <= 0)
            return "";
        return reverse(input.substring(1)) + input.charAt(0);
    }

    /**
     * remove the duplicate character from String
     * OR
     * Print unique strings
     */
    public static void removeDuplicateCharacterFromString() {
        String input = "Programming";
        input = input.trim().toLowerCase();
        String uniqueString = "";
        for (int i = 0; i < input.length(); i++) {
            if (uniqueString.indexOf(input.charAt(i)) == -1) {
                uniqueString = uniqueString + input.charAt(i);
            }
        }
        System.out.println("UniqueString = " + uniqueString);
    }

    /**
     * length = 0
     * all dupicates
     * all negatives
     * max numbers
     */
    public static void largestOf3Numbers() {
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        int[] array = new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        if (Objects.isNull(array) || array.length == 0)
            return;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = array[i];
            } else if (array[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = array[i];
            } else if (array[i] > thirdLargest) {
                thirdLargest = array[i];
            }
        }
        System.out.println(firstLargest + ", " + secondLargest + ", " + thirdLargest);
    }


    public static void main(String[] args) {
        validShuffle();
    }
}
