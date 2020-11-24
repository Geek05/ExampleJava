package excersise.strings;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class StringCounting {

    //aaabbcccaa -> a5b2c3
    public static void countChars(){
        String inputString = "aaabbcccaa";
        int[] intMap = new int[255];
        char[] inputArray = inputString.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            intMap[inputArray[i]] = intMap[inputArray[i]] + 1;
        }

        for (int i = 0; i < intMap.length; i++) {
            if(intMap[i]==0)
                continue;
            System.out.print((char)i+""+intMap[i]);
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

    //find number of words in string
    public static void countNumberOfWords2(){
        String inputText = "As a software engineer, We all face some errors/exceptions while writing code! " +
                "So what do we do when we face such a problem? " +
                "If we are not sure, We google for solutions immediately.";

    }

    public static void main(String[] args) {
        countNumberOfWords();
    }
}
