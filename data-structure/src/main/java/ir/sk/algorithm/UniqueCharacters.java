package ir.sk.algorithm;

import ir.sk.helper.*;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Determine if a string has all Unique Characters
 * <p>
 * Created by sad.kayvanfar on 8/25/2020.
 */
public class UniqueCharacters {

    private final static int MAX_CHAR = 256;

    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static boolean uniqueCharactersBruteForce(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j])
                    return false;
            }

        }
        return true;
    }

    /**
     * using sorting technique
     *
     * @param chars
     * @return
     */
    @TimeComplexity("O(n Log n)")
    @SpaceComplexity("O(1)")
    public static boolean uniqueCharactersBySorting(char[] chars) {
        // Using sorting
        // Arrays.sort() uses binarySort in the background
        // for non-primitives which is of O(nlogn) time complexity
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chars[i] != chars[i + 1])
                continue;

                // if at any time, 2 adjacent elements
                // become equal, return false
            else
                return false;
        }
        return true;
    }

    /**
     * Unique Characters using hashtable data structure ( also can use frequency array(counting))
     *
     * @param chars
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(256)=O(1)")
    @FrequencyCountingPattern("Using boolean array")
    public static boolean uniqueCharactersByHashing(char[] chars) {
        // If length is greater than 256,
        // some characters must have been repeated
        if (chars.length > MAX_CHAR)
            return false;

        boolean[] hashTable = new boolean[MAX_CHAR];

        for (int i = 0; i < chars.length; i++) {
            int index = chars[i];

            /* If the value is already true, string
               has duplicate characters, return false */
            if (hashTable[index] == true)
                return false;

            hashTable[index] = true;
        }

        /* No duplicates encountered, return true */
        return true;
    }

    /**
     * reduce our space usage by a factor of eight by using a bit vector. We will assume, in the below code,
     * that the string only uses the lowercase letters a through z. This will allow us to use just a single int
     * <p>
     * Note that the solution is used for lower characters a-z, meaning that we are using it for finding duplicacy for 26 characters.
     * So, int taking 32 bits can be used here.
     * If the range had been bigger, then the solution will not work
     *
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @FrequencyCountingPattern("Using int")
    public static boolean uniqueCharactersByHashing2(String str) {
        int hashtable = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((hashtable & (1 << val)) > 0)
                return false;
            hashtable |= (1 << val);
        }
        return true;
    }

    /**
     * Using BitSet as bit vector
     *
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @FrequencyCountingPattern("Using BitSet")
    public static boolean uniqueCharactersByHashing3(String str) {
        BitSet hashtable = new BitSet(MAX_CHAR);
        for (int i = 0; i < str.length(); ++i) {
            int charVal = str.charAt(i);
            if (hashtable.get(charVal))
                return false;
            hashtable.set(charVal);
        }
        return true;
    }
}
