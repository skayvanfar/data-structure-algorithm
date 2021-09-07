package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class TwoDArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void linerSearch2D() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(TwoDArray.linerSearch2D(a, 11));
    }

    @Test
    public void binarySearchByLoop2D() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(TwoDArray.binarySearchByLoop2D(a, 11));
    }

    @Test
    public void binarySearchByDirection() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        System.out.println(TwoDArray.binarySearchByDirection(a, 11));
    }

    @Test
    public void findWord() {
        boolean result = TwoDArray.findWord(new char[][]{{'F', 'A', 'C', 'I'},
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

        System.out.println(TwoDArray.spiralOrder(a));
    }

    @Test
    public void spiralOrderRecursive() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        TwoDArray.spiralOrderRecursive(a, 0, 0, 4, 4);
    }

    @Test
    public void setMatrixZeroesByCache() {
        int a[][] = { { 0, 2, 3, 0 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        TwoDArray.setMatrixZeroesByCache(a);
        System.out.println();
    }

    @Test
    public void setMatrixZeroes() {
        int a[][] = { { 0, 2, 3, 0 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        TwoDArray.setMatrixZeroes(a);
        System.out.println();
    }

    @Test
    public void printZigZag() {
        int a[][] = { { 0, 2, 3, 0 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        TwoDArray.printZigZag(a);
    }

    @Test
    public void printMatrixDiagonal() {
        int a[][] = { { 0, 2, 3, 0 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        TwoDArray.printMatrixDiagonal(a);
    }

    @Test
    public void rowTraverse() {
        int a[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        TwoDArray.rowTraverse(a);
    }
}