package ir.sk.algorithm;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 2/21/2021.
 */
public class CoinExchangeProblem {


    /**
     * Coin exchange problem is nothing but finding the minimum number of coins (of certain denominations)
     * that add up to a given amount of money. It is a knapsack type problem.
     *
     * @param coins
     * @param sum
     * @return
     */
    @TimeComplexity("O(V)")
    @SpaceComplexity("O(1)")
    @GreedyAlgorithm
    public static List<Integer> findMinCoinsGreedy(int[] coins, int sum) {
        List<Integer> result = new ArrayList<>();

        // Traverse through all
        for (int i = 0; i< coins.length; i++) {
            // Find denominations
            while (sum >= coins[i]) {
                sum -= coins[i];
                result.add(coins[i]);
            }
        }
        return result;
    }

    /**
     * The time complexity of the solution is exponential
     * @param coins
     * @param sum
     * @return
     */
    @TimeComplexity("O(2^n)")
    public static int findMinCoinsByRecursive(int coins[], int sum) {
        // base case
        if (sum == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than sum
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= sum) {
                int sub_res = findMinCoinsByRecursive(coins, sum - coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        return res;
    }
}
