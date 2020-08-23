package ir.sk.algorithm;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class MaxSubArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void maxSubArraySumBruteForce() {
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        MaxSubArray.maxSubArraySumBruteForce(arr);
    }

    @Test
    public void maxSubArraySumKadanes() {
        int[] arr = new int[]{1, 5, 2, 4, 9, 7};
        MaxSubArray.maxSubArraySumKadanes(arr);
    }
}