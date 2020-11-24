package HandlingNull;


import java.util.Objects;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class HandleNull {

    public static void throwErrorOnNull(){
        String book = null;
        Objects.requireNonNull(book, "Book is null");
    }

    public static void main(String[] args) {
        throwErrorOnNull();
    }
}
