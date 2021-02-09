package ir.sk.algorithm;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BruteForce;
import ir.sk.helper.technique.DynamicProgramming;
import ir.sk.helper.technique.DynamicProgrammingType;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
 * steps at a time. Implement a method to count how many possible ways the child can run up the
 * stairs.
 * <p>
 * Created by sad.kayvanfar on 9/22/2020.
 */
public class TripleStep {

    /**
     * @param n
     * @return
     */
    @TimeComplexity("O(n^3) O(branches ^ depth)")
    @SpaceComplexity("O(1)")
    @BruteForce
    public static int naiveCountWays(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else
            return naiveCountWays(n - 1) + naiveCountWays(n - 2) + naiveCountWays(n - 3);
    }

    public static int memoizedDPCountWaysByRecursive(int n) {
        int[] memo = new int[n];
        return memoizedDPCountWaysByRecursive(n, memo);
    }

    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    private static int memoizedDPCountWaysByRecursive(int n, int[] memo) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else if (memo[n] > -1)
            return memo[n];
        else {
            memo[n] = memoizedDPCountWaysByRecursive(n - 1, memo) + memoizedDPCountWaysByRecursive(n - 2, memo) +
                    memoizedDPCountWaysByRecursive(n - 3, memo);
            return memo[n];
        }
    }

    // A recursive function used by countWays
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int bottomUpCountWays(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2]
                    + res[i - 3];

        return res[n];
    }

    /**
     * elements are not distinct
     *
     * @param array
     * @return
     */
    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    /**
     * elements are not distinct
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int magicFast(int[] array, int start, int end) {
        if (end < start) return -1;

        int midindex = (start + end) / 2;
        int midValue = array[midindex];
        if (midValue == midindex)
            return midindex;

        /* Search left */
        int leftindex = Math.min(midindex - 1, midValue);
        int left = magicFast(array, start, leftindex);
        if (left >= 0)
            return left;


        /* Search right */
        int rightIndex = Math.max(midindex + 1, midValue);
        int right = magicFast(array, rightIndex, end);

        return right;
    }


}
