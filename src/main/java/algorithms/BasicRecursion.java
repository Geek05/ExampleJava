package algorithms;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class BasicRecursion {

    public static void printNumbers(Integer n) {
        if (n <= 0)
            return;
        printNumbers(n - 1);
        System.out.println(n);
    }

    static int sum = 0;

    public static void sumOfNnaturalNumbers(int n) {
        if (n > 0) {
            sum += n;
            sumOfNnaturalNumbers(n - 1);
        } else {
            System.out.println(sum);
        }
    }

    /**
     * using recurance relation
     * sum = 1 + 2 + 3 + 4 ...(n-2) + (n-1) + n
     * <p>
     * can be written as
     * sum(n-1)+n  when n >1
     * 1  when n=1
     */
    public static int sum(int n) {
        if (n == 1)
            return 1;
        return sum(n - 1 ) + n;
    }

    public static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;
        return fact(n - 1 ) * n;
    }

    public static void main(String[] args) {
        System.out.println(fact(5));
    }
}
