package ir.sk.algorithm.array;

import ir.sk.algorithm.mathematic.Algorithms;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 1/20/2021.
 */
public class MathematicalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void triangleByLoop() {
        int number = 1000;
        int expectedValue = 500500;
        Assert.assertEquals(expectedValue, Mathematical.triangleByLoop(number));
    }

    @Test
    public void triangleByRecursive() {
        int number = 1000;
        int expectedValue = 500500;
        Assert.assertEquals(expectedValue, Mathematical.triangleByRecursive(number));
    }

    @Test
    public void div() {
        int expectedValue = 3;
        Assert.assertEquals(expectedValue, Mathematical.div(10, 3));
    }

    @Test
    public void div2() {
        int expectedValue = 3;
        Assert.assertEquals(expectedValue, Mathematical.div2(10, 3));
    }

    @Test
    public void mod() {
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, Mathematical.mod(10, 3));
    }

    @Test
    public void mod2() {
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, Mathematical.mod2(10, 3));
    }

    @Test
    public void sqrtByBinarySearch() {
        int expectedValue = 8;
        Assert.assertEquals(expectedValue, Mathematical.sqrtByBinarySearch(64));
    }

    @Test
    public void sqrtByIteration() {
        int expectedValue = 8;
        Assert.assertEquals(expectedValue, Mathematical.sqrtByIteration(64));
    }

    @Test
    public void gcdByEuclidean() {
    }

    @Test
    public void powerByRecursive() {
        int expectedValue = 81;
        Assert.assertEquals(expectedValue, Mathematical.powerByRecursive(3, 4));
    }

    @Test
    public void combinationByRecursive() {
        int expectedValue = 6;
        Assert.assertEquals(expectedValue, Mathematical.combinationByRecursive(4, 2));
    }

    @Test
    public void isHappyNumberNaive() {
        System.out.println(Mathematical.isHappyNumberNaive(23));
    }

    @Test
    public void isHappyNumberByRunner() {
        System.out.println(Mathematical.isHappyNumberByRunner(23));
    }

}