package ir.sk.algorithm;

import ir.sk.helper.BruteForce;

/**
 * Created by sad.keyvanfar on 6/25/2020.
 */
public class Fibonacci {

    /**
     * Use recursion
     *
     * Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
     * t(n) = 2 ^ (n/2)
     * Time Complexity:O(2^n) exponential
     * Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
     *
     * @param n
     * @return
     */
    @BruteForce
    public static long naiveFibonacciByRecursive(long n) {
        if (n == 0 || n == 1)
            return n;
        else
            return naiveFibonacciByRecursive(n - 1) + naiveFibonacciByRecursive(n - 2);
    }

    public static int memoizedDPFibonacciByRecursive(int n) {
        int[] memo = new int[n + 1];
        return memoizedDPFibonacciByRecursive(n, memo);
    }

    /**
     * memoized Dynamic Programming algorithm, remember, Top-Down Approach = Recursive + Memoization
     * time = subproblems * time/subproblem = n*O(1) = O(n)
     *
     * Time Complexity:O(n)
     * space complexity: O(n)
     *
     * @param n
     * @param memo
     * @return
     */
    private static int memoizedDPFibonacciByRecursive(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];

        if (n == 0 || n == 1)
            return n;
        else {
            int result = memoizedDPFibonacciByRecursive(n - 1, memo) + memoizedDPFibonacciByRecursive(n - 2, memo);
            memo[n] = result;
            return result;
        }
    }

    /**
     * Use Dynamic Programming The Top-Down Approach
     *
     * Time Complexity:O(n)
     * space complexity: O(n)
     *
     * @param n
     * @return
     */
    public static int memoizedDPFibonacciByIterative(int n) {
        int[] array = new int[n + 1];
        array[0] = 0;
        if (n > 0) {
            array[1] = 1;
            for (int i = 2; i <= n; i++) {
                array[i] = array[i - 1] + array[i - 2];
            }
        }
        return array[n];
    }

    /**
     * Use Dynamic Programming using Space Optimized fibonacciByArray The Bottom-Up Algorithm
     * Topological sort of subproblem dependency DAG
     *
     * Time Complexity:O(n)
     * Extra Space: O(1)
     *
     * @param n
     * @return
     */
    public static int bottomUpDPFibonacci(int n) {
        int low = 0;
        int high = 1;
        for (int i = 1; i <= n; i++) {
            high = low + high;
            low = high - low;
        }
        return low;
    }

}
