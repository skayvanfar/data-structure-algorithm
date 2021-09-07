package ir.sk.algorithm.mathematic;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.BruteForce;
import ir.sk.helper.paradigm.DynamicProgramming;
import ir.sk.helper.paradigm.DynamicProgrammingType;

/**
 * Created by sad.keyvanfar on 6/25/2020.
 */
public class Fibonacci {

    /**
     * Use recursion
     *
     * @param n
     * @return
     */
    @BruteForce
    @TimeComplexity("T(n-1) + T(n-2) which is exponential. t(n) = 2 ^ (n/2). O(2^n) exponential. O(branches ^ depth)")
    @SpaceComplexity(" O(n) if we consider the function call stack size, otherwise O(1)")
    public static long naiveFibonacciByRecursive(long n) {
        if (n == 0 || n == 1)
            return n;
        else
            return naiveFibonacciByRecursive(n - 1) + naiveFibonacciByRecursive(n - 2);
    }

    public static int memoizedDPFibonacciByRecursive(int n) {
        int[] memoize = new int[n + 1];
        return memoizedDPFibonacciByRecursive(n, memoize);
    }

    /**
     * memoized Dynamic Programming algorithm, remember, Top-Down Approach = Recursive + Memoization
     * time = subproblems * time/subproblem = n*O(1) = O(n)
     *
     * @param n
     * @param memoize
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    private static int memoizedDPFibonacciByRecursive(int n, int[] memoize) {
        if (n < 2)
            return n;
        // if we have already solved this sub problem, simply return the result from the cache
        if (memoize[n] != 0)
            return memoize[n];

        memoize[n] = memoizedDPFibonacciByRecursive(n - 1, memoize) + memoizedDPFibonacciByRecursive(n - 2, memoize);
        return memoize[n];
    }

    /**
     * Use Dynamic Programming The Top-Down Approach
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @DynamicProgramming(type = DynamicProgrammingType.DOWN_TOP_TABULATION)
    public static int memoizedDPFibonacciByIterative(int n) {
        if (n == 0) return 0;
        int[] table = new int[n + 1];

        //base cases
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i <= n; i++)
            table[i] = table[i - 1] + table[i - 2];

        return table[n];
    }

    /**
     * Use Dynamic Programming using Space Optimized fibonacciByArray The Bottom-Up Algorithm
     * Topological sort of subproblem dependency DAG
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @DynamicProgramming(type = DynamicProgrammingType.DOWN_TOP_TABULATION)
    public static int bottomUpDPFibonacci(int n) {
        int low = 0;
        int high = 1;
        for (int i = 1; i <= n; i++) {
            high = low + high;
            low = high - low;
        }
        return low;
    }

    /**
     * prints all Fibonacci numbers from O to n
     *
     * @param n
     */
    @TimeComplexity("O(2^1 + 2^2 + 2^3 + 2^4 + , , , + 2^n)=O(2^n). exponential")
    public static void allFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + naiveFibonacciByRecursive(i));
        }
    }

    /**
     * @param n
     */
    @TimeComplexity("O(n)")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    public static void allFibonacciMemoized(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + memoizedDPFibonacciByRecursive(i, memo));
        }
    }

}
