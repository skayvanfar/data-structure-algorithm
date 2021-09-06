package ir.sk.algorithm.array;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BruteForce;

import java.util.ArrayList;
import java.util.List;

/**
 * 2D Array-Grid-Matrix algorithms
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class TwoDArray {

    /**
     * @param array
     * @param searchKey
     * @return
     */
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
     *
     * grid = [[1,  2,  3,  4,  5],
     *         [6,  7,  8,  9,  10],
     *         [11, 12, 13, 14, 15],
     *         [16, 17, 18, 19, 20]]
     *
     * The clockwise spiral traversal of this array is:
     *
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
}
