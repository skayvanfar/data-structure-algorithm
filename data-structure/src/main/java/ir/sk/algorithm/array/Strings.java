package ir.sk.algorithm.array;

import ir.sk.helper.FrequencyCountingPattern;
import ir.sk.helper.SlidingWindowPattern;
import ir.sk.helper.SlidingWindowPatternType;
import ir.sk.helper.TimeComplexity;

/**
 * Created by sad.kayvanfar on 10/31/2020.
 */
public class Strings {

    /**
     * Given a string str and a string pat, find the minimum window in S which will contain all the characters in pat.
     * <p>
     * Note:If there is no such window in S that covers all characters in T, return the empty string “”.
     *
     * @param str
     * @param pat
     * @return
     */
    @TimeComplexity("O(n)")
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    @FrequencyCountingPattern
    public static String minWindow(String str, String pat) {
        if (str == null || pat == null) return "";
        int[] counting = new int[128];
        for (Character c : pat.toCharArray()) {
            counting[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = pat.length();
        char[] arr = str.toCharArray();
        while (end < arr.length) {
            if (counting[arr[end]] > 0) counter--;
            counting[arr[end]]--;
            end++;
            while (counter == 0) {
                if ((end - start) < minLen) {
                    minLen = end - start;
                    minStart = start;
                }
                counting[arr[start]]++;
                if (counting[arr[start]] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : str.substring(minStart, minStart + minLen);
    }

    /**
     * inserting the frequency of each unique character after it and also eliminating all repeated characters.
     *
     * @param chars
     */
    public static String countContinuosOccurenceEachChar(char[] chars) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            result.append(chars[i]).append(count);
        }
        return result.toString();
    }
}
