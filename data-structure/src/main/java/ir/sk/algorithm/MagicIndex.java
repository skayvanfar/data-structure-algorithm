package ir.sk.algorithm;

import ir.sk.helper.BinarySearch;
import ir.sk.helper.BruteForce;
import ir.sk.helper.TimeComplexity;

/**
 * A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
 * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
 * array A.
 * <p>
 * Created by sad.kayvanfar on 9/22/2020.
 */
public class MagicIndex {

    /**
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @BruteForce
    public static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i)
                return i;
        }
        return -1;
    }

    /**
     * @param array
     * @return
     */
    @TimeComplexity("O(Log n)")
    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    @BinarySearch
    private static int magicFast(int[] array, int start, int end) {
        if (end < start)
            return -1;

        int mid = (start + end) / 2;
        if (array[mid] == mid)
            return mid;
        else if (array[mid] > mid)
            return magicFast(array, start, mid - 1);
        else
            return magicFast(array, mid + 1, end);
    }
}
