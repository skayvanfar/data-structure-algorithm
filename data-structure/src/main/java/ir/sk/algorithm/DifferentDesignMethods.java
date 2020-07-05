package ir.sk.algorithm;

import java.util.Arrays;

/**
 * different Design Method: Twoloop, hash
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/5/2020.
 */
public class DifferentDesignMethods {

    /**
     * an algorithm for printing the first repeated character if there are duplicated elements in it.
     *
     * using two loops like BubbleSort, InsertionSort, SelectionSort, ...
     * Time Complexity (n^2)
     * Space Complexity (1)
     *
     * @param array
     * @return
     */
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
     * Time Complexity (n)
     * Space Complexity (256) = O(1)
     *
     * @param array
     * @return
     */
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
     * Time Complexity (n^2)
     * Space Complexity (1)
     * @param array
     * @return
     */
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
     * @param array
     * @return
     */
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

}
