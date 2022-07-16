package ir.sk.algorithm.array;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Stack;

/**
 * Given a string str, the task is to find whether the string is a palindrome or not
 *
 * Created by sad.kayvanfar on 6/2/2021.
 */
public class Palindrome {

    /**
     * Take two pointers i pointing to the start of the string and j pointing to the end of the string.
     * Keep incrementing i and decrementing j while i < j and at every step check whether the characters at these pointers are same or not.
     * If not then the string is not a palindrome else it is.
     *
     * @param chars
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static boolean isPalindromeByTwoPointer(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1])
                return false;
        }
        return true;
    }

    public static boolean isPalindromeByStack(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length / 2; i++) {
            stack.push(chars[i]);
        }
        int i;
        if (chars.length % 2 == 0)
            i = chars.length / 2;
        else
            i = (chars.length / 2) + 1;

        for (; i < chars.length; i++) {
            if (chars[i] != stack.pop())
                return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(char[] chars) {
        return isPalindromeRecursive(chars, 0);
    }

    public static boolean isPalindromeRecursive(char[] chars, int i) {
        int j = chars.length - 1 - i;
        return i >= j ? true : chars[i] == chars[j] && isPalindromeRecursive(chars, i + 1);

    }


}
