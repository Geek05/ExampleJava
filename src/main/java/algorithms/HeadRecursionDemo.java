package algorithms;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class HeadRecursionDemo {

    public static void calculate(int n) {
        if (n > 0) {
            calculate(n - 1);
            int k = n * n;
            System.out.println(n + "*" + n + "=" + k);
        }
    }

    public static void main(String[] args) {
        calculate(4);
    }
}
