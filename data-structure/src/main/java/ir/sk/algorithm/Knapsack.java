package ir.sk.algorithm;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Given the weights and profits of ‘N’ items,
 * we are asked to put these items in a knapsack which has a capacity ‘C’.
 * The goal is to get the maximum profit out of the items in the knapsack.
 * Each item can only be selected once, as we don’t have multiple quantities of any item.
 *
 * Created by sad.kayvanfar on 2/9/2021.
 */
public class Knapsack {

    /**
     * Given two integer arrays to represent weights and profits of ‘N’ items,
     * we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’.
     * Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
     *
     * @param profits
     * @param weights
     * @param capacity
     * @return
     */
    public static int slove10knapsack(int[] profits, int[] weights, int capacity) {
        return slove10knapsack(profits, weights, capacity, 0);
    }

    @SpaceComplexity("O(n)")
    @TimeComplexity("O(2^n), This space will be used to store the recursion stack.")
    private static int slove10knapsack(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at the currentIndex exceeds the capacity,
        // we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + slove10knapsack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);

        // recursiveIndex call after excluding the element at the currentIndex
        int profit2 = slove10knapsack(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }
}
