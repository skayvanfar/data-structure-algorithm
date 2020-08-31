package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class UtilsTest {

    private int[] array;

    @Before
    public void setUp() throws Exception {
        array = new int[]{1, 2, 3, 4, 5, 6};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rightRotate() {
        int[] expected = new int[]{1, 5, 2, 3, 4, 6};
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.rightRotate(array, 1, 4);
        long end = System.currentTimeMillis();
        System.out.println("rightRotate took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void leftRotate() {
        int[] expected = new int[]{1, 3, 4, 5, 2, 6};
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.leftRotate(array, 1, 4);
        long end = System.currentTimeMillis();
        System.out.println("leftRotate took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void testRightRotate() { // TODO: 7/14/2020
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.rightRotate(array, 1, 4, 2);
        long end = System.currentTimeMillis();
        System.out.println("rightRotate took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void testLeftRotate() {
        int[] expected = new int[]{1, 4, 5, 2, 3, 6};
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.leftRotate(array, 1, 4, 2);
        long end = System.currentTimeMillis();
        System.out.println("Logic shift took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
        Assert.assertArrayEquals(expected, array);
    }


    @Test
    public void testSwap() {
        int a = 4;
        int b = 5;
        long start = System.currentTimeMillis();
        int[] result = Utils.swap(a, b);
        long end = System.currentTimeMillis();
        System.out.println("Logic testSwap took " + (end - start) + " MilliSeconds");
        Assert.assertEquals(result[0], 5);
        Assert.assertEquals(result[1], 4);
    }

    @Test
    public void testGSwap() throws Exception {
        int a = 4;
        int b = 5;
        int c = 7;
        long start = System.currentTimeMillis();
        c = Utils.gSwap(a, a = b, b = c);
        long end = System.currentTimeMillis();
        System.out.println("Logic gSwap took " + (end - start) + " MilliSeconds");
        Assert.assertEquals(a, 5);
        Assert.assertEquals(b, 7);
        Assert.assertEquals(c, 4);
    }

    @Test
    public void reverse() {
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        int[] result = Utils.reverse(array);
        long end = System.currentTimeMillis();
        System.out.println("reverse took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void inPlaceReverse() {
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.inPlaceReverse(array);
        long end = System.currentTimeMillis();
        System.out.println("inPlaceReverse took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void recursiveReverse() {
        long start = System.currentTimeMillis();
        String result = Utils.recursiveReverse("test");
        long end = System.currentTimeMillis();
        System.out.println("recursiveReverse took " + (end - start) + " MilliSeconds");
        Assert.assertEquals("tset", result);
    }

    @Test
    public void isPrime() {
        boolean expectedValue = true;
        boolean actual = Utils.isPrime(7);
        Assert.assertEquals(expectedValue, actual);
    }
}