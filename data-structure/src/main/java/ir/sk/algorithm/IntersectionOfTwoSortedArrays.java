package ir.sk.algorithm;

import ir.sk.helper.BCR;
import ir.sk.helper.BruteForce;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

/**
 * Given two sorted arrays, find the number of elements in common. The arrays are the same length
 * and each has all distinct elements.
 *
 * Created by sad.keyvanfar on 8/24/2020.
 */
@BCR(bigOTime = "n", bigOSpace = "1")
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
    public static int countOfCommonItems(int [] arr1, int [] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i]==arr2[2])
                    count++;
            }
        }
        return count;
    }
}
