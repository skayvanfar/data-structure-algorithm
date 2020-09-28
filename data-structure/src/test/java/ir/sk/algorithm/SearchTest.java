package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class SearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void binarySearchByLoop() {
        int[] array = new int[]{1, 6, 8, 9, 500, 601, 705, 900};
        int expectedValue = 5;
        long startTime = System.nanoTime();
        int resultIndex = Search.binarySearchByLoop(array, 601);
        long endTime = System.nanoTime();
        System.out.println("time duration for binarySearchByLoop for array with " + array.length + " length = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, resultIndex);
    }

    @Test
    public void binarySearchByRecursive() {
        int[] array = new int[]{1, 6, 8, 9, 500, 601, 705, 900};
        int expectedValue = 5;
        long startTime = System.nanoTime();
        int resultIndex = Search.binarySearchByRecursive(array, 601, 0, array.length - 1);
        long endTime = System.nanoTime();
        System.out.println("time duration for binarySearchByRecursive for array with " + array.length + " length = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, resultIndex);
    }
}