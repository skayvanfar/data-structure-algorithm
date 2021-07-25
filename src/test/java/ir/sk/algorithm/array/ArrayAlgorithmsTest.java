package ir.sk.algorithm.array;

import ir.sk.helper.Stopwatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loopExistsInCircularArray() {
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{1, 2, -1, 2, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 2, -1, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 1, -1, -2}));
    }

    @Test
    public void makeSquaresSortedArray() {
        System.out.println(Arrays.toString(ArrayAlgorithms.makeSquaresSortedArray(new int[]{-2, -1, 0, 2, 3})));
    }

    @Test
    public void magicIndexNaive() {
        System.out.println(ArrayAlgorithms.magicIndexNaive(new int[]{8, 9, 2, 3, 4}));
    }

    @Test
    public void magicIndexBinarySearch() {
        System.out.println(ArrayAlgorithms.magicIndexBinarySearch(new int[]{8, 9, 2, 3, 4}));
    }

    @Test
    public void checkPossibility() {
        int[] arr = {10, 5, 11, 3};

        if (ArrayAlgorithms.checkPossibility(arr))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    @Test
    public void findSingleNumber() {
        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        int n = ar.length;
        System.out.println("Element occurring once is " + ArrayAlgorithms.findSingleNumber(ar) + " ");
    }

    @Test
    public void witnesses() {
        int ar[] = {3, 6, 3, 4, 1};
        System.out.println(ArrayAlgorithms.witnesses(ar));
    }

    @Test
    public void pushZerosToEnd() {
        int ar[] = {0, 1, 0, 3, 12};
        ArrayAlgorithms.pushZerosToEnd(ar);
        System.out.println(Arrays.toString(ar));
    }

    @Test
    public void findKthLargestBySorting() {
        int ar[] = {3, 5, 2, 4, 6, 8};
        System.out.println(ArrayAlgorithms.findKthLargestBySorting(ar, 3));
    }

    @Test
    public void maxProductThreeNaive() {
        int arr[] = {-10, -3, 5, 6, -20};
        int n = arr.length;

        int max = ArrayAlgorithms.maxProductThreeNaive(arr, n);

        if (max == -1) {
            System.out.println("No Triplet Exists");
        } else {
            System.out.println("Maximum product is " + max);
        }
    }

    @Test
    public void maxProductThreeBySorting() {
        int arr[] = {-10, -3, 5, 6, -20};
        int n = arr.length;

        int max = ArrayAlgorithms.maxProductThreeBySorting(arr, n);

        if (max == -1) {
            System.out.println("No Triplet Exists");
        } else {
            System.out.println("Maximum product is " + max);
        }
    }
}