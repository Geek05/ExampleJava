package excersise.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Bharath.MC
 * @since Nov-2020
 * Difficulty Level 1
 */
public class StringD1 {

    /**
     * find the largest subset of unique string/characters
     * aabbcc = abc
     */
    public static void uniqueString(){
        String inputText = "aabcc";
        char[] charArray = inputText.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();
        int maxDistinctLength = 0;
        String maxDistinctString ="";
        for (int i = 0; i < charArray.length; i++) {
            if(!map.containsKey(charArray[i])){
                map.put(charArray[i], i);
            } else {
                if(maxDistinctLength < map.size()) {
                    maxDistinctLength = map.size();
                    maxDistinctString = map.keySet().toString();
                }
                map.clear();
                map.put(charArray[i], i);
            }
        }
        System.out.println(maxDistinctString);
    }


    /**
     * Longest palindromic substring
     */
    public static void longestPalindromeEasy(){
        String input = "forgeeksskeegforisinmalayaayalam";
        char[] inputChar = input.toCharArray();
        String longestPalindrome = "";
        for (int i = 0; i < inputChar.length; i++) {
            for (int j = i; j <= inputChar.length; j++) {
                if(input.substring(i,j).length() < longestPalindrome.length())
                    continue;
                if(isPalindrome(input.substring(i,j)) && longestPalindrome.length() < input.substring(i,j).length()){
                    longestPalindrome = input.substring(i,j);
                }
            }
        }
        System.out.println(longestPalindrome);
    }

    private static boolean isPalindrome(String longestPalindrome) {
        int startIndex =0, endIndex = longestPalindrome.length() -1;
        boolean isPalindrome = true;
        while(startIndex < endIndex){
            if(longestPalindrome.charAt(startIndex)!=longestPalindrome.charAt(endIndex))
                return false;
            startIndex++;
            endIndex--;
        }
        return isPalindrome;
    }


    public static void main(String[] args) {
        //System.out.println(isPalindrome("geeksaskeeg"));
        longestPalindromeEasy();
    }
}
