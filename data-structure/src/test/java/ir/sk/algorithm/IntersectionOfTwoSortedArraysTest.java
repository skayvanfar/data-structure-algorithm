package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 8/24/2020.
 */
public class IntersectionOfTwoSortedArraysTest {

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

        Assert.assertEquals(2, IntersectionOfTwoSortedArrays.countOfCommonItems(arr1, arr2));
    }

    @Test
    public void countOfCommonItemsBinary() {
        int[] arr1 = new int[]{1, 2, 4, 9};
        int[] arr2 = new int[]{2, 4, 5, 7};

        Assert.assertEquals(2, IntersectionOfTwoSortedArrays.countOfCommonItemsBinary(arr1, arr2));
    }

    @Test
    public void countOfCommonItemsByHashing() {
        int[] arr1 = new int[]{-1, 2, 4, 9};
        int[] arr2 = new int[]{-1, 2, 4, 5};

        Assert.assertEquals(3, IntersectionOfTwoSortedArrays.countOfCommonItemsByHashing(arr1, arr2));
    }

    @Test
    public void twoFingerAlgorithm() {

        int[] foo = { 3, 7 };
        int[] bar = { 4, 8, 11 };
        int[] merged = { 3, 4, 7, 8, 11 };

        assertArrayEquals(merged, IntersectionOfTwoSortedArrays.twoFingerAlgorithm(foo, bar));
    }
}