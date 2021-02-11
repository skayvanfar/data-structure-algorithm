package ir.sk.algorithm.array;

import ir.sk.algorithm.array.IntersectionAndUnionOfTwoSortedArrays;
import ir.sk.algorithm.array.Merge;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sad.keyvanfar on 8/24/2020.
 */
public class IntersectionAndUnionOfTwoSortedArraysTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void countOfCommonItems() {
        int[] arr1 = new int[]{1, 2, 4, 9};
        int[] arr2 = new int[]{2, 4, 5, 7};

        Assert.assertEquals(2, IntersectionAndUnionOfTwoSortedArrays.countOfCommonItems(arr1, arr2));
    }

    @Test
    public void countOfCommonItemsBinary() {
        int[] arr1 = new int[]{1, 2, 4, 9};
        int[] arr2 = new int[]{2, 4, 5, 7};

        Assert.assertEquals(2, IntersectionAndUnionOfTwoSortedArrays.countOfCommonItemsBinary(arr1, arr2));
    }

    @Test
    public void countOfCommonItemsByHashing() {
        int[] arr1 = new int[]{-1, 2, 4, 9};
        int[] arr2 = new int[]{-1, 2, 4, 5};

        Assert.assertEquals(3, IntersectionAndUnionOfTwoSortedArrays.countOfCommonItemsByHashing(arr1, arr2));
    }

    @Test
    public void countOfCommonItemsByTwoFinger() {
        int[] arr1 = new int[]{-1, 2, 4, 9};
        int[] arr2 = new int[]{-1, 2, 4, 5};

        Assert.assertEquals(3, IntersectionAndUnionOfTwoSortedArrays.countOfCommonItemsByTwoFinger(arr1, arr2));
    }

    @Test
    public void mergeByTwoFinger() {

        int[] foo = {3, 7};
        int[] bar = {4, 8, 11};
        int[] merged = {3, 4, 7, 8, 11};

        assertArrayEquals(merged, Merge.mergeByTwoFinger(foo, bar));
    }

    @Test
    public void intersectByTwoFinger() {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        int[] intersect = {2, 5};

        IntersectionAndUnionOfTwoSortedArrays.intersectByTwoFinger(arr1, arr2);
    }
}