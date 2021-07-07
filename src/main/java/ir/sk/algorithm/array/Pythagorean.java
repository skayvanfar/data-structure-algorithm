package ir.sk.algorithm.array;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

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
}
