package algorithms;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class TreeRecursionDemo {

    public static void calculate(int n) {
        if (n > 0) {
            calculate(n - 1); // 5, 4, 3, 2, 1
            int k = n * n;
            System.out.println(n + "*" + n + "=" + k);
            calculate(n - 1); //
        }
    }

    public static void main(String[] args) {
        calculate(3);
    }
}
