package ir.sk.algorithm;

import ir.sk.helper.*;

import java.util.Arrays;

/**
 * find all pairs with sum k within an array (assuming
 * all distinct elements)
 * <p>
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsCountWithGivenSum {

    /**
     * A simple solution is be traverse each element and check if there’s another number in the array which can be added to it to give sum.
     *
     * @param arr
     * @param sum
     */
    @BruteForce
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static int getPairsCount(int[] arr, int sum) {

        int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        // O(n)
        for (int i = 0; i < arr.length; i++)
            // O(n)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;

        return count;
    }

    /**
     * for every element check if it can be combined with any other element (other than itself!) to give the desired sum
     *
     * @param arr
     * @param sum
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n + k)")
    @Point("Using hashtable is trade off between time and space" +
            "change Multiply O(n)*O(n) into O(n)+O(n) by using hashtable")
    @FrequencyCountingPattern
    public static int getPairsCountByHashing(int[] arr, int sum) {

        int count = 0;// Initialize result

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // for negative numbers
        int range = max - min + 1;

        @Point("When you want to use array as hashtable use like below")
        boolean[] counting = new boolean[range];

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i] - min] = true;
        }

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            int b = sum - arr[i];
            // O(1)
            if (counting[b - min] && b > arr[i])
                count++;
        }

        return count;
    }
}
