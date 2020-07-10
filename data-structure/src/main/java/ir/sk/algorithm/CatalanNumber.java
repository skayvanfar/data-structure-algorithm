package ir.sk.algorithm;

/**
 *
 * 1 1 2 5 14 42 132 429 1430 4862
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/10/2020.
 */
public class CatalanNumber {

    /**
     * Divide-and-conquer algorithm and recursive
     *
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     *
     * @param n
     * @return
     */
    public static long catalanByRecursive(int n) {
        // base case
        if (n <= 1)
            return 1;
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum += (catalanByRecursive(i) * catalanByRecursive(n - i - 1));
        return sum;
    }

    /**
     * Dynamic Programing
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param n
     * @return
     */
    public static long catalanDynamic(int n) {
        // Table to store results of subproblems
        int catalan[] = new int[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        // Return last entry
        return catalan[n];
    }

}
