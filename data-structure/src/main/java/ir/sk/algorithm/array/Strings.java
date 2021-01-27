package ir.sk.algorithm.array;

import ir.sk.helper.*;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.pattern.SlidingWindowPattern;
import ir.sk.helper.pattern.SlidingWindowPatternType;
import ir.sk.helper.technique.BruteForce;


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

    /**
     * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
     * Input: str1="xy#z", str2="xzz#"
     * Output: true
     * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
     *
     * To compare the given strings, first, we need to apply the backspaces.
     * An efficient way to do this would be from the end of both the strings.
     * We can have separate pointers, pointing to the last element of the given strings.
     * We can start comparing the characters pointed out by both the pointers to see if the strings are equal.
     * If, at any stage, the character pointed out by any of the pointers is a backspace (’#’),
     * we will skip and apply the backspace until we have a valid character available for comparison.
     *
     * @param str1
     * @param str2
     * @return
     */
    @TimeComplexity("O(m+n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.MEDIUM)
    public static boolean compareStringsContainingBackspaces(String str1, String str2) {
        // use two pointer approach to compare the strings
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            if (i1 < 0 && i2 < 0) // reached the end of both the strings
                return true;

            if (i1 < 0 && i2 < 0) // reached the end of the strings
                return false;

            if (str1.charAt(i1) != str2.charAt(i2)) // check if the characters are equal
                return false;

            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') // found a backspace character
                backspaceCount++;
            else if (backspaceCount > 0) // a non-backspace character
                backspaceCount--;
            else
                break;

            index--; // skip a backspace or a valid character
        }
        return index;
    }

    /**
     * You are given two strings, A and B. Return whether A can be shifted some number of times to get B.
     * Eg. A = abcde, B = cdeab should return true because A can be shifted 3 times to the right to get B. A = abc and B= acb should return false.
     *
     * Time complexity of this problem depends on the implementation of strstr function.
     * If implementation of strstr is done using KMP matcher then complexity of the above program is (-)(n1 + n2) where n1 and n2 are lengths of strings.
     * KMP matcher takes (-)(n) time to find a substrng in a string of length n where length of substring is assumed to be smaller than the string.
     *
     * @param str1
     * @param str2
     * @return
     */
    @TimeComplexity("O(n)")
    public static boolean areRotation(String  str1, String str2) {
        String tmp = str1 + str1;
        return tmp.contains(str2);
    }
}
