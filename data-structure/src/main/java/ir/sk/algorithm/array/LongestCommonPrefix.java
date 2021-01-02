package ir.sk.algorithm.array;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/3/2021.
 */
public class LongestCommonPrefix {

    /**
     * @param stringArray
     * @return
     */
    @TimeComplexity("O(n*m), N = Number of strings, M = Length of longest string")
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
}
