package ExceptionHandling;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class ExceptionExercise01 {

    public static String returnOnCatch(){
        try{
            String s = null;
            s.length();
        }catch (NullPointerException e){
            e.printStackTrace();
            return "this is exception return";
        } finally {
            System.out.println("this is finally");
        }
        return "this is final return";
    }

    public static void uncheckedException(){
        if(true)
            throw new RuntimeException("THis is unchecked exception and need not be handled in method");
    }

    public static void main(String[] args) {
        uncheckedException();
    }
}
