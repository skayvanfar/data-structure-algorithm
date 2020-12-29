package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    public void heapPermutationIterative() {
        Integer[] arr = new Integer[]{1, 2, 3};
        Permutation.heapPermutationIterative(arr.length, arr, ',');
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

    @Test
    public void palindromePermutationByHashing() {
        boolean expectedValue = true;
        Assert.assertEquals(expectedValue, Permutation.palindromePermutationByHashing("tactcoa".toCharArray()));

    }

    @Test
    public void permutation() {
        Permutation.permutation("ali");
    }

    @Test
    public void permutationUnknown() {
        Permutation.permutationNew("abcd").stream().forEach(System.out::println);
    }

    @Test
    public void permutation2() {
        Permutation.permutation2("abc").stream().forEach(System.out::println);
    }

    @Test
    public void heapPermutationRecursive() {
        int[] arr = new int[]{1, 2, 3};
        Permutation.heapPermutationRecursive(arr, 3);
    }
}