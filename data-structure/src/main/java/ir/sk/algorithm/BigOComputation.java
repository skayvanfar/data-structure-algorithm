package ir.sk.algorithm;

import ir.sk.helper.TimeComplexity;

/**
 * There are few methods to compute Big O of alghoritms. In this class we show the m by examples.
 * 1. Counting the Iterations
 * 2. What It Means: thinking about what the code "means:
 * 3. What It Does: Visualizing
 * 4. Recursive Pattern: O(branches ^ depth). Only for recursive alghoritm. the runtime of a recursive function with multiple branches is typically O( branchesdepth).
 * <p>
 * Created by sad.kayvanfar on 8/31/2020.
 */
public class BigOComputation {

    /**
     * 1. Counting the Iterations:
     * The first time through j runs for N-1 steps. The second time, it's N-2 steps. Then N-3 steps. And so on.
     * Therefore, the number of steps total is:
     * (N-1) + (N-2) + (N-3) + ... + 2 + 1 = 1 + 2 + 3 + ... + N-1 = sum of 1 through N-1 = n(n-1)/2 =O(n^2)
     *
     * 2. What It Means
     * It iterates througheach pair of values for ( i, j) where j is bigger than i.
     * There are N2 total pairs. Roughly half of those will have i < j and the remaining half will have i > j. This
     * code goes through roughly Nx pairs so it does O(N2) work.
     *
     * 3. Visualizing What It Does
     * The code iterates through the following ( i, j) pairs when N = 8:
     * (0, 1) (0, 2) (0, 3) (0, 4) (0, 5) (0, 6) (0, 7)
     *        (1, 2) (1, 3) (1, 4) (1, 5) (1, 6) (1, 7)
     *               (2, 3) (2, 4) (2, 5) (2, 6) (2, 7)
     *                      (3, 4) (3, 5) (3, 6) (3, 7)
     *                             (4, 5) (4, 6) (4, 7)
     *                                    (5, 6) (5, 7)
     *                                           (6, 7)
     * This looks like half of an NxN matrix, which has size (roughly) N/i. Therefore, it takes O ( N2) time.
     * @param array
     */
    @TimeComplexity("O(n^2)")
    public static void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
}
