package ir.sk.algorithm.array.continuessubarray;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTraversalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void printMatrixNaive() {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 } };
        MatrixTraversal.printMatrixNaive(mat);
    }

    @Test
    public void numberOfPathsGridNaive() {
        System.out.println(MatrixTraversal.numberOfPathsGridNaive(3, 3));
    }

    @Test
    public void numberOfPathsDPButtonUp() {
        System.out.println(MatrixTraversal.numberOfPathsDPButtonUp(3, 3));
    }
}