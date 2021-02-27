package ir.sk.algorithm.others;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BacktrackingDFS;
import ir.sk.helper.technique.DynamicProgramming;
import ir.sk.helper.technique.DynamicProgrammingType;

/**
 * Given the weights and profits of ‘N’ items,
 * we are asked to put these items in a knapsack which has a capacity ‘C’.
 * The goal is to get the maximum profit out of the items in the knapsack.
 * Each item can only be selected once, as we don’t have multiple quantities of any item.
 *
 * Created by sad.kayvanfar on 2/9/2021.
 */
public class Knapsack {

    public static int solve10knapsack(int[] profits, int[] weights, int capacity) {
        return solve10knapsack(profits, weights, capacity, 0);
    }

    /**
     * Given two integer arrays to represent weights and profits of ‘N’ items,
     * we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’.
     * Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
     *
     * @param profits
     * @param weights
     * @param capacity
     * @param currentIndex
     * @return
     */
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(2^n), This space will be used to store the recursion stack.")
    @BacktrackingDFS
    private static int solve10knapsack(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at the currentIndex exceeds the capacity,
        // we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + solve10knapsack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

        // recursiveIndex call after excluding the element at the currentIndex
        int profit2 = solve10knapsack(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }


    public static int slove10knapsackByDP(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return slove10knapsackByDP(dp, profits, weights, capacity, 0);
    }

    /**
     * @param dp
     * @param profits
     * @param weights
     * @param capacity
     * @param currentIndex
     * @return
     */
    @SpaceComplexity("O(n*c + n) = O(n*c)")
    @TimeComplexity("O(n*c), ‘C’ is the knapsack capacity")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    private static int slove10knapsackByDP(Integer[][] dp, int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // if we have already solved a similar problem, return the result from memory
        if (dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at the currentIndex exceeds the capacity,
        // we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + solve10knapsack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

        // recursiveIndex call after excluding the element at the currentIndex
        int profit2 = solve10knapsack(profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }
}
