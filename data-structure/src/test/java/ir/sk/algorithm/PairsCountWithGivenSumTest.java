package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsCountWithGivenSumTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getPairsCount() {
        int arr[] = new int[]{1, 5, 7, -1};
        Assert.assertEquals(2, PairsCountWithGivenSum.getPairsCount(arr, 6));
    }

    @Test
    public void getPairsCountByHashing() {
        int arr[] = new int[]{1, 5, 7, -1};
        Assert.assertEquals(2, PairsCountWithGivenSum.getPairsCountByHashing(arr, 6));
    }
}