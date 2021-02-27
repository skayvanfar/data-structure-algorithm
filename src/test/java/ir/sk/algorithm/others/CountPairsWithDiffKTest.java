package ir.sk.algorithm.others;

import ir.sk.algorithm.others.CountPairsWithDiffK;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/22/2020.
 */
public class CountPairsWithDiffKTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void countPairsWithDiffKNative() {
        int arr[] = {1, 5, 3, 4, 2};
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, CountPairsWithDiffK.countPairsWithDiffKNative(arr, 3));
    }

    @Test
    public void countPairsWithDiffK1() {
        int arr[] = {1, 5, 3, 4, 2};
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, CountPairsWithDiffK.countPairsWithDiffK1(arr, 3));
    }

    @Test
    public void countPairsWithDiffKByHashing() {
        int arr[] = {1, 5, 3, 4, 2};
        int expectedValue = 2;
        Assert.assertEquals(expectedValue, CountPairsWithDiffK.countPairsWithDiffKByHashing(arr, 3));
    }

}