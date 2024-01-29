package ir.sk.algorithm.others;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.paradigm.BruteForce;

import java.util.HashMap;
import java.util.Map;

/**
 * Print all positive integer solutions to the equation a3 + b3
 * and d are integers between 1 and 1000
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 8/22/2020.
 */
public class SumOfCubes {

    /**
     * A brute force solution will just have four nested for loops
     *
     * @param n
     */
    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(n4)")
    public static void sumOfCubesNative(int n) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (a + b == c + d)
                            System.out.printf("%d, %d, %d, %d\n", a, b, c, d);
                    }
                }
            }
        }
    }

    /**
     * Unnecessary Work
     * <p>
     * It's unnecessary to continue checking for other possible values of d. Only one could work. We should at least
     * break after we find a valid solution.
     *
     * @param n
     */
    @TimeComplexity("O(n4)")
    public static void sumOfCubesNativeOptimize(int n) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (a + b == c + d) {
                            System.out.printf("%d, %d, %d, %d\n", a, b, c, d);
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Unnecessary Work
     * <p>
     * Is there anything else that is unnecessary? Yes. If there's onl one valid d value for each (a, b, c), then we can
     * just compute it.
     *
     * @param n
     */
    @TimeComplexity("O(n3)")
    public static void sumOfCubesNativeOptimize2(int n) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    int d = a + b - c;
                    if (a + b == c + d) {
                        System.out.printf("%d, %d, %d, %d\n", a, b, c, d);
                        break;
                    }
                }
            }
        }
    }

    // Class to represent a pair
    static class pair {
        public int first, second;

        pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    /**
     * Duplicated Work
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n2)")
    @HashingIndexPattern("Using Map")
    public static void sumOfCubesOptimizeByHashing(int n) {
        // Create an empty Hash to store mapping from sum to
        // pair indexes
        Map<Integer, pair> map = new HashMap<>();

        // Traverse through all possible pairs of arr[]
        for (int c = 0; c < n; ++c) {
            for (int d = c + 1; d < n; ++d) {
                // If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = c + d;
                if (!map.containsKey(sum))
                    map.put(sum, new pair(c, d));

                else { // Else (Sum already present in hash)

                    // Find previous pair
                    pair p = map.get(sum);

                    // Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                    System.out.println("(" + p.first + ", " + p.second +
                            ") and (" + c + ", " + d + ")");
                }
            }
        }
    }
}
