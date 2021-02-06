package excersise.strings;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class StringExercise01 {

    //How do you reverse a given string in place?
    public static void StringReverse1() {
        String string = "Banana";
        char[] charArray = string.toCharArray();
        char[] reverseCharArray = new char[charArray.length];
        int revIndex = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            reverseCharArray[revIndex++] = charArray[i];
        }
        System.out.println(String.valueOf(reverseCharArray));
    }

    //How do you reverse a given string in place?
    public static void StringReverse2(String textToReverse) {
        if (Objects.isNull(textToReverse) || textToReverse.isEmpty())
            return;

        char[] charArray = textToReverse.toCharArray();
        int headIndex = 0, tailIndex = charArray.length - 1;
        while (headIndex < tailIndex) {
            char temp = charArray[headIndex];
            charArray[headIndex] = charArray[tailIndex];
            charArray[tailIndex] = temp;
            headIndex++;
            tailIndex--;
        }
        System.out.println(String.valueOf(charArray));
    }

    //How do you print duplicate characters from a string?
    public static void DuplicateString(String text) {
        if (Objects.isNull(text) || text.isEmpty())
            return;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        char[] charArray = text.toCharArray();
        for (int i = 0; i < text.toCharArray().length; i++) {
            if (!characterIntegerMap.containsKey(charArray[i])) {
                characterIntegerMap.put(charArray[i], 1);
            } else {
                characterIntegerMap.put(charArray[i], characterIntegerMap.get(charArray[i]) + 1);
            }
        }
        System.out.println(characterIntegerMap);
    }

    //How do you print duplicate characters from a string?
    public static void DuplicateString2(String text) {
        if (Objects.isNull(text) || text.isEmpty())
            return;
        int[] intMap = new int[255];
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            intMap[charArray[i]] = intMap[charArray[i]] + 1;
        }

        for (int i = 0; i < intMap.length; i++) {
            if (intMap[i] == 0)
                continue;
            System.out.println(((char) i) + " = " + intMap[i]);
        }
    }

    /**
     * How do you check if two strings are anagrams of each other?
     * anagrams: the classroom = schoolmaster
     * meal for one = for me alone
     */
    public static void StringAnagram1() {
        String tokenA = "the  classroom";
        String tokenB = "schoolmaster";
        if (Objects.isNull(tokenA) || tokenA.isEmpty()) {
            System.out.println("TokenA is null or empty");
            return;
        }
        if (Objects.isNull(tokenB) || tokenB.isEmpty()) {
            System.out.println("TokenB is null or empty");
            return;
        }
        if (tokenA.replace(" ", "").length() != tokenB.replace(" ", "").length()) {
            System.out.println("String lengths are not same, hence cant be anagram.");
            return;
        }
        char[] charArrayA = tokenA.toCharArray();
        char[] charArrayB = tokenB.toCharArray();
        int[] intMap = new int[255];
        for (char ch : charArrayA) {
            if (ch != ' ')
                intMap[ch] = intMap[ch] + 1;
        }

        for (char ch : charArrayB) {
            if (ch != ' ')
                intMap[ch] = intMap[ch] + 1;
        }

        for (int i = 0; i < intMap.length; i++) {
            if (intMap[i] == 0)
                continue;
            if (intMap[i] % 2 == 0)
                continue;
            if (intMap[i] % 2 != 0) {
                System.out.println("Strings are not Anagram");
                return;
            }
        }
        System.out.println("Strings are anagram");
    }

    /**
     * How do you check if two strings are anagrams of each other?
     * anagrams: the classroom = schoolmaster
     * meal for one = for me alone
     * Logic: sort both string arrays and compare
     */
    public static void StringAnagram2() {
        String tokenA = "the  classroom";
        String tokenB = "schoolmaster";
        if (Objects.isNull(tokenA) || tokenA.isEmpty()) {
            System.out.println("TokenA is null or empty");
            return;
        }
        if (Objects.isNull(tokenB) || tokenB.isEmpty()) {
            System.out.println("TokenB is null or empty");
            return;
        }
        if (tokenA.replace(" ", "").length() != tokenB.replace(" ", "").length()) {
            System.out.println("String lengths are not same, hence cant be anagram.");
            return;
        }
        char[] charArrayA = tokenA.replace(" ", "").toCharArray();
        char[] charArrayB = tokenB.replace(" ", "").toCharArray();
        Arrays.sort(charArrayA);
        Arrays.sort(charArrayB);
        if (Arrays.equals(charArrayA, charArrayB)) {
            System.out.println("Strings are anagram");
        } else {
            System.out.println("Strings are not Anagram");
        }
    }

    /**
     * How do you check if two strings are anagrams of each other?
     * anagrams: the classroom = schoolmaster
     * meal for one = for me alone
     * Logic: go over each char from first string and check if it is in indexOf String2
     */
    public static void StringAnagram3() {
        String tokenA = "meal for one";
        String tokenB = "for me alone";

        if (Objects.isNull(tokenA) || tokenA.isEmpty()) {
            System.out.println("TokenA is null or empty");
            return;
        }

        if (Objects.isNull(tokenB) || tokenB.isEmpty()) {
            System.out.println("TokenB is null or empty");
            return;
        }

        if (tokenA.replace(" ", "").length() != tokenB.replace(" ", "").length()) {
            System.out.println("String lengths are not same, hence cant be anagram.");
            return;
        }

        char[] charArrayA = tokenA.replace(" ", "").toCharArray();

        for (char ch : charArrayA) {
            if(tokenB.indexOf(ch)==-1){
                System.out.println("Strings are not Anagram");
                return;
            }
            //remove that char
            tokenB = tokenB.substring(0,tokenB.indexOf(ch)) + tokenB.substring(tokenB.indexOf(ch)+1);
        }
        System.out.println("Strings are anagram"+tokenB);
    }

    //check weather one string rotation of another
    //ex: ABACD can be rotated as CDABA
    public static void stringRotation(){
        String stringA = "ABACD";
        String stringB = "CDABA";
        if(stringA.length() != stringB.length()) {
            System.out.println("Strings are not of same length");
            return;
        }
        String stringConcat = stringA + stringA; // ABACDABACD
        System.out.println(stringConcat.indexOf(stringB)!=-1);
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

    //aaabbcccaa -> a3b2c3a2
    public static void compressString(){
        String inputString = "aaabbcccaavv "; // add last char as space or append with some char
        char[] inputArray = inputString.toCharArray();
        String compressedString = "";
        char currentChar = inputArray[0];
        int charCount = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i]!=currentChar){
                compressedString = compressedString + currentChar + charCount;
                currentChar = inputArray[i];
                charCount = 1;
            } else {
                charCount ++;
            }
        }
        System.out.println(compressedString);
    }

    //find number of words in string
    public static void countNumberOfWords(){
        String inputText = "As a software engineer, We all face some errors/exceptions while writing code! " +
                "So what do we do when we face such a problem? " +
                "If we are not sure, We google for solutions immediately.";
        String[] tokens = inputText.split("\\W+");
        System.out.println("Words Count = "+ tokens.length);
    }

    //Replace the whitspaces with #20
    public static void replaceSpaceUsingStringBuilder(){
        String text = "Hi,  how are you ?";
        final String WS_PLACE_HOLDER = "#20";
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if(ch==' ')
                stringBuilder.append(WS_PLACE_HOLDER);
            else
                stringBuilder.append(ch);
        }
        System.out.println(stringBuilder.toString());
    }

    //Replace the whitspaces with #20
    public static void replaceSpaceUsingArray(){
        String text = "Hi,  how are you ?";
        final String WS_PLACE_HOLDER = "#20";
        int spaceCount =0;
        for (char ch : text.toCharArray()) {
            if(ch==' ')
                spaceCount++;
        }
        char[] finalText = new char[(text.length() - spaceCount) + (spaceCount * WS_PLACE_HOLDER.length())];
        int finalTextIndex =0;
        for (int i=0; i<text.toCharArray().length ;i++) {
            if(text.toCharArray()[i]==' ') {
                for (char ch : WS_PLACE_HOLDER.toCharArray()) {
                    finalText[finalTextIndex++] = ch;
                }
            } else{
                finalText[finalTextIndex++] = text.toCharArray()[i];
            }
        }
        System.out.println(finalText);
    }

    public static void main(String[] args) {
        String string = "reversestring";
        printFirstNonRepeatedCharacterFromString();
    }
}
