package ir.sk.algorithm.others;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.Backtracking;

import java.util.Arrays;

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
@Difficulty(type = DifficultyType.HARD)
@Backtracking
@TimeComplexity("(n!)")
public class NQueenProblem {

    private char[][] board;

    public NQueenProblem(int n) {
        // `mat[][]` keeps track of the position of queens in the current configuration
        this.board = new char[n][n];

        // '.' Means empty, and 'Q' means queen, initializing the empty board.
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
    }

    public void findAllNQueen() {
        findAllNQueen(0);
    }

    @TimeComplexity("O(2^n)")
    private void findAllNQueen(int row) {
        // trigger the End Condition (the gaul) if `N` queens are placed successfully, print the solution
        if (row == board.length) {
            printSolution();
            return;
        }

        // place queen at every square in the current row `r` and recur for each valid movement
        for (int i = 0; i < board.length; i++) {
            // exclude illegal selections (constraints)
            // if no two queens threaten each other
            if (isSafe(row, i)) {
                // select (choice) - place queen on the current square
                board[row][i] = 'Q';

                // enter next row decision
                findAllNQueen(row + 1);

                // deselect - backtrack and remove the queen from the current square
                board[row][i] = '.'; // backtracking
            }
        }
    }


    /**
     * Function to check if two queens threaten each other or not
     *
     * @param row
     * @param col
     * @return
     */
    private boolean isSafe(int row, int col) {
        // return false if two queens share the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `\` diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    /**
     * A utility function to print solution
     */
    private void printSolution() {
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]).replaceAll(",", ""));
        }
        System.out.println();
    }
}
