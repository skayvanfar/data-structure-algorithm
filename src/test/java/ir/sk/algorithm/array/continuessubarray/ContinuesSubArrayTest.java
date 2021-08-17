package ir.sk.algorithm.array.continuessubarray;

import ir.sk.algorithm.array.continuessubarray.ContinuesSubArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class ContinuesSubArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findMaxSumSubArrayNaive() {
    }

    @Test
    public void maxSubArraySumBruteForce() {
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        ContinuesSubArray.maxSubArraySumBruteForce(arr);
    }

    @Test
    public void maxSubArraySumKadanes() {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(ContinuesSubArray.maxSubArraySumKadanes(arr));
    }

    @Test
    public void subArraySumNaive() {
        int[] arr = new int[]{1, 5, 2, 8, 9, 7};
        Assert.assertEquals(1, ContinuesSubArray.sizeOfSmallestSubArray(arr, 8));
    }

    @Test
    public void sizeOfSmallestSubArray() {
        int[] arr = new int[]{1, 5, 2, 8, 9, 7};
        Assert.assertEquals(1, ContinuesSubArray.sizeOfSmallestSubArray(arr, 8));
    }

    @Test
    public void findMaxSumSubArray() {
        int arr[] = new int[]{4, 2, 3, 7, 5, 1};
        Assert.assertEquals(15, ContinuesSubArray.findMaxSumSubArray(arr, 3));
    }


    @Test
    public void findAllAnagramsString() {
        List<Integer> result = ContinuesSubArray.findAllAnagramsString("cbaebabacd".toCharArray(), "abc".toCharArray());
        System.out.println(result);
    }
}