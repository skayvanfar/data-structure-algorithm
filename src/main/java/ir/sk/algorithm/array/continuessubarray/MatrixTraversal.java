package ir.sk.algorithm.array.continuessubarray;

import ir.sk.helper.complexity.TimeComplexity;

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

    /**
     * You 2 integers n and m representing an n by m grid, determine the number of ways you can get from the top-left to the bottom-right of the matrix y going only right or down.
     *
     * @param m
     * @param n
     * @return
     */
    @TimeComplexity("2^n")
    public static int numberOfPathsGridNaive(int m, int n) {
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return numberOfPathsGridNaive(m - 1, n) + numberOfPathsGridNaive(m, n - 1);
        // + numberOfPaths(m-1, n-1);
    }

    /**
     *  Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array count[][] in bottom up manner using the above recursive formula.
     *
     * @param m
     * @param n
     * @return
     */
    @TimeComplexity("O(m*n)")
    public static int numberOfPathsDPButtonUp(int m, int n) {
        // Create a 2D table to store results
        // of subproblems
        int count[][] = new int[m][n];

        // Count of paths to reach any cell in
        // first column is 1
        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in
        // first column is 1
        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        // Calculate count of paths for other
        // cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)

                // By uncommenting the last part the
                // code calculates the total possible paths
                // if the diagonal Movements are allowed
                count[i][j] = count[i - 1][j] + count[i][j - 1]; //+ count[i-1][j-1];
        }
        return count[m - 1][n - 1];
    }
}
