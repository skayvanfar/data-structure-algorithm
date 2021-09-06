package ir.sk.algorithm.array;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BinarySearch;
import ir.sk.helper.technique.BruteForce;

import java.util.*;

/**
 * 2D Array-Grid-Matrix algorithms
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class TwoDArray {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * A Simple Solution is to one by one compare x with every element of the matrix. If matches, then return position.
     *
     * @param array
     * @param searchKey
     * @return
     */
    @BruteForce
    @TimeComplexity("O(m*n)")
    @SpaceComplexity("O(1)")
    public static String linerSearch2D(int[][] array, int searchKey) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == searchKey)
                    return "(" + i + "," + j + ")";
            }
        }
        return "not found";
    }

    /**
     * observe that any number (say k) that we want to find, must exist within a row, including the first and last elements of the row (if it exists at all).
     * So we first find the row in which k must lie using binary search ( O(logn) ) and then use binary search again to search in that row( O(logm) ).
     *
     * @param array
     * @param key
     * @return
     */
    @TimeComplexity("O(log(m) + log(n))")
    @SpaceComplexity("O(1)")
    @BinarySearch
    public static String binarySearchByLoop2D(int[][] array, int key) {
        int low = 0, high = array.length - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;

            // this means the element must be within this row
            if (key > array[mid][0] && key < array[mid][array[0].length - 1]) {
                int colIndex = Arrays.binarySearch(array[mid], key); // we'll apply binary
                // search on this row
                return "(" + mid + "," + colIndex + ")";
            } else if (key < array[mid][0])
                high = mid - 1;
            else if (key > array[mid][array[0].length - 1])
                low = mid + 1;
        }
        return "not found";
    }

    /**
     * Start from the top right corner: row = 0, col = m-1
     * <p>
     * if matrix[row][col] is equal target, return true.
     * if matrix[row][col] is less than the target, row = row + 1; indicates that this row can’t contain the target because this one in this line is the biggest one, counting from ‘row’.
     * if matrix[row][col] is greater than the target, col = col — 1; indicate that this column can’t contain the target because this one in this column is the smallest one, counting from ‘col’.
     *
     * @param matrix
     * @param target
     * @return
     */
    @TimeComplexity("O(m + n")
    @SpaceComplexity("O(1)")
    public static String binarySearchByDirection(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target)
                return "(" + row + "," + col + ")";
            else if (matrix[row][col] < target)
                row = row + 1;
            else
                col = col - 1;
        }
        return "not found";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given a 2D matrix of characters and a target word, write a function
     * that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.
     * <p>
     * String str = 'FOAM'
     * const matrix = [
     * ['F', 'A', 'C', 'I'],
     * ['O', 'B', 'Q', 'P'],
     * ['A', 'N', 'O', 'B'],
     * ['M', 'A', 'S', 'S']
     * ]
     *
     * @param matrix
     * @param world
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    public static boolean findWord(char[][] matrix, char[] world) {
        for (int i = 0; i < matrix.length; i++) {
            boolean founded = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != world[j]) {
                    founded = false;
                    break;
                }
            }
            if (founded)
                return founded;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            boolean founded = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != world[i]) {
                    founded = false;
                    break;
                }
            }
            if (founded)
                return founded;
        }

        return false;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * You are given a 2D array of integers. Print out the clockwise spiral traversal of the matrix.
     * <p>
     * grid = [[1,  2,  3,  4,  5],
     * [6,  7,  8,  9,  10],
     * [11, 12, 13, 14, 15],
     * [16, 17, 18, 19, 20]]
     * <p>
     * The clockwise spiral traversal of this array is:
     * <p>
     * 1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12
     *
     * @param matrix
     * @return
     */
    @TimeComplexity("O(n*m)")
    @SpaceComplexity("O(n*m)")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }

    /**
     * In each recursive call, we decrease the dimensions of the matrix. The idea of printing the boundary or loops is the same.
     *
     * @param arr
     * @param i
     * @param j
     * @param m
     * @param n
     */
    @Difficulty(type = DifficultyType.MEDIUM)
    @Implementation(type = ImplementationType.Recursive)
    @TimeComplexity("O(n*m)")
    @SpaceComplexity("O(1)")
    public static void spiralOrderRecursive(int arr[][], int i, int j, int m, int n) {
        // If i or j lies outside the matrix
        if (i >= m || j >= n) {
            return;
        }

        // Print First Row
        for (int p = i; p < n; p++) {
            System.out.print(arr[i][p] + " ");
        }

        // Print Last Column
        for (int p = i + 1; p < m; p++) {
            System.out.print(arr[p][n - 1] + " ");
        }

        // Print Last Row, if Last and
        // First Row are not same
        if ((m - 1) != i) {
            for (int p = n - 2; p >= j; p--) {
                System.out.print(arr[m - 1][p] + " ");
            }
        }

        // Print First Column, if Last and
        // First Column are not same
        if ((n - 1) != j) {
            for (int p = m - 2; p > i; p--) {
                System.out.print(arr[p][j] + " ");
            }
        }
        spiralOrderRecursive(arr, i + 1, j + 1, m - 1, n - 1);
    }

    //////////////////////////////////////////////////////////////////////////////////////

    /**
     * Method to print matrix in zig-zag form
     * @param a
     */
    @TimeComplexity("O(m*n)")
    @Difficulty(type = DifficultyType.EASY)
    public static void printZigZag(int a[][]) {
        int evenRow = 0; // starts from the first row
        int oddRow = 1; // starts from the next row

        while (evenRow < a.length) {
            for (int i = 0; i < a[0].length; i++) {
                // evenRow will be printed in the same direction
                System.out.print(a[evenRow][i] + " ");
            }

            // Skipping next row so as to get the next evenRow
            evenRow = evenRow + 2;

            if (oddRow < a.length) {
                for (int i = a[0].length - 1; i >= 0; i--) {
                    // oddRow will be printed in the opposite direction
                    System.out.print(a[oddRow][i] + " ");
                }
            }

            // Skipping next row so as to get the next oddRow
            oddRow = oddRow + 2;
        }
    }

    /**
     * If any cell of the matrix has a zero we can record its row and column number.
     * All the cells of this recorded row and column can be marked zero in the next iteration.
     *
     * @param matrix
     */
    @TimeComplexity("O(m*n)")
    @SpaceComplexity("O(m+n)")
    public static void setMatrixZeroesByCache(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        // Essentially, we mark the rows and columns that are to be made zero
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Iterate over the array once again and using the rows and cols sets, update the elements.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Rather than using additional variables to keep track of rows and columns to be reset, we use the matrix itself as the indicators.
     * The idea is that we can use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero.
     * This means for every cell instead of going to M+NM+N cells and setting it to zero we just set the flag in two cells.
     * <p>
     * Algorithm:
     * <p>
     * We iterate over the matrix and we mark the first cell of a row i and first cell of a column j, if the condition in the pseudo code above is satisfied. i.e. if cell[i][j] == 0.
     * <p>
     * The first cell of row and column for the first row and first column is the same i.e. cell[0][0]. Hence, we use an additional variable to tell us if the first column had been marked or not and the cell[0][0] would be used to tell the same for the first row.
     * <p>
     * Now, we iterate over the original matrix starting from second row and second column i.e. matrix[1][1] onwards.
     * For every cell we check if the row r or column c had been marked earlier by checking the respective first row cell or first column cell.
     * If any of them was marked, we set the value in the cell to 0.
     * Note the first row and first column serve as the row_set and column_set that we used in the first approach.
     *
     * @param matrix
     */
    @TimeComplexity("O(m*n)")
    @SpaceComplexity("O(1)")
    public static void setMatrixZeroes(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
