package ir.sk.algorithm;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BacktrackingDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * <p>
 * The worst case “brute force” solution for the N-queens puzzle has an O(n^n) time complexity.
 * This means it will look through every position on an NxN board, N times, for N queens.
 * It is by far the slowest and most impractical method.
 * <p>
 * The idea is to place queens one by one in different columns, starting from the leftmost column.
 * When we place a queen in a column, we check for clashes with already placed queens.
 * In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution.
 * If we do not find such a row due to clashes then we backtrack and return false.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
public class NQueenProblem {
    final int N = 4;

    /**
     * This function solves the N Queen problem using
     * Backtracking.  It mainly uses solveNQueen() to
     * solve the problem. It returns false if queens
     * cannot be placed, otherwise, return true and
     * prints placement of queens in the form of 1s.
     * Please note that there may be more than one
     * solutions, this function prints one of the
     * feasible solutions.
     *
     * The expected output is a binary matrix which has 1s for the blocks where queens are placed.
     * For example, following is the output matrix for above 4 queen solution.
     * <p>
     * { 0,  1,  0,  0}
     * { 0,  0,  0,  1}
     * { 1,  0,  0,  0}
     * { 0,  0,  1,  0}
     *
     * @return
     */
    public int[][] solveNQueen() {
        int board[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (solveNQueen(board, 0) == false) {
            System.out.print("Solution does not exist");
            return board;
        }

        return board;
    }

    /**
     * A recursive utility function to solve N Queen problem
     *
     * @param board
     * @param col
     * @return
     */
    @BacktrackingDFS
    @TimeComplexity("O(2^n)")
    private boolean solveNQueen(int board[][], int col) {
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
                if (solveNQueen(board, col + 1) == true)
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
     * A utility function to check if a queen can
     * be placed on board[row][col]. Note that this
     * function is called when "col" queens are already
     * placed in columns from 0 to col -1. So we need
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



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Enter board length n, return all legal placements
     *
     * The expected output is a binary matrix which has 1s for column places of each row
     * For example, following is the output matrix for above 4 queen solution.
     * [[1, 3, 0, 2], [2, 0, 3, 1]]
     *
     * @param n
     * @return
     */
    public List<List<Integer>> findAllNQueen(int n) {
        List<List<Integer>> result = new ArrayList<>();
        findAllNQueen(n, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * Path:The rows smaller than row in the board have been successfully placed the queens
     * Selection List: all columns in 'rowth' row are queen's selections
     * End condition: row meets the last line of board(n)
     *
     * @param n
     * @param row
     * @param colPlacement
     * @param result
     */
    public void findAllNQueen(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        // trigger the End Condition (our goal)
        if (row == n) {
            result.add(new ArrayList<>(colPlacement));
        } else {
            for (int col = 0; col < n; col++) {
                // exclude illegal selections (our constraints)
                if (!isValid(colPlacement))
                    continue;
                // select (choice)
                colPlacement.add(col);
                // enter next row decision
                findAllNQueen(n, row + 1, colPlacement, result);
                // unselect (undo choice)
                colPlacement.remove(colPlacement.size() - 1);
            }
        }
    }

    /*Is it possible to place a queen on board [row] [col]? */
    boolean isValid(List<Integer> colPlacement) {
        int rowId = colPlacement.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i)
                return false;
        }
        return true;
    }

}
