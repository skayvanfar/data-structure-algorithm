package ir.sk.algorithm.others;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.Backtracking;

/**
 * Given a partially filled 9×9 2D array ‘grid[9][9]’, the goal is to assign digits (from 1 to 9) to the empty cells so that every row, column,
 * and subgrid of size 3×3 contains exactly one instance of the digits from 1 to 9.
 *
 * Created by sad.kayvanfar on 9/5/2021.
 */
@Difficulty(type = DifficultyType.HARD)
@Backtracking
@TimeComplexity("O(9^(n*n))")
@SpaceComplexity("O(n*n)")
public class Sudoku {

    private int[][] board;
    private int size;

    public Sudoku(int[][] board) {
        this.board = board;
        this.size = board.length;
    }

    public boolean solveSudoku() {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    // We still have some remaining
                    // missing values in Sudoku
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // No empty space left
        if (isEmpty) {
            return true;
        }

        // Else for each-row backtrack
        for (int num = 1; num <= size; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku()) {
                    // print(board, n);
                    return true;
                } else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col, int num) {
        // Row has the unique (row-clash)
        for (int d = 0; d < board.length; d++) {

            // Check if the number we are trying to
            // place is already present in
            // that row, return false;
            if (board[row][d] == num) {
                return false;
            }
        }

        // Column has the unique numbers (column-clash)
        for (int r = 0; r < board.length; r++) {

            // Check if the number
            // we are trying to
            // place is already present in
            // that column, return false;
            if (board[r][col] == num) {
                return false;
            }
        }

        // Corresponding square has
        // unique number (box-clash)
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public void print() {

        // We got the answer, just print it
        for (int r = 0; r < size; r++) {
            for (int d = 0; d < size; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(size) == 0) {
                System.out.print("");
            }
        }
    }
}
