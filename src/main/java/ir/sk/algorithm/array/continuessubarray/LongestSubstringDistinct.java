package ir.sk.algorithm.array.continuessubarray;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;
import ir.sk.helper.pattern.SlidingWindowPattern;
import ir.sk.helper.pattern.SlidingWindowPatternType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Length of the longest substring without repeating characters
 *
 * Given a string str, find the length of the longest substring without repeating characters.
 *
 * For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
 * For “BBBB” the longest substring is “B”, with length 1.
 * For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7
 *
 * Created by sad.kayvanfar on 5/30/2021.
 */
public class LongestSubstringDistinct {

    /**
     * Given a string, find the length of the longest substring in it with no more than d distinct characters.
     *
     * @param chars string
     * @param d     distinct characters
     * @return
     */
    @TimeComplexity("O(n+n) = O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @HashingIndexPattern
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
    @HashingIndexPattern
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
    @HashingIndexPattern
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
    @HashingIndexPattern
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
    @HashingIndexPattern
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
}
