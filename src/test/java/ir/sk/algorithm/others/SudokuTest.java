package ir.sk.algorithm.others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 9/5/2021.
 */
public class SudokuTest {

    Sudoku sudoku;

    @Before
    public void setUp() throws Exception {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        sudoku = new Sudoku(board);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void solveSudoku() {
        if (sudoku.solveSudoku()) {
            // print solution
            sudoku.print();
        }
        else {
            System.out.println("No solution");
        }
    }
}