package ir.sk.algorithm.others;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.technique.BinarySearch;
import ir.sk.helper.technique.BruteForce;

import java.util.Arrays;

/**
 * Given an array of distinct integer values, count the number of pairs of integers that
 * have difference k. For example, given the array { 1, 7, 5, 9, 2, 12, 3} and the difference
 * k = 2,there are four pairs with difference2: (1, 3), (3, 5), (5, 7), (7, 9).
 * <p>
 * Optimize & Solve Technique: 1. Bottlenecks
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/22/2020.
 */
public class CountPairsWithDiffK {

    /**
     * A simple solution is to consider all pairs one by one and check difference between every pair
     * We run two loops: the outer loop picks the first element of pair, the inner loop looks for the other element.
     * This solution doesn’t work if there are duplicates in array as the requirement is to count only distinct pairs.
     *
     * @param arr
     * @param k
     * @return
     */
    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static int countPairsWithDiffKNative(int arr[], int k) {
        int n = arr.length;
        int count = 0;

        // Pick all elements one by one
        for (int i = 0; i < n; i++) {
            // See if there is a pair
            // of this picked element
            for (int j = i + 1; j < n; j++)
                if (arr[i] - arr[j] == k ||
                        arr[j] - arr[i] == k)
                    count++;
        }
        return count;
    }

    /**
     * We can find the count in O(nLogn) time using a O(nLogn) sorting algorithm like Merge Sort, Heap Sort, etc.
     * <p>
     * The first step (sorting) takes O(nLogn) time. The second step runs binary search n times,
     * so the time complexity of second step is also O(nLogn).
     * Therefore, overall time complexity is O(nLogn).
     *
     * @param arr
     * @param k
     * @return
     */
    public static int countPairsWithDiffK1(int arr[], int k) {
        int n = arr.length;
        int count = 0, i;

        // Sort array elements
        Arrays.sort(arr);

        // code to remove duplicates from arr[]

        // Pick a first element point
        for (i = 0; i < n - 1; i++)
            if (binarySearch(arr, i + 1, n - 1, arr[i] + k) != -1)
                count++;

        return count;
    }

    @BinarySearch
    private static int binarySearch(int arr[], int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (x == arr[mid])
                return mid;
            if (x > arr[mid])
                return binarySearch(arr, (mid + 1),
                        high, x);
            else
                return binarySearch(arr, low,
                        (mid - 1), x);
        }
        return -1;
    }

    /**
     * 1) Initialize count as 0.
     * 2) Insert all distinct elements of arr[] in a hash map.  While inserting,
     * ignore an element if already present in the hash map.
     * 3) Do following for each element arr[i].
     * a) Look for arr[i] + k in the hash map, if found then increment count.
     * b) Look for arr[i] - k in the hash map, if found then increment count.
     * c) Remove arr[i] from hash table.
     *
     * @param arr
     * @param k
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n+k)")
    @HashingIndexPattern
    public static int countPairsWithDiffKByHashing(int arr[], int k) {
        int n = arr.length;
        int count = 0;  // Initialize count

        int max = Arrays.stream(arr).max().getAsInt();

        // When key and value are the same we can use this method. using boolean array.
        boolean[] hashtable = new boolean[max + 1];

        for (int i = 0; i < n; i++) {
            hashtable[arr[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (x - k >= 0 && hashtable[x - k])
                count++;
            if (x + k <= max && hashtable[x + k])
                count++;
            hashtable[x] = false;
        }
        return count;
    }
}
