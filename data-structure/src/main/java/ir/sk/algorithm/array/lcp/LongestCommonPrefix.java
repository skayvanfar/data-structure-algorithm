package ir.sk.algorithm.array.lcp;

import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.DivideAndConquer;

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
    public static StringBuffer findLongestCommonPrefixCharByChar(String[] stringArray) {
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

        return findCommonPrefixTwoString(stringArrays[0], stringArrays[stringArrays.length - 1]);
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
            return findCommonPrefixTwoString(first, last);
        }
    }

    /**
     * The longest common prefix of two words
     *
     * @param first
     * @param second
     * @return
     */
    @TimeComplexity("O(n)")
    public static String findCommonPrefixTwoString(String first, String second) {
        int i;
        for (i = 0; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                break;
        }
        return first.substring(0, i);
    }

    /**
     * A Function that returns the longest common prefix from the array of strings
     *
     * @param arr
     * @return
     */
    @RecurrenceRelation("T(m) = T(m/2) + O(mn), n Number of strings, m = Length of longest string")
    @SpaceComplexity("O(nm log m)")
    public static String findLongestCommonPrefixByBinarySearch(String arr[]) {
        int index = findMinLength(arr);
        String prefix = ""; // Our resultant string

        // We will do an in-place binary search on the
        // first string of the array in the range 0 to
        // index
        int low = 0, high = index - 1;
        while (low <= high) {

            // Same as (low + high)/2, but avoids
            // overflow for large low and high
            int mid = low + (high - low) / 2;

            if (allContainsPrefix(arr, arr.length, arr[0], low, mid)) {
                // If all the strings in the input array
                // contains this prefix then append this
                // substring to our answer
                prefix = prefix + arr[0].substring(low, mid + 1);

                // And then go for the right part
                low = mid + 1;
            } else { // Go for the left part
                high = mid - 1;
            }
        }

        return prefix;
    }

    /**
     * A Function to find the string having the minimum length and returns that length
     *
     * @param arr
     * @return
     */
    public static int findMinLength(String arr[]) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length() < min)
                min = arr[i].length();

        return min;
    }

    public static boolean allContainsPrefix(String arr[], int n, String str, int start, int end) {
        for (int i = 0; i <= (n - 1); i++) {
            String arr_i = arr[i];

            for (int j = start; j <= end; j++)
                if (arr_i.charAt(j) != str.charAt(j))
                    return false;
        }
        return true;
    }

    /**
     * LCP(s1, s2, s3) = LCP(LCP(s1, s2), s3)
     *
     * @param list
     * @return
     */
    @TimeComplexity("O(nm), n Number of strings, m = Length of longest string")
    @SpaceComplexity("O(1)")
    public static String findLongestCommonPrefixByWordByWord(String[] list) {
        // Initialize longest common prefix as first word of list
        String lcp = list[0];

        // Traverse the list from index 1 (0 based indexing)
        for (int i = 1; i < list.length; i++) {
            // Update lcp as prefix of lcp and current word
            lcp = findCommonPrefixTwoString(list[i], lcp);
        }

        // return lcp
        return lcp;
    }
}
