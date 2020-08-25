package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PermutationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printAllRecursive() {
        Integer[] arr = new Integer[]{1, 5, 2};
        Permutation.heapGenerateRecursive(arr, ',');
    }

    @Test
    public void printAllIterative() {
        Integer[] arr = new Integer[]{1, 5, 2};
        Permutation.heapGenerateIterative(arr.length, arr, ',');
    }

    @Test
    public void printRandom() {
        Integer[] arr = new Integer[]{1, 5, 2};
        Permutation.printRandom(arr, ',');
    }

    @Test
    public void printAllOrdered() {
        Integer[] arr = new Integer[]{1, 5, 2};
        Permutation.printAllOrdered(arr, ',');
    }

    @Test
    public void arePermutationUseSorting() {
        boolean expectedValue = true;
        Assert.assertEquals(expectedValue, Permutation.arePermutationUseSorting("abcdd".toCharArray(), "acdbd".toCharArray()));
    }

    @Test
    public void arePermutationByHashing() {
        boolean expectedValue = true;
        Assert.assertEquals(expectedValue, Permutation.arePermutationByHashing("abcdd".toCharArray(), "acdbd".toCharArray()));
    }
}