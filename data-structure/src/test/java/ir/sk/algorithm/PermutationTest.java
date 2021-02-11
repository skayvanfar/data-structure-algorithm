package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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
    public void printRandom() {
        Integer[] arr = new Integer[]{1, 5, 2};
        Permutation.printRandom(arr, ',');
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
    public void permutationNew() {
        Permutation.permutationNew("abc").stream().forEach(System.out::println);
    }


    @Test
    public void heapPermutationRecursive() {
        int[] arr = new int[]{1, 2, 3};
        Permutation.heapPermutationRecursive(arr, 3);
    }

    @Test
    public void findPermutationsInsertInEachPosition() {
        List<List<Integer>> result = Permutation.findPermutationsInsertInEachPosition(new int[]{1, 3, 5});
        System.out.println("here are all the permutations: " + result);
    }

    @Test
    public void findPermutationsInsertInEachPositionRecursive() {
        List<List<Integer>> result = Permutation.findPermutationsInsertInEachPositionRecursive(new int[]{1, 3, 5});
        System.out.println("here are all the permutations: " + result);
    }
}