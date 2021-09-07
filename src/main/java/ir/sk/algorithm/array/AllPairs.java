package ir.sk.algorithm.array;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.CompleteSearch;

/**
 * usually we use this technique when we want a brute force algorithm.
 *
 * Created by sad.kayvanfar on 5/30/2021.
 */
@CompleteSearch
public class AllPairs {

    /**
     * (11)(12)(13)
     * (21)(22)(23)
     * (31)(32)(33)
     *
     * @param array
     */
    @TimeComplexity("O(n ^ 2)")
    public static void allPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("("+array[i] + array[j] + ")");
            }
            System.out.println();
        }
    }

    /**
     * (11)(12)(13)
     *     (22)(23)
     *         (33)
     * @param array
     */
    @TimeComplexity("O(n ^ 2) ~ 1 + 2 + ... + (n-1) + n = n(n+1)/2")
    public static void allOrderPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                System.out.print("("+array[i] + array[j] + ")");
            }
            System.out.println();
        }
    }
}
