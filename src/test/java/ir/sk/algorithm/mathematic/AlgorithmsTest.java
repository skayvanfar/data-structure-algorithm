package ir.sk.algorithm.mathematic;

import ir.sk.algorithm.mathematic.Algorithms;
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