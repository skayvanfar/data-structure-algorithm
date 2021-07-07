package ir.sk.algorithm.array;

import ir.sk.algorithm.others.Sort;
import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.recursiontype.TailRecursion;
import ir.sk.helper.technique.BruteForce;
import ir.sk.helper.technique.DynamicProgramming;
import ir.sk.helper.technique.DynamicProgrammingType;

/**
 * See also {@link ir.sk.algorithm.mathematic.Fibonacci}
 *
 * Created by sad.kayvanfar on 7/7/2021.
 */
public class Staircase {

    /**
     * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
     * steps at a time. Implement a method to count how many possible ways the child can run up the
     * stairs.
     * <p>
     * Lets define n as the n-th step of this stairs, and T(n) is the number of ways the child can run up to the n-th step.
     * This child could arrive at the n-th step from 3 different possible prior steps, namely (n-1), (n-2), and (n-3).
     * The key insight is that the number of possible ways of the n-th step, T(n),
     * is the summation of the number possible ways of these 3 possible prior steps.
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(3^n) O(branches ^ depth)")
    @SpaceComplexity("O(1)")
    @BruteForce
    @Implementation(type = ImplementationType.Recursive)
    @RecurrenceRelation("T(n) = T(n-1) + T(n-2) + T(n-3)")
    @TailRecursion
    public static int naiveCountWays(int n) {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else
            return naiveCountWays(n - 1) + naiveCountWays(n - 2) + naiveCountWays(n - 3);
    }

    /**
     * See {@link #naiveCountWays(int)}
     *
     * @param n
     * @return
     */
    public static int memoizedDPCountWaysByRecursive(int n) {
        int[] memo = new int[n + 1];
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
        else if (memo[n] > 0)
            return memo[n];
        else {
            memo[n] = memoizedDPCountWaysByRecursive(n - 1, memo) + memoizedDPCountWaysByRecursive(n - 2, memo) +
                    memoizedDPCountWaysByRecursive(n - 3, memo);
            return memo[n];
        }
    }

    /**
     * tart computing values of states from 1, 2 .. to n, i.e. compute values of i, i+1, i+2 and then use them to calculate the value of i+3.
     * <p>
     * See also {@link #memoizedDPCountWaysByRecursive(int)}
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @DynamicProgramming(type = DynamicProgrammingType.DOWN_TOP_TABULATION)
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

}
