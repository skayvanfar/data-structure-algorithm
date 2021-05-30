package ir.sk.algorithm.array.continuessubarray;

import ir.sk.helper.complexity.BCR;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;
import ir.sk.helper.pattern.SlidingWindowPattern;
import ir.sk.helper.pattern.SlidingWindowPatternType;
import ir.sk.helper.technique.BruteForce;
import ir.sk.helper.technique.CompleteSearch;

import javax.xml.ws.RespectBinding;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Length of the longest substring without repeating characters
 * <p>
 * Given a string str, find the length of the longest substring without repeating characters.
 * <p>
 * For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
 * For “BBBB” the longest substring is “B”, with length 1.
 * For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7
 * <p>
 * Created by sad.kayvanfar on 5/30/2021.
 */
@BCR(bigOTime = "O(n)")
public class LongestSubstringDistinct {

    /**
     * We can consider all substrings one by one and check for each substring whether it contains all unique characters or not.
     *
     * There will be n*(n+1)/2 substrings.
     * Number of substrings of length one is n (We can choose any of the n characters)
     * Number of substrings of length two is n-1 (We can choose any of the n-1 pairs formed by adjacent)
     * Number of substrings of length three is n-2
     * (We can choose any of the n-2 triplets formed by adjacent)
     * In general, mumber of substrings of length k is n-k+1 where 1 <= k <= n
     * Total number of substrings of all lengths from 1 to n =
     * n + (n-1) + (n-2) + (n-3) + … 2 + 1
     * = n * (n + 1)/2
     *
     * Whether a substring contains all unique characters or not can be checked in linear time by scanning it from left to right and keeping a map of visited characters.
     */
    @TimeComplexity("O(n ^ 3)")
    @BruteForce
    @CompleteSearch
    public static int longestSubstringDistinctNaive(String str) {
        int n = str.length();

        // Result
        int res = 0;
        // O(n)
        for (int i = 0; i < n; i++)
            // O(n)
            for (int j = i; j < n; j++)
                // O(n)
                if (areDistinct(str, i, j))
                    res = Math.max(res, j - i + 1);

        return res;
    }

    // This function returns true if all characters in
    // str[i..j] are distinct, otherwise returns false
    @TimeComplexity("O(n)")
    private static Boolean areDistinct(String str, int i, int j) {

        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];

        for (int k = i; k <= j; k++) {
            if (visited[str.charAt(k) - 'a'] == true)
                return false;

            visited[str.charAt(k) - 'a'] = true;
        }
        return true;
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

}
