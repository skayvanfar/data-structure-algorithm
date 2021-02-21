package ir.sk.algorithm;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
        for (int i = coins.length - 1; i >= 0; i--) {
            // Find denominations
            while (sum >= coins[i]) {
                sum -= coins[i];
                result.add(coins[i]);
            }
        }
        return result;
    }
}
