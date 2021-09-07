package ir.sk.algorithm.array;

import ir.sk.helper.complexity.BCR;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.BruteForce;

/**
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 * <p>
 * Input: arr[] = {3, 1, 4, 6, 5}
 * Output: True
 * There is a Pythagorean triplet (3, 4, 5).
 * Input: arr[] = {10, 4, 6, 12, 5}
 * Output: False
 * There is no Pythagorean triplet.
 * <p>
 * Created by sad.kayvanfar on 7/7/2021.
 */
@BCR(bigOTime = "O(n^2)")
public class Pythagorean {

    /**
     * A simple solution is to run three loops, three loops pick three array elements,
     * and check if current three elements form a Pythagorean Triplet.
     *
     * @param ar
     * @return
     */
    @TimeComplexity("O(n^3)")
    @SpaceComplexity("O(1)")
    @BruteForce
    public static boolean isTripletNaive(int ar[]) {
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                for (int k = j + 1; k < ar.length; k++) {
                    // Calculate square of array elements
                    int x = ar[i] * ar[i], y = ar[j] * ar[j], z = ar[k] * ar[k];

                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }

        // If we reach here, no triplet found
        return false;
    }

    /**
     * We can use a hash map to mark all the values of the given array.
     * Using two loops, we can iterate for all the possible combinations of a and b, and then check if there exists the third value c.
     * If there exists any such value, then there is a Pythagorean triplet.
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(n)")
    public static boolean isTripletByHashing(int arr[]) {
        int maximum = 0;

        // Find the maximum element
        for (int i = 0; i < arr.length; i++) {
            maximum = Math.max(maximum, arr[i]);
        }

        // Hashing array
        int[] hash = new int[maximum + 1];

        // Increase the count of array elements
        // in hash table
        for (int i = 0; i < arr.length; i++)
            hash[arr[i]]++;

        // Iterate for all possible a
        for (int i = 1; i < maximum + 1; i++) {

            // If a is not there
            if (hash[i] == 0)
                continue;

            // Iterate for all possible b
            for (int j = 1; j < maximum + 1; j++) {

                // If a and b are same and there is only one a
                // or if there is no b in original array
                if ((i == j && hash[i] == 1) || hash[j] == 0)
                    continue;

                // Find c
                int val = (int) Math.sqrt(i * i + j * j);

                // If c^2 is not a perfect square
                if ((val * val) != (i * i + j * j))
                    continue;

                // If c exceeds the maximum value
                if (val > maximum)
                    continue;

                // If there exists c in the original array,
                // we have the triplet
                if (hash[val] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
