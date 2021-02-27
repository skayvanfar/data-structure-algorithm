package ir.sk.algorithm.others;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.*;

import java.util.*;

/**
 * Created by sad.kayvanfar on 2/21/2021.
 */
public class CoinExchangeProblem {


    /**
     * Coin exchange problem is nothing but finding the minimum number of coins (of certain denominations)
     * that add up to a given amount of money. It is a knapsack type problem.
     *
     * For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
     * So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
     * So the output should be 5.
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
        int minNumCoins = Integer.MAX_VALUE;

        // Try every coin that has smaller value than sum
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= sum) {
                int numCoins = findMinCoinsByRecursive(coins, sum - coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (numCoins != Integer.MAX_VALUE && numCoins + 1 < minNumCoins)
                    minNumCoins = numCoins + 1;
            }
        }
        return minNumCoins;
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

    /**
     * We have already seen how to solve this problem using dynamic-programming approach in {@link #findMinCoinsByByDP(int[], int)}.
     * Here, we will see a slightly different approach to solve this problem using BFS.
     *
     * @param sum
     * @param coin
     * @return
     */
    @BFS
    @TimeComplexity("O(n*sum)")
    public static int findMinCoinsByByBFS(int[] coin, int sum) {
        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Base value in queue
        q.add(sum);

        // Boolean array to check if
        // a number has been visited before
        Set<Integer> v = new HashSet<>();

        // Variable to store depth of BFS
        int d = 0;

        // BFS algorithm
        while (q.size() > 0) {

            // Size of queue
            int s = q.size();
            while (s-- > 0) {

                // Front most element of the queue
                int c = q.peek();

                // Base case
                if (c == 0)
                    return d;
                q.remove();
                if (v.contains(c) || c < 0)
                    continue;

                // Setting current state as visited
                v.add(c);

                // Pushing the required states in queue
                for (int i = 0; i < coin.length; i++)
                    q.add(c - coin[i]);
            }
            d++;
        }

        // If no possible solution
        return -1;
    }
}
