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
        array = new int[]{1, 5, 2, 4, 9, 7};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rotate() {
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.rotate(array, 1, 4);
        long end = System.currentTimeMillis();
        System.out.println("Logic shift took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
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
        System.out.println("Logic shift took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void inPlaceReverse() {
        System.out.println(Arrays.toString(array));
        long start = System.currentTimeMillis();
        Utils.inPlaceReverse(array);
        long end = System.currentTimeMillis();
        System.out.println("Logic shift took " + (end - start) + " MilliSeconds");
        System.out.println(Arrays.toString(array));
    }
}