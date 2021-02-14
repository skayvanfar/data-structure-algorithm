package ir.sk.algorithm;

import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.recursiontype.TailRecursion;
import ir.sk.helper.technique.*;

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

    /**
     * Magic Index (Fixed Point): A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
     * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
     * array A.
     * <p>
     * Linearly search for an index i such that arr[i] == i. Return the first such index found.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int magicIndexNaive(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i)
                return i;
        }
        return -1;
    }

    /**
     *
     * @param array
     * @return
     */
    public static int magicIndexBinarySearch(int[] array) {
        return binarySearch(array, 0, array.length - 1);
    }


    /**
     * @param arr
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(Log n)")
    @SpaceComplexity("O(1)")
    @BinarySearch
    @DecreaseAndConquer
    private static int binarySearch(int arr[], int low, int high) {
        if (high >= low) {
            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if (mid == arr[mid])
                return mid;
            if (mid > arr[mid])
                return binarySearch(arr, (mid + 1), high);
            else
                return binarySearch(arr, low, (mid - 1));
        }

        return -1;
    }


}
