package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void factorialByRecursive() {
        int number = 6;
        int expectedValue = 720;
        Assert.assertEquals(expectedValue, Algorithms.factorialByRecursive(number));
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
    }

    @Test
    public void mod() {
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
    public void doTowers() {
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
}