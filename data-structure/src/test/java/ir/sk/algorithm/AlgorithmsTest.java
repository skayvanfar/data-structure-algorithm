package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class AlgorithmsTest {

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
        Assert.assertEquals(expectedValue, Algorithms.triangleByLoop(number));
    }

    @Test
    public void triangleByRecursive() {
        int number = 1000;
        int expectedValue = 500500;
        Assert.assertEquals(expectedValue, Algorithms.triangleByRecursive(number));
    }

    @Test
    public void div() {
        int expectedValue = 3;
        Assert.assertEquals(expectedValue, Algorithms.div(10, 3));
    }

    @Test
    public void div2() {
        int expectedValue = 3;
        Assert.assertEquals(expectedValue, Algorithms.div2(10, 3));
    }

    @Test
    public void mod() {
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, Algorithms.mod(10, 3));
    }

    @Test
    public void mod2() {
        int expectedValue = 1;
        Assert.assertEquals(expectedValue, Algorithms.mod2(10, 3));
    }

    @Test
    public void sqrtByBinarySearch() {
        int expectedValue = 8;
        Assert.assertEquals(expectedValue, Algorithms.sqrtByBinarySearch(64));
    }

    @Test
    public void sqrtByIteration() {
        int expectedValue = 8;
        Assert.assertEquals(expectedValue, Algorithms.sqrtByIteration(64));
    }

    @Test
    public void gcdByEuclidean() {
    }

    @Test
    public void powerByRecursive() {
        int expectedValue = 81;
        Assert.assertEquals(expectedValue, Algorithms.powerByRecursive(3, 4));
    }

    @Test
    public void combinationByRecursive() {
        int expectedValue = 6;
        Assert.assertEquals(expectedValue, Algorithms.combinationByRecursive(4, 2));
    }

    @Test
    public void towerOfHanoi() {
        Algorithms.towerOfHanoi(4, 'A', 'C', 'B');
    }

    @Test
    public void magicSquare() {
        int[][] magicSquare = Algorithms.magicSquare(3);

        for (int i = 0; i < magicSquare.length; i++) {
            for (int j = 0; j < magicSquare.length; j++) {
                System.out.print(magicSquare[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void mean() {
        int a[] = {1, 3, 4, 2, 7, 5, 8, 6};
        String expectedValue = "4.6";
        Assert.assertEquals(expectedValue, Algorithms.mean(a) + "");
    }

    @Test
    public void meanUsingCountingSort() {
        int a[] = {1, 3, 4, 2, 7, 5, 8, 6};
        String expectedValue = "4.6";
        Assert.assertEquals(expectedValue, Algorithms.meanUsingCountingSort(a) + "");
    }

    @Test
    public void median() {
        int a[] = {1, 3, 4, 2, 7, 5, 8, 6};
        String expectedValue = "4.5";
        Assert.assertEquals(expectedValue, Algorithms.median(a) + "");
    }

    @Test
    public void medianUsingCountingSort() {
        int a[] = {1, 3, 4, 2, 7, 5, 8, 6};
        String expectedValue = "4.5";
        Assert.assertEquals(expectedValue, Algorithms.medianUsingCountingSort(a) + "");
    }

    @Test
    public void sumDigits() {
        String expectedValue = "27";
        Assert.assertEquals(expectedValue, Algorithms.sumDigits(999) + "");
    }

    @Test
    public void getSubsets() {
    }

    @Test
    public void testDoTowers() {
    }
}