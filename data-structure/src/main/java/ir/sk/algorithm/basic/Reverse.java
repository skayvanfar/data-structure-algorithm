package ir.sk.algorithm.basic;

import ir.sk.helper.InPlace;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Stack;

/**
 * Created by sad.kayvanfar on 9/16/2020.
 */
public class Reverse {
    /**
     * reverse by using another array
     * @param a
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int[] reverse(int a[]) {
        int[] b = new int[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j--;
        }
        return b;
    }

    /**
     * This algorithm iterate over an array and swap elements until you reach the midpoint.
     * This is also known as reversing an array in-place because no additional buffer is used.
     *
     * @param array
     */
    @TimeComplexity("O(n/2)=O(n)")
    @SpaceComplexity("O(1)")
    @InPlace
    public static void inPlaceReverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    public static String recursiveReverse(String str) {
        if (str.length() == 1)
            return str;
        else
            return str.charAt(str.length() - 1) + recursiveReverse(str.substring(0, str.length() - 1));

    }

    /**
     * @param array
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void reverseByStack(int[] array) {
        Stack<Integer> stack = new Stack<>();

        for (int a : array)
            stack.push(a);

        for (int i = 0; i < array.length; i++)
            array[i] = stack.pop();
    }
}
