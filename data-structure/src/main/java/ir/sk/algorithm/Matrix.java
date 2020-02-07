package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class Matrix {

    static final int N = 4;
    static final int M = 4;

    /**
     * This function adds A[][] and B[][], and stores
     * @param A
     * @param B
     * @return
     */
    public static int[][] addMatrix(int A[][], int B[][]) {
        int [][] C = new int [N][M];
        int i, j;
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++)
                C[i][j] = A[i][j] + B[i][j];
        }
        return C;
    }

    /**
     * @param A
     * @param B
     */
    public static int[][] multiplyMatrix(int A[][], int B[][]) {
        int [][] C = new int [N][M];
        int i, j, k;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                C[i][j] = 0;
                for (k = 0; k < N; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }
}
