package ir.sk.algorithm;

import ir.sk.algorithm.array.ContinuesSubArray;
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
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        ContinuesSubArray.maxSubArraySumKadanes(arr);
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
    public void longestSubstringDistinct() {
        Assert.assertEquals(4, ContinuesSubArray.longestSubstringDistinct("araaci".toCharArray(), 2));
    }

    @Test
    public void longestSubstringAtMostDistinct() {
        Assert.assertEquals(4, ContinuesSubArray.longestSubstringAtMostDistinct("araaci".toCharArray(), 2));
    }

    @Test
    public void longestSubstringAllDistinct() {
        Assert.assertEquals(3, ContinuesSubArray.longestSubstringAllDistinct("aabccde".toCharArray()));
    }

    @Test
    public void longestSubstringAllDistinct2() {
        Assert.assertEquals(3, ContinuesSubArray.longestSubstringAllDistinct2("aabccde".toCharArray()));
    }

    @Test
    public void longestSubstringAllDistinct3() {
        Assert.assertEquals(3, ContinuesSubArray.longestSubstringAllDistinct3("aabccde".toCharArray()));
    }

    @Test
    public void minimumWindowSubstring() {
        Assert.assertEquals("banc", ContinuesSubArray.minimumWindowSubstring("ebbancf".toCharArray(), "abc".toCharArray()));
    }

    @Test
    public void findAllAnagramsString() {
        List<Integer> result = ContinuesSubArray.findAllAnagramsString("cbaebabacd".toCharArray(), "abc".toCharArray());
        System.out.println(result);
    }
}