package excersise.dynamicProgramming;

/**
 * @author Bharath.MC
 * @since Jan-2021
 */
public class StairwayToHeaven {

    /**
     * Problem:
     * we have stair way, which has N steps. We can climb stairs either 1 step or 2 step at a time.
     * Find the maximum possible way to climb the stairs.
     * ex1: Stairs has 3 steps = possible ways are 3
     * ex2: Stairs has 4 steps = possible ways are 5
     * <p>
     * In below case statis has 3 steps and max possible way to reach heaven is 3
     * ___
     * ___|
     * ___|
     * |
     *
     * Video: /My Passport/Acamedic/DataStructure/[FreeCourseSite.com] Udemy - Dynamic Programming - I/2. Solved Problems I
     */
    public static int ways(int n, int[] waysCache) {
        if (n <= 0)
            return 1;
        if (n == 1)
            return 1;
        if (waysCache[n] != 0) {
            return waysCache[n];
        }
        int result = ways(n - 1, waysCache) + ways(n - 2, waysCache);
        waysCache[n] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(ways(3, new int[6]));
    }
}
