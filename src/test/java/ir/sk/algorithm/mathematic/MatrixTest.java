package ir.sk.algorithm.mathematic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 2/7/2020.
 */
public class MatrixTest {

    int A[][] = {{1, 1, 1, 1},
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4}};

    int B[][] = {{1, 1, 1, 1},
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4}};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addMatrix() {
        int C[][] = Matrix.addMatrix(A, B);
        Matrix.displayMatrix(C);
    }

    @Test
    public void multiplyMatrix() {
        int C[][] = Matrix.multiplyMatrix(A, B);
        Matrix.displayMatrix(C);
    }

    @Test
    public void transposeMatrix() {
        int C[][] = Matrix.transposeMatrix(A);
        Matrix.displayMatrix(C);
    }

    @Test
    public void transposeMatrix2() {
        Matrix.transposeMatrix2(A);
        Matrix.displayMatrix(A);
    }

    @Test
    public void rotateMatrix90Degree() {
        Matrix.rotateMatrix90Degree(A);
        Matrix.displayMatrix(A);
    }

}