package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class Matrix {

    static final int N = 4;

    // This function adds A[][] and B[][], and stores
    // the result in C[][]
    public static int[][] addMatrix(int A[][], int B[][])
    {
        int [][] C = new int [N][N];
        int i, j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++)
                C[i][j] = A[i][j] + B[i][j];
        }
        return C;
    }
}
