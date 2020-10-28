package ir.sk.algorithm;

import ir.sk.algorithm.array.SubArray;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class SubArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void maxSubArraySumBruteForce() {
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        SubArray.maxSubArraySumBruteForce(arr);
    }

    @Test
    public void maxSubArraySumKadanes() {
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        SubArray.maxSubArraySumKadanes(arr);
    }
}