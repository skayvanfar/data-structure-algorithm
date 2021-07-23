package ir.sk.algorithm.array.continuessubarray;

/**
 * print all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down.
 */
public class MatrixTraversal {

    /**
     * The algorithm is a recursive algorithm, from each cell first print all paths by going down and then print all paths by going right. Do this recursively for each cell encountered.
     *
     * @param mat
     */
    public static void printMatrixNaive(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        int maxLengthOfPath = m + n - 1;
        printMatrixNaive(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
    }

    private static void printMatrixNaive(int mat[][], int m, int n, int i, int j, int path[], int idx) {
        path[idx] = mat[i][j];

        // Reached the bottom of the matrix so we are left with
        // only option to move right
        if (i == m - 1) {
            for (int k = j + 1; k < n; k++) {
                path[idx + k - j] = mat[i][k];
            }
            for (int l = 0; l < idx + n - j; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }

        // Reached the right corner of the matrix we are left with
        // only the downward movement.
        if (j == n - 1) {
            for (int k = i + 1; k < m; k++) {
                path[idx + k - i] = mat[k][j];
            }
            for (int l = 0; l < idx + m - i; l++) {
                System.out.print(path[l] + " ");
            }
            System.out.println();
            return;
        }
        // Print all the paths that are possible after moving down
        printMatrixNaive(mat, m, n, i + 1, j, path, idx + 1);

        // Print all the paths that are possible after moving right
        printMatrixNaive(mat, m, n, i, j + 1, path, idx + 1);
    }
}
