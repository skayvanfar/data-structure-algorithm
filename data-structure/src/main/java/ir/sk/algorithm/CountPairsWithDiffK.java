package ir.sk.algorithm;

import java.util.Arrays;

/**
 * Given an array of distinct integer values, count the number of pairs of integers that
 * have difference k. For example, given the array { 1, 7, 5, 9, 2, 12, 3} and the difference
 * k = 2,there are four pairs with difference2: (1, 3), (3, 5), (5, 7), (7, 9).
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/22/2020.
 */
public class CountPairsWithDiffK {

    /**
     * A simple solution is to consider all pairs one by one and check difference between every pair
     * We run two loops: the outer loop picks the first element of pair, the inner loop looks for the other element.
     * This solution doesn’t work if there are duplicates in array as the requirement is to count only distinct pairs.
     *
     * Time Complexity: O(n2)
     * Space Complexity: O(1)
     *
     * @param arr
     * @param k
     * @return
     */
    public static int countPairsWithDiffKNative(int arr[], int k) {
        int n = arr.length;
        int count = 0;

        // Pick all elements one by one
        for (int i = 0; i < n; i++)
        {
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
     *
     * The first step (sorting) takes O(nLogn) time. The second step runs binary search n times,
     * so the time complexity of second step is also O(nLogn).
     * Therefore, overall time complexity is O(nLogn).
     *
     * @param arr
     * @param k
     * @return
     */
    public static int countPairsWithDiffK(int arr[], int k) {
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
}
