package ir.sk.algorithm.array;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.pattern.SlidingWindowPattern;
import ir.sk.helper.pattern.SlidingWindowPatternType;
import ir.sk.helper.technique.BruteForce;

import java.util.*;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class ContinuesSubArray {

    /*************
     * to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
     *************/

    /**
     * we'll find all subarrays starting at every index from 0 to n-1
     *
     * @param nums
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    @MultipleLoopsPattern
    public static int maxSubArraySumBruteForce(int[] nums) {

        int n = nums.length;
        int maximumSubArraySum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < n; left++) {

            int runningWindowSum = 0;

            for (int right = left; right < n; right++) {
                runningWindowSum += nums[right];

                if (runningWindowSum > maximumSubArraySum) {
                    maximumSubArraySum = runningWindowSum;
                    start = left;
                    end = right;
                }
            }
        }
        System.out.printf("Found Maximum Subarray between %d and %d", start, end);
        return maximumSubArraySum;
    }

    /**
     * Kadane's algorithm is a popular solution to the maximum subarray problem and this solution is based on dynamic programming
     * <p>
     * The most important challenge in solving a dynamic programming problem is to find the optimal subproblems
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n)")
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static int maxSubArraySumKadanes(int[] arr) {

        int size = arr.length;
        int start = 0;
        int end = 0;

        int maxSoFar = 0, maxEndingHere = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                start = i;
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                end = i;
            }
        }

        System.out.printf("Found Maximum Subarray between %d and %d", start, end);
        return maxSoFar;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given an array of integers and a number k, find maximum sum of a subarray of size k.
     *
     * @param array
     * @param k
     */
    @TimeComplexity("O(n * k)")
    @SpaceComplexity("O(1)")
    @BruteForce
    public static void findMaxSumSubArrayNaive(int[] array, int k) {
        int maxSoFar = 0, currentSum;
        for (int i = 0; i <= array.length - k; i++) {
            currentSum = 0;
            for (int j = 0; j < i + k; j++) {
                currentSum += array[j];
            }
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
    }

    /**
     * Given an array of integers and a number k, find maximum sum of a subarray of size k.
     *
     * @param array
     * @param k     size
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @SlidingWindowPattern(type = SlidingWindowPatternType.STATICALLY_RESIZABLE)
    public static int findMaxSumSubArray(int[] array, int k) {
        int start = 0, end = k;
        int sumSoFar, currentSum = 0;
        for (int i = 0; i < k; i++)
            currentSum += array[i];

        sumSoFar = currentSum;

        while (end < array.length) {
            currentSum += array[end++];
            currentSum -= array[start++];
            sumSoFar = Math.max(sumSoFar, currentSum);
        }
        return sumSoFar;
    }

    /*  Given an unsorted array of non negative integers, find a continuous subarray which adds to a given number. */

    /**
     * A simple solution is to consider all subarrays one by one and check the sum of every subarray.
     * Run two loops: the outer loop picks a starting point I and the inner loop tries all subarrays starting from i
     *
     * @param arr
     * @param target
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @BruteForce
    @MultipleLoopsPattern
    public static void subArraySumNaive(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == target)
                    System.out.println("starting index : " + i + ", " + "Ending index : " + j);
            }
        }
    }

    // TODO: 10/27/2020 SlidingWindowPattern of subArraySum

    /**
     * Smallest subarray with sum greater than a given value
     *
     * @param arr
     * @param targetSum
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    @Point("Two loops, but O(n)")
    public static int sizeOfSmallestSubArray(int arr[], int targetSum) {
        int start = 0, end = 0;
        int minWindowSizeSoFar = Integer.MAX_VALUE, currentWindowSum = 0;

        while (end < arr.length) {
            currentWindowSum += arr[end];
            while (currentWindowSum >= targetSum) {
                minWindowSizeSoFar = Math.min(minWindowSizeSoFar, end - start + 1);
                currentWindowSum -= arr[start];
                start++;
            }
            end++;
        }
        return minWindowSizeSoFar;
    }

    /////////////////////////////////////////////////////////////////////////////////////


    /**
     * Given a string, find the length of the longest substring in it with no more than d distinct characters.
     *
     * @param chars string
     * @param d     distinct characters
     * @return
     */
    @TimeComplexity("O(n+n) = O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static int longestSubstringDistinct(char[] chars, int d) {
        int start = 0, end = 0;
        int lengthSoFar = 0, currentCount = 0;
        boolean[] hashtable = new boolean[256];

        // extend the slide window
        while (end < chars.length) {
            // main operation
            if (!hashtable[chars[end]]) {
                currentCount++;
                hashtable[chars[end]] = true;
            }
            // compare
            if (currentCount == d)
                lengthSoFar = Math.max(lengthSoFar, end - start + 1);
            // shrink the slide window
            while (currentCount > d) {
                if (hashtable[chars[start]]) {
                    currentCount--;
                    hashtable[chars[start]] = false;
                }
                start++;
            }
            end++;
        }
        return lengthSoFar;
    }


    /**
     * Given a string, find the length of the Longest Substring with at most d distinct characters
     *
     * @param chars
     * @param d
     * @return
     */
    @TimeComplexity("O(n+n) = O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static int longestSubstringAtMostDistinct(char[] chars, int d) {
        int start = 0, end = 0;
        int lengthSoFar = 0, currentCount = 0;
        boolean[] hashtable = new boolean[256];

        // extend the slide window
        while (end < chars.length) {
            // main operation
            if (!hashtable[chars[end]]) {
                currentCount++;
                hashtable[chars[end]] = true;
            }
            // compare
            if (currentCount <= d)
                lengthSoFar = Math.max(lengthSoFar, end - start + 1);
            // shrink the slide window
            while (currentCount > d) {
                if (hashtable[chars[start]]) {
                    currentCount--;
                    hashtable[chars[start]] = false;
                }
                start++;
            }
            end++;
        }
        return lengthSoFar;
    }


    /**
     * Given a string, find the length of the longest substring which has no repeating characters.
     *
     * @param chars
     * @return
     */
    @TimeComplexity("(O(n+n) = O(n))")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static int longestSubstringAllDistinct(char[] chars) {
        int start = 0, end = 0;
        int lengthSoFar = Integer.MIN_VALUE;
        Set<Character> hashtable = new HashSet<>();

        while (end < chars.length) {

            // shrink the slide window
            while (hashtable.contains(chars[end])) {
                hashtable.remove(chars[start]);
                start++;
            }

            hashtable.add(chars[end]);
            lengthSoFar = Math.max(lengthSoFar, end - start + 1);

            end++;
        }
        return lengthSoFar;
    }

    /**
     * Given a string, find the length of the longest substring which has no repeating characters.
     *
     * @param s
     * @return
     */
    @TimeComplexity("(O(n+n) = O(n))")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static int longestSubstringAllDistinct2(char[] s) {
        int left = 0, right = 0;
        int[] window = new int[256];
        int res = 0; // Record maximum length

        while (right < s.length) {
            window[s[right]]++;

            // If a duplicate character appears in the window
            // Move the left pointer
            while (window[s[right]] > 1) {
                window[s[left]]--;
                left++;
            }
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * Given a string, find the length of the longest substring which has no repeating characters.
     *
     * @param chars
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static int longestSubstringAllDistinct3(char[] chars) {
        int start = 0, end = 0;
        int lengthSoFar = Integer.MIN_VALUE;
        // We can use a HashMap to remember the last index of each character we have processed.
        Map<Character, Integer> charIndexMap = new HashMap<>();

        while (end < chars.length) {

            // shrink the slide window
            if (charIndexMap.containsKey(chars[end])) {
                start = Math.max(start, charIndexMap.get(chars[end]) + 1);
            }

            charIndexMap.put(chars[end], end);

            lengthSoFar = Math.max(lengthSoFar, end - start + 1);
            end++;

        }
        return lengthSoFar;
    }


    /**
     * the minimum substring from the string S (Source) which has all the characters of the string T (Target).
     * // TODO: 1/7/2021 need more attention
     *
     * @param source
     * @param target
     * @return
     */
    @TimeComplexity("O(s + t), s and t represent the lengths of strings S and T")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static String minimumWindowSubstring(char[] source, char[] target) {
        int start = 0, end = 0;
        int minLengthSoFar = Integer.MAX_VALUE;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // Maintain a counter to check whether match the target string.
        int match = 0;

        int index = 0;

        for (char ch : target)
            need.put(ch, need.getOrDefault(ch, 0) + 1);

        while (end < source.length) {
            if (need.containsKey(source[end])) {
                window.put(source[end], window.getOrDefault(source[end], 0) + 1);
                if (window.get(source[end]) == need.get(source[end]))
                    match++;
            }
            end++;

            while (match == need.size()) {
                if (end - start + 1 < minLengthSoFar) {
                    // Updates the position and length of the smallest string
                    index = start;
                    minLengthSoFar = end - start + 1;
                }

                if (need.containsKey(source[start])) {
                    window.put(source[start], window.getOrDefault(source[start], 0) - 1);

                    if (window.get(source[start]) < need.get(source[start]))
                        match--;
                }
                start++;
            }
        }
        return minLengthSoFar == Integer.MAX_VALUE ? "" : String.valueOf(source).substring(index, minLengthSoFar + 1);
    }

    /**
     * Given a String s and a non-empty string p, find all the start indices of p's anagrams in s.
     * <p>
     * // TODO: 1/7/2021 need more attention
     *
     * @param source
     * @param target
     * @return
     */
    @TimeComplexity("O(s + t), s and t represent the lengths of strings S and T")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    public static List<Integer> findAllAnagramsString(char[] source, char[] target) {
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // Maintain a counter to check whether match the target string.
        int match = 0;

        for (char ch : target)
            need.put(ch, need.getOrDefault(ch, 0) + 1);

        while (end < source.length) {
            if (need.containsKey(source[end])) {
                window.put(source[end], window.getOrDefault(source[end], 0) + 1);
                if (window.get(source[end]) == need.get(source[end]))
                    match++;
            }
            end++;

            while (match == need.size()) {
                if (end - start == target.length) {
                    result.add(start);
                }

                if (need.containsKey(source[start])) {
                    window.put(source[start], window.getOrDefault(source[start], 0) - 1);
                    if (window.get(source[start]) < need.get(source[start]))
                        match--;
                }
                start++;
            }
        }
        return result;
    }
}
