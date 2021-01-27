package ir.sk.algorithm;

import ir.sk.helper.*;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.pattern.SlidingWindowPattern;
import ir.sk.helper.pattern.SlidingWindowPatternType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * different Design Method: Twoloop, hash
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/5/2020.
 */
public class DifferentDesignMethods {

    /**
     * an algorithm for printing the first repeated character if there are duplicated elements in it.
     * <p>
     * using two loops like BubbleSort, InsertionSort, SelectionSort, ...
     *
     * @param array
     * @return
     */
    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static char firstRepeatedCharByTwoLoops(char[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j])
                    return array[i];
            }
        }
        return '\u0000';
    }

    /**
     * using hash like CountSort, Hashtable,  ...
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    public static char firstRepeatedCharByHash(char[] array) {
        int[] counter = new int[256];

        for (int i = 0; i < array.length; i++) {
            // using the value as key (array[i]) if the value can't be used as key we should use a hash function
            if (counter[array[i]] == 1) {
                return array[i];
            } else
                counter[array[i]]++;
        }

        return '\u0000';
    }

    /**
     * an algorithm for printing the max repeated character.
     *
     * @param array
     * @return
     */
    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static char maximumRepeatedCharByTwoLoops(char[] array) {
        char maxChar = '\u0000';
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int charCount = 0;
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j])
                    charCount++;
            }
            if (charCount > count) {
                maxChar = array[i];
                count = charCount;
            }
        }
        return maxChar;
    }

    /**
     * Time Complexity (n)
     * Space Complexity (256) = O(1)
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @FrequencyCountingPattern
    public static char maximumRepeatedCharByHash(char[] array) {
        int[] counter = new int[256];

        char maxChar = '\u0000';
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            // using the value as key (array[i]) if the value can't be used as key we should use a hash function
            counter[array[i]]++;
            if (counter[array[i]] > count) {
                maxChar = array[i];
                count = counter[array[i]];
            }
        }

        return maxChar;
    }

    /**
     * find the length of the longest substring
     * without repeating characters
     *
     * @param input
     * @return
     */
    @TimeComplexity("O(n^2)")
    public String getUniqueCharacterSubstringBruteForce(String input) {
        String output = "";
        for (int start = 0; start < input.length(); start++) {
            Set<Character> visited = new HashSet<>();
            int end = start;
            for (; end < input.length(); end++) {
                char currChar = input.charAt(end);
                if (visited.contains(currChar)) {
                    break;
                } else {
                    visited.add(currChar);
                }
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end);
            }
        }
        return output;
    }

    /**
     * @param input
     * @return
     */
    @SlidingWindowPattern(type = SlidingWindowPatternType.DYNAMICALLY_RESIZABLE)
    @TimeComplexity("O(n)")
    String getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

}
