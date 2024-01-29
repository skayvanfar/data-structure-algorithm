package ir.sk.algorithm.others;

import ir.sk.algorithm.array.Search;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 2/6/2020.
 */
public class SearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void linerSearch() {
        int[] array = new int[]{1, 6, 8, 9, 500, 601, 705, 900};
        int expectedValue = 5;
        int resultIndex = Search.linerSearch(array, 601);
        Assert.assertEquals(expectedValue, resultIndex);
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

    @Test
    public void leftBoundBinarySearch() {
        int[] array = new int[]{1, 2, 2, 2, 3};
        int expectedValue = 1;
        int resultIndex = Search.leftBoundBinarySearch(array, 2);
        Assert.assertEquals(expectedValue, resultIndex);
    }

    @Test
    public void rightBoundBinarySearch() {
        int[] array = new int[]{1, 2, 2, 2, 3};
        int expectedValue = 3;
        int resultIndex = Search.rightBoundBinarySearch(array, 2);
        Assert.assertEquals(expectedValue, resultIndex);
    }
}