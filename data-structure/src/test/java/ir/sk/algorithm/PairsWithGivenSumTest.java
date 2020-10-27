package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsWithGivenSumTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPairSum() {
        int arr[] = {20, 3, 5, 9, 2, 8, 10, 11};
        Assert.assertEquals(true, PairsWithGivenSum.isPairSum(arr, 17));
    }

    @Test
    public void isPairSumEfficient() {
        int arr[] = {2, 3, 5, 8, 9, 10, 11, 20};
        Assert.assertEquals(true, PairsWithGivenSum.isPairSumEfficient(arr, 17));
    }

    @Test
    public void getPairsCount() {
        int arr[] = new int[]{1, 5, 7, -1};
        Assert.assertEquals(2, PairsWithGivenSum.getPairsCount(arr, 6));
    }

    @Test
    public void getPairsCountByHashing() {
        int arr[] = new int[]{1, 5, 7, -1};
        Assert.assertEquals(2, PairsWithGivenSum.getPairsCountByHashing(arr, 6));
    }
}