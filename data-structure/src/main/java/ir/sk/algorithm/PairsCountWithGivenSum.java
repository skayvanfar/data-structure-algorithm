package ir.sk.algorithm;

import ir.sk.helper.BruteForce;
import ir.sk.helper.Point;

import java.util.Arrays;

/**
 * find all pairs with sum k within an array (assuming
 * all distinct elements)
 *
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsCountWithGivenSum {

    /**
     * A simple solution is be traverse each element and check if there’s another number in the array which can be added to it to give sum.
     *
     * Time Complexity: O(n2)
     * Auxiliary Space: O(1)
     *
     * @param arr
     * @param sum
     */
    @BruteForce
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
     * Time Complexity: O(n)
     * Auxiliary Space: O(n + k)
     *
     * @param arr
     * @param sum
     * @return
     */
    @Point("Using hashtable is trade off between time and space" +
            "change Multiply O(n)*O(n) into O(n)+O(n) by using hashtable")
    public static int getPairsCountByHashing(int[] arr, int sum) {

        int count = 0;// Initialize result

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // for negative numbers
        int range = max - min + 1;

        @Point("When you want to use array as hashtable use like below")
        boolean []counting = new boolean[range];

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
