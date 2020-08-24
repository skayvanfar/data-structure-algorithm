package ir.sk.algorithm;

import ir.sk.helper.BCR;
import ir.sk.helper.BruteForce;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Arrays;

/**
 * Given two sorted arrays, find the number of elements in common. The arrays are the same length
 * and each has all distinct elements.
 * <p>
 * Created by sad.keyvanfar on 8/24/2020.
 */
@BCR(bigOTime = "O(n)", bigOSpace = "O(1)")
public class IntersectionOfTwoSortedArrays {

    /**
     * A brute force algorithm for this problem is to start with each element in A and search for it in B.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    @BruteForce
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
}
