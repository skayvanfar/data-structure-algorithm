package ir.sk.algorithm.array;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.BruteForce;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute
 * how much water it is able to trap after raining
 */
public class DropWater {

    /**
     * As for this kind of problem, we should not consider from the whole, but from the part; Just as the previous articles that talk about how to handle the string problem, don't consider how to handle the whole string. Instead, you should focus on how to handle each character among the string.
     * Thus the height at position i is min(l_max, r_max)
     *
     * @param height
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    public static int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0, r_max = 0;
            // find the highest column on the right
            for (int j = i; j < n; j++)
                r_max = Math.max(r_max, height[j]);
            // find the highest column on the right
            for (int j = i; j >= 0; j--)
                l_max = Math.max(l_max, height[j]);
            // if the position i itself is the highest column
            // l_max == r_max == height[i]
            ans += Math.min(l_max, r_max) - height[i];
        }
        return ans;
    }

    /**
     * Actually, the memo optimization has not much difference from the above brute approach, except that it avoids repeat calculation and reduces the time complexity to O(N). Although time complexity O(N) is already the best, but the space complexity is still O(N).
     * @param height
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int trapByMemo(int[] height) {
        if (height.length == 0) return 0;
        int n = height.length;
        int ans = 0;
        // arrays act the memo
        int[] l_max = new int[n], r_max = new int[n];
        // initialize base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // calculate l_max from left to right
        for (int i = 1; i < n; i++)
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        // calculate r_max from right to left
        for (int i = n - 2; i >= 0; i--)
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        // calculate the final result
        for (int i = 1; i < n - 1; i++)
            ans += Math.min(l_max[i], r_max[i]) - height[i];
        return ans;
    }

    public static int trapByTwoPointer(int[] height) {
        if (height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;

        int l_max = height[0];
        int r_max = height[n - 1];

        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            // ans += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                ans += l_max - height[left];
                left++;
            } else {
                ans += r_max - height[right];
                right--;
            }
        }
        return ans;
    }
}
