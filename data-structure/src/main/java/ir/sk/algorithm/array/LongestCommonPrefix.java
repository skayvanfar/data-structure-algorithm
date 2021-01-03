package ir.sk.algorithm.array;

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

        /* find the minimum length from first and last string */
        int end = Math.min(stringArrays[0].length(), stringArrays[size-1].length());

        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && stringArrays[0].charAt(i) == stringArrays[size-1].charAt(i) )
            i++;

        return stringArrays[0].substring(0, i);
    }
}
