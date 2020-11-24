package excersise.strings;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class StringsExcercise03 {

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
        replaceSpaceUsingArray();
    }
}
