package ir.sk.algorithm;

/**
 * Print all positive integer solutions to the equation a3 + b3
 * and d are integers between 1 and 1000
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/22/2020.
 */
public class SumOfCubes {

    /**
     * A brute force solution will just have four nested for loops
     *
     * Time Complexity: O(n4)
     *
     * @param n
     */
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
     *
     * It's unnecessary to continue checking for other possible values of d. Only one could work. We should at least
     * break after we find a valid solution.
     *
     * Time Complexity: O(n4)
     *
     * @param n
     */
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
}
