package ir.sk.algorithm.array;

import ir.sk.algorithm.Search;
import ir.sk.helper.*;

import java.util.Arrays;

/**
 * Given two sorted arrays, find the number of elements in common.
 * <p>
 * Created by sad.keyvanfar on 8/24/2020.
 */
@BCR(bigOTime = "O(n)", bigOSpace = "O(1)")
public class IntersectionAndUnionOfTwoSortedArrays {

    /**
     * A brute force algorithm for this problem is to start with each element in A and search for it in B.
     * <p>
     * The arrays are the same length
     * and each has all distinct elements
     *
     * @param arr1
     * @param arr2
     * @return
     */
    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static int countOfCommonItems(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) { // O(n)
            for (int j = 0; j < arr2.length; j++) { // O(n)
                if (arr1[i] == arr2[j])
                    count++;
            }
        }
        return count;
    }

    /**
     * We can use binary search to find an element in a sorted array in 0( log N) time
     * <p>
     * The arrays are the same length
     * and each has all distinct elements
     *
     * @param arr1
     * @param arr2
     * @return
     */
    @TimeComplexity("O(n log n)")
    @SpaceComplexity("O(1)")
    public static int countOfCommonItemsBinary(int[] arr1, int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) { // O(n)
            if (Search.binarySearchByRecursive(arr2, arr1[i]) != -1) // O(log n)
                count++;
        }
        return count;
    }

    /**
     * we can just throw everything in B into a hash table
     * This will take O (N) time. Then, we just go
     * through A and look up each element in the hash table. This look up (or search) is 0(1), so our runtime is
     * O(N).
     * <p>
     * The arrays are the same length
     * and each has all distinct elements
     *
     * @param arr1
     * @param arr2
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @FrequencyCountingPattern
    public static int countOfCommonItemsByHashing(int[] arr1, int[] arr2) {
        int max = Arrays.stream(arr2).max().getAsInt();
        int min = Arrays.stream(arr2).min().getAsInt();

        int range = max - min + 1;
        boolean[] hashtable = new boolean[range];

        for (int i = 0; i < arr2.length; i++) {
            hashtable[arr2[i] - min] = true;
        }

        int count = 0;
        for (int i = 0; i < arr1.length; i++) { // O(n)
            boolean inBounds = (arr1[i] - min >= 0) && (arr1[i] - min < hashtable.length);
            if (inBounds && hashtable[arr1[i] - min]) // O(1)
                count++;
        }
        return count;
    }

    /**
     * @param arr1
     * @param arr2
     * @return
     */
    @TimeComplexity("O(n + m)")
    @SpaceComplexity("O(1)")
    @Best
    public static int countOfCommonItemsByTwoFinger(int[] arr1, int[] arr2) {
        int i = 0, j = 0, count = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
                j++;
                i++;
                count++;
            }
        }
        return count++;
    }

    /**
     * @param l
     * @param r
     * @return
     */
    public static int[] intersectByTwoFinger(int[] l, int[] r) {
        int[] intersection = new int[l.length];
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] < r[j])
                i++;
            else if (r[j] < l[i])
                j++;
            else {
                intersection[k++] = l[i];
                j++;
                i++;
            }
        }
        return intersection;
    }
}
