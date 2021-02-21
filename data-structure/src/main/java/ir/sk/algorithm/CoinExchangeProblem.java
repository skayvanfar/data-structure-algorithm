package ir.sk.algorithm;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.CompleteSearch;
import ir.sk.helper.technique.DynamicProgramming;
import ir.sk.helper.technique.DynamicProgrammingType;
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
    @TimeComplexity("O(sum)")
    @SpaceComplexity("O(1)")
    @GreedyAlgorithm
    public static List<Integer> findMinCoinsGreedy(int[] coins, int sum) {
        List<Integer> result = new ArrayList<>();

        // Traverse through all
        for (int i = 0; i < coins.length; i++) {
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
     *
     * @param coins
     * @param sum
     * @return
     */
    @TimeComplexity("O(2^n)")
    @CompleteSearch
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

    /**
     * @param coins
     * @param sum
     * @return
     */
    @TimeComplexity("O(n*sum)")
    @DynamicProgramming(type = DynamicProgrammingType.DOWN_TOP_TABULATION)
    public static int findMinCoinsByByDP(int coins[], int sum) {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[sum] will have result
        int table[] = new int[sum + 1];

        // Base case (If given value sum is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i = 1; i <= sum; i++)
            table[i] = Integer.MAX_VALUE;

        // Compute minimum coins required for all
        // values from 1 to sum
        for (int i = 1; i <= sum; i++) {
            // Go through all coins smaller than i
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < table[i])
                        table[i] = sub_res + 1;
                }

        }

        if (table[sum] == Integer.MAX_VALUE)
            return -1;

        return table[sum];

    }
}
