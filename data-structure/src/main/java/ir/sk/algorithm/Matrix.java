package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class Matrix {

    static final int N = 4;
    static final int M = 4;
    static final int P = 4;

    /**
     * This function adds A[][] and B[][], and stores
     * @param A
     * @param B
     * @return
     */
    public static int[][] addMatrix(int A[][], int B[][]) {
        int [][] C = new int [N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                C[i][j] = 0;
                for (int k = 0; k < P; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }

    /**
     * @param A
     * @return
     */
    public static int[][] transposeMatrix(int A[][]) {
        int [][] C = new int [N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                C[j][i] =  A[i][j];
            }
        }
        return C;
    }
}
