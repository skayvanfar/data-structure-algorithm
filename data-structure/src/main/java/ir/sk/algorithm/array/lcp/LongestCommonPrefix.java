package ir.sk.algorithm.array.lcp;

import ir.sk.helper.DivideAndConquer;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/3/2021.
 */
public class LongestCommonPrefix {

    /**
     * @param stringArray
     * @return
     */
    @TimeComplexity("O(n*m), n = Number of strings, m = Length of longest string")
    @SpaceComplexity("O(m)")
    public static StringBuffer longestCommonPrefixCharByChar(String[] stringArray) {
        int minLen = findMinLength(stringArray);
        StringBuffer result = new StringBuffer();
        char currChar;
        for (int i = 0; i < minLen; i++) {

            currChar = stringArray[0].charAt(i);
            for (int j = 1; j < stringArray.length; j++)
                if (stringArray[j].charAt(i) != currChar)
                    return result;

            result.append(currChar);
        }
        return result;
    }

    private static int findMinLength(String[] string_array) {
        int min = string_array[0].length();
        for (int i = 1; i < string_array.length; i++)
            if (string_array[i].length() < min)
                min = string_array[i].length();
        return (min);
    }

    /**
     * The idea is to sort the array of strings and find the common prefix of the first and last string of the sorted array.
     *
     * @param stringArrays
     * @return
     */
    @TimeComplexity("O(m*n*logn), n Number of strings, m = Length of longest string")
    @SpaceComplexity("O(n)")
    public static String findLongestCommonPrefixBySorting(String[] stringArrays) {
        int size = stringArrays.length;

        /* if size is 0, return empty string */
        if (size == 0)
            return "";

        if (size == 1)
            return stringArrays[0];

        /* sort the array of strings O(m*n*logn) */
        Arrays.sort(stringArrays);

        return findCommonPrefix(stringArrays[0], stringArrays[stringArrays.length - 1]);
    }

    /**
     * We first divide the arrays of string into two parts.
     * Then we do the same for left part and after that for the right part.
     * We will do it until and unless all the strings become of length 1. Now after that,
     * we will start conquering by returning the common prefix of the left and the right strings.
     *
     * @param stringArrays
     * @param start
     * @param end
     * @return
     */
    @TimeComplexity("O(m Log n), n Number of strings, m = Length of longest string")
    @DivideAndConquer
    public static String findLongestCommonPrefixByDivideAndConquer(String[] stringArrays, int start, int end) {
        if (start == end)
            return stringArrays[start];
        else {
            int middle = (start + end) / 2;
            String first = findLongestCommonPrefixByDivideAndConquer(stringArrays, start, middle);
            String last = findLongestCommonPrefixByDivideAndConquer(stringArrays, middle + 1, end);
            return findCommonPrefix(first, last);
        }
    }

    /**
     * @param first
     * @param second
     * @return
     */
    @TimeComplexity("O(n)")
    public static String findCommonPrefix(String first, String second) {
        int i;
        for (i = 0; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                break;
        }
        return first.substring(0, i);
    }
}
