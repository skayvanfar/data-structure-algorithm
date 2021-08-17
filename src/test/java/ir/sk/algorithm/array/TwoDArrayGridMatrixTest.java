package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class TwoDArrayGridMatrixTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findWord() {
        boolean result = TwoDArrayGridMatrix.findWord(new char[][]{{'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}}, "FOAM".toCharArray());
        System.out.println(result);
    }

    @Test
    public void spiralOrder() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(TwoDArrayGridMatrix.spiralOrder(a));
    }

    @Test
    public void spiralOrderRecursive() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        TwoDArrayGridMatrix.spiralOrderRecursive(a, 0, 0, 4, 4);
    }
}