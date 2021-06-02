package ir.sk.algorithm.array.continuessubarray;

import ir.sk.algorithm.array.Palindrome;

/**
 * Created by sad.kayvanfar on 6/2/2021.
 */
public class LongestPalindromeSubstring {

    /**
     * @param chars
     * @return
     */
    public static int longestPalindromeSubstring(char[] chars) {
        int max = 1;
        for (int i = 0; i < chars.length; i++) {
            int k = i - 1;
            int j;
            int counter;
            if (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                j = i + 2;
                counter = 2;
            } else {
                j = i + 1;
                counter = 1;
            }
            while (k > 0 && j < chars.length && chars[k] == chars[j]) {
                counter += 2;
                k--;
                j++;
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}
