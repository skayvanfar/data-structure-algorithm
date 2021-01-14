package ir.sk.algorithm;

import ir.sk.helper.Backtracking;
import ir.sk.helper.TimeComplexity;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 *
 * The expected output is a binary matrix which has 1s for the blocks where queens are placed.
 * For example, following is the output matrix for above 4 queen solution.
 *
 *               { 0,  1,  0,  0}
 *               { 0,  0,  0,  1}
 *               { 1,  0,  0,  0}
 *               { 0,  0,  1,  0}
 *
 * The worst case “brute force” solution for the N-queens puzzle has an O(n^n) time complexity.
 * This means it will look through every position on an NxN board, N times, for N queens.
 * It is by far the slowest and most impractical method.
 *
 * The idea is to place queens one by one in different columns, starting from the leftmost column.
 * When we place a queen in a column, we check for clashes with already placed queens.
 * In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution.
 * If we do not find such a row due to clashes then we backtrack and return false.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
@Backtracking
@TimeComplexity("O(2^n)")
public class NQueenProblem {
    final int N = 4;

    /**
     * A utility function to print solution
     *
     * @param board
     */
    private void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    /**
     * A utility function to check if a queen can
     * be placed on board[row][col]. Note that this
     * function is called when "col" queens are already
     * placeed in columns from 0 to col -1. So we need
     * to check only left side for attacking queens
     *
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isSafe(int board[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    /**
     * A recursive utility function to solve N Queen problem
     *
     * @param board
     * @param col
     * @return
     */
    private boolean solveNQUtil(int board[][], int col) {
        /* base case: If all queens are placed
           then return true */
        if (col >= N)
            return true;

        /* Consider this column and try placing
           this queen in all rows one by one */
        for (int i = 0; i < N; i++) {
            /* Check if the queen can be placed on
               board[i][col] */
            if (isSafe(board, i, col)) {
                /* Place this queen in board[i][col] */
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1) == true)
                    return true;

                /* If placing queen in board[i][col]
                   doesn't lead to a solution then
                   remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK
            }
        }

        /* If the queen can not be placed in any row in
           this colum col, then return false */
        return false;
    }

    /**
     * This function solves the N Queen problem using
     * Backtracking.  It mainly uses solveNQUtil () to
     * solve the problem. It returns false if queens
     * cannot be placed, otherwise, return true and
     * prints placement of queens in the form of 1s.
     * Please note that there may be more than one
     * solutions, this function prints one of the
     * feasible solutions.
     * @return
     */
    public boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
}
