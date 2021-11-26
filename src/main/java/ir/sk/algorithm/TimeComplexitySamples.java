package ir.sk.algorithm;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.DynamicProgramming;
import ir.sk.helper.paradigm.DynamicProgrammingType;

/**
 * Important rules:
 * 1. large input
 * 2. worst case
 */
public class TimeComplexitySamples {

    @TimeComplexity("O(n + n/2 + n/4 + ... +1) = O(n)")
    public static void sample1(int n) {
        int count = 0;
        for (int i = n; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                count += 1;
            }
        }
    }

    @TimeComplexity("O(n + n-1 + n-2 + ... + 1)= O(n * (n+1)/2) + O(n^2/2) = O(n^2)")
    public static void sample2(int n) {
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                a = a + i + j;
            }
        }
    }

    /**
     * By test for example 14, 2
     * @param m
     * @param n
     * @return
     */
    @TimeComplexity("O(log n)")
    private static long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }

    /*
     * array is sorted
     * array.size() = N
     * The function is initially called as searchNumOccurrence(array, k, 0, N-1)
     * best case: 1,(2),3,4,5,6,4,7   =====> o(log n)
     * worse case: 2,2,2,2,2,2,2,2,2,2,2,2,2 ====> O(n)
     */
    @TimeComplexity("O(n)")
    int searchNumOccurrence(int[] array, int k, int start, int end) {
        if (start > end) return 0;
        int mid = (start + end) / 2;
        if (array[mid] < k) return searchNumOccurrence(array, k, mid + 1, end);
        if (array[mid] > k) return searchNumOccurrence(array, k, start, mid - 1);
        return searchNumOccurrence(array, k, start, mid - 1) + 1 + searchNumOccurrence(array, k, mid + 1, end);
    }

    @TimeComplexity("O(2^(r+c))")
    int findMinPath(int[][] array, int r, int c) {
        int R = array.length;
        int C = array[0].length;
        if (r >= R || c >= C) return 100000000; // Infinity
        if (r == R - 1 && c == C - 1) return 0;
        return array[r][c] + Math.min(findMinPath(array, r + 1, c), findMinPath(array, r, c + 1));
    }

    @TimeComplexity("O(r*c)")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    public static int findMinPathByDP(int[][] array, int r, int c, int[][] memo) {
        int R = array.length;
        int C = array[0].length;
        if (r >= R || c >= C) return 100000000; // Infinity
        if (r == R - 1 && c == C - 1) return 0;
        if (memo[r][c] != -1) return memo[r][c];
        memo[r][c] = array[r][c] + Math.min(findMinPathByDP(array, r + 1, c, memo), findMinPathByDP(array, r, c + 1, memo));
        return memo[r][c];
    }

}
