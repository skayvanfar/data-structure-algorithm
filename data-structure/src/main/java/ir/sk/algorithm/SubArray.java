package ir.sk.algorithm;

import ir.sk.helper.*;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class SubArray {

    /*************
     * to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
     *************/

    /**
     * we'll find all subarrays starting at every index from 0 to n-1
     *
     * @param nums
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    public static int maxSubArraySumBruteForce(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < n; left++) {

            int runningWindowSum = 0;

            for (int right = left; right < n; right++) {
                runningWindowSum += nums[right];

                if (runningWindowSum > maximumSubArraySum) {
                    maximumSubArraySum = runningWindowSum;
                    start = left;
                    end = right;
                }
            }
        }
        System.out.printf("Found Maximum Subarray between %d and %d", start, end);
        return maximumSubArraySum;
    }

    /**
     * Kadane's algorithm is a popular solution to the maximum subarray problem and this solution is based on dynamic programming
     * <p>
     * The most important challenge in solving a dynamic programming problem is to find the optimal subproblems
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n)")
    @SlidingWindowPattern
    public static int maxSubArraySumKadanes(int[] arr) {

        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = 0, maxEndingHere = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }

        System.out.printf("Found Maximum Subarray between %d and %d", start, end);
        return maxSoFar;
    }

    /*  Given an unsorted array of non negative integers, find a continuous subarray which adds to a given number. */

    /**
     * A simple solution is to consider all subarrays one by one and check the sum of every subarray.
     * Run two loops: the outer loop picks a starting point I and the inner loop tries all subarrays starting from i
     *
     * @param arr
     * @param target
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @BruteForce
    @MultipleLoopsPattern
    public static void subArraySumNaive(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == target)
                    System.out.println("starting index : " + i + ", " + "Ending index : " + j);
            }
        }
    }

}
