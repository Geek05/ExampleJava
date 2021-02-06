package excersise.dynamicProgramming;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class FibonacciSeries {

    /**
     * without DP
     * 0 1 1 2 3 5 8
     */
    public static int fib(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * With Dynamic Programming
     * Top Down approach - Memorization
     * <p>
     * System.out.println(fibDP(4, new int[7]));
     */
    public static int fibDP(int n, int[] cache) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (cache[n] != 0) {
            return cache[n]; //cache which stores the computed sub problem solution
        }
        int result = fibDP(n - 1, cache) + fibDP(n - 2, cache);
        cache[n] = result;
        return result;
    }

    /**
     * With Dynamic Programming
     * Bottom up approach - Tabulation
     */
    public static int fibTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fibTab(6));
    }
}
