package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class MatrixTest {

    int A[][] = { {1, 1, 1, 1},
            {2, 2, 2, 2},
            {3, 3, 3, 3},
            {4, 4, 4, 4}};

    int B[][] = { {1, 1, 1, 1},
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

        System.out.print("Result matrix is \n");
        for (int i = 0; i < Matrix.N; i++) {
            for (int j = 0; j < Matrix.M; j++)
                System.out.print(C[i][j] + " ");
            System.out.print("\n");
        }
    }

    @Test
    public void multiplyMatrix() {
        int C[][] = Matrix.multiplyMatrix(A, B);

        System.out.print("Result matrix is \n");
        for (int i = 0; i < Matrix.N; i++) {
            for (int j = 0; j < Matrix.M; j++)
                System.out.print(C[i][j] + " ");
            System.out.print("\n");
        }
    }
}