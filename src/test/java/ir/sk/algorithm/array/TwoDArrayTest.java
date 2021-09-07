package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class TwoDArrayTest {

    int matrix[][] = { { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
            { 13, 14, 15, 16 } };

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void linerSearch2D() {
        System.out.println(TwoDArray.linerSearch2D(matrix, 11));
    }

    @Test
    public void binarySearchByLoop2D() {
        System.out.println(TwoDArray.binarySearchByLoop2D(matrix, 11));
    }

    @Test
    public void binarySearchByDirection() {
        System.out.println(TwoDArray.binarySearchByDirection(matrix, 11));
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
    public void spiralTraverse() {
        System.out.println(TwoDArray.spiralTraverse(matrix));
    }

    @Test
    public void spiralTraverseRecursive() {
        TwoDArray.spiralTraverseRecursive(matrix, 0, 0, 4, 4);
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
    public void zigzagTraverse2() {
        TwoDArray.zigzagTraverse2(matrix);
    }

    @Test
    public void diagonalZigZagTraverse() {
        TwoDArray.diagonalZigZagTraverse(matrix);
    }

    @Test
    public void rowTraverse() {
        TwoDArray.rowTraverse(matrix);
    }

    @Test
    public void colTraverse() {
        TwoDArray.colTraverse(matrix);
    }

    @Test
    public void oneRowTraverse() {
        TwoDArray.oneRowTraverse(matrix, 1);
    }

    @Test
    public void oneColTraverse() {
        TwoDArray.oneColTraverse(matrix, 1);
    }

    @Test
    public void oneDiagonalTraverse() {
        TwoDArray.oneDiagonalTraverse(matrix,0, 1);
    }

    @Test
    public void zigzagTraverse() {
        TwoDArray.zigzagTraverse(matrix);
    }

    @Test
    public void diagonalTraverse() {
        TwoDArray.diagonalTraverse(matrix);
    }

    @Test
    public void halfTraverseTopRight() {
        TwoDArray.halfTraverseTopRight(matrix);
    }

    @Test
    public void halfTraverseDownLeft() {
        TwoDArray.halfTraverseDownLeft(matrix);
    }

    @Test
    public void halfTraverseTopLeft() {
        TwoDArray.halfTraverseTopLeft(matrix);
    }
}