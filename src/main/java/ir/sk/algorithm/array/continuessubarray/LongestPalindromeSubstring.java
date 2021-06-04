package ir.sk.algorithm.array.continuessubarray;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 6/2/2021.
 */
public class LongestPalindromeSubstring {

    /**
     * It looks at each character as the center of a palindrome and loops to determine the largest palindrome with that center.
     * // TODO: 6/4/21 Manchester algorithm is better
     *
     * @param chars
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
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
