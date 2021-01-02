package ir.sk.algorithm.array;

import ir.sk.helper.*;

import java.util.ArrayList;
import java.util.List;


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

    /**
     * The longest common substring problem is to find the longest string that is a substring of two or more strings.
     *
     * @param str1
     * @param str2
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n * m^2)")
    public static int longestCommonSubStringNaive(String str1, String str2) {
        int max = 0;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    int count = 1;
                    String str = chars1[i] + "";
                    for (int k = i + 1, z = j + 1; k < chars1.length && z < chars2.length; k++, z++) {
                        if (chars1[k] == chars2[z]) {
                            count++;
                            str += chars1[k];
                        } else
                            break;
                    }
                    if (count > max) {
                        max = count;
                        System.out.println(str);
                    }
                }
            }
        }
        return max;
    }

}
