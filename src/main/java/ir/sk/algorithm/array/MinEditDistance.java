package ir.sk.algorithm.array;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * Given two strings, determine the edit distance between them. The edit distance is defined as the minimum number of edits (insertion, deletion, or substitution) needed to change one string to the other.
 * <p>
 * For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a t).
 */
public class MinEditDistance {

    private static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    /**
     * The idea is process all characters one by one staring from either from left or right sides of both strings.
     * Let us traverse from right corner, there are two possibilities for every pair of character being traversed.
     *
     * m: Length of str1 (first string)
     * n: Length of str2 (second string)
     * If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
     * Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
     * Insert: Recur for m and n-1
     * Remove: Recur for m-1 and n
     * Replace: Recur for m-1 and n-1
     * Below is implementation of above Naive recursive solution.
     *
     * @param str1
     * @param str2
     * @param m
     * @param n
     * @return
     */
    @TimeComplexity("O(3^m)")
    public static int minEditDistanceNaive(String str1, String str2, int m, int n) {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same,
        // nothing much to do. Ignore last characters and
        // get count for remaining strings.
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return minEditDistanceNaive(str1, str2, m - 1, n - 1);

        // If last characters are not same, consider all
        // three operations on last character of first
        // string, recursively compute minimum cost for all
        // three operations and take minimum of three
        // values.
        return 1 + min(minEditDistanceNaive(str1, str2, m, n - 1), // Insert
                minEditDistanceNaive(str1, str2, m - 1, n), // Remove
                minEditDistanceNaive(str1, str2, m - 1, n - 1) // Replace
        );
    }
}
