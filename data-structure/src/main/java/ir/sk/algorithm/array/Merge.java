package ir.sk.algorithm.array;

import ir.sk.helper.BruteForce;
import ir.sk.helper.MultipleFinger;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Arrays;

/**
 * Created by sad.kayvanfar on 12/26/2020.
 */
public class Merge {

    public static int[] mergeByTwoFinger(int[] l, int[] r) {
        int a[] = new int[l.length + r.length];
        mergeByTwoFinger(a, l, r, l.length, r.length);
        return a;
    }

    /**
     * two-way merge - union - binary merge
     * two-way algorithm that helps us merge two sorted arrays together in one sorted array.
     *
     * @param a     returned array
     * @param l     first ordered array
     * @param r     second ordered array
     * @param left  last index of l array to compare
     * @param right last index of r array to compare
     */
    @MultipleFinger
    @TimeComplexity("O(n)")
    public static void mergeByTwoFinger(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        // compares the elements of both sub-arrays one by one and places the smaller element into the input array.
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        // When we reach the end of one of the sub-arrays,
        // the rest of the elements from the other array are copied into the input array
        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }

    }

    /**
     * Create a output array of size n * k.
     * Traverse the matrix from start to end and insert all the elements in output array.
     * Sort and print the output array.
     *
     * @param arrays
     * @return
     */
    @TimeComplexity("O(nk + nk * log nk)")
    @SpaceComplexity("nk  The output array is of size n*k")
    @BruteForce
    public static int[] kWayMargeNaive(int[]... arrays) {
        int size = Arrays.stream(arrays).map(ints -> ints.length).reduce((integer, integer2) -> integer + integer2).get();
        int[] result = new int[size];

        int k = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                result[k++] = arrays[i][j];
            }
        }

        Arrays.sort(result);
        return result;
    }

    /**
     * he process might begin with merging arrays into groups of two.
     * After the first merge, we have k/2 arrays. Again merge arrays in groups, now we have k/4 arrays.
     * This is similar to merge sort. Divide k arrays into two halves containing an equal number of arrays until there are two arrays in a group.
     *
     * @param start
     * @param end
     * @param arrays
     * @return
     */
    public static int[] kWayMargeRecursive(int start, int end, int[]... arrays) {
        if (start == end)
            return arrays[start];
        else {
            int size = (end - start) / 2;
            return mergeByTwoFinger(kWayMargeRecursive(0, size, arrays), kWayMargeRecursive(size + 1, end, arrays));
        }
    }
}
