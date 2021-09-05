package ir.sk.algorithm.others;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 9/5/2021.
 */
@TimeComplexity("O(8^(n^2)), There are N2 Cells and for each, we have a maximum of 8 possible moves to choose from")
public class KnightTour {

    private int[][] board;
    private int size;

    public KnightTour(int n) {
        this.board = new int[n][n];
        this.size = n;

        /* Initialization of solution matrix */
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++)
                board[x][y] = -1;
    }

    /* A utility function to check if i,j are
           valid indexes for N*N chessboard */
    public boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < size && y >= 0 && y < size && sol[x][y] == -1);
    }

    /* A utility function to print solution
       matrix sol[N][N] */
    public void printSolution(int sol[][]) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    /* This function solves the Knight Tour problem
       using Backtracking.  This  function mainly
       uses solveKTUtil() to solve the problem. It
       returns false if no complete tour is possible,
       otherwise return true and prints the tour.
       Please note that there may be more than one
       solutions, this function prints one of the
       feasible solutions.  */
    public boolean solveKT() {
        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        // Since the Knight is initially at the first block
        board[0][0] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */
        if (!solveKTUtil(0, 0, 1, board, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(board);

        return true;
    }

    /* A recursive utility function to solve Knight
       Tour problem */
    public boolean solveKTUtil(int x, int y, int moveI,
                               int board[][], int xMove[],
                               int yMove[]) {
        int k, nextX, nextY;
        if (moveI == size * size)
            return true;

        /* Try all next moves from the current coordinate
            x, y */
        for (k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveI;
                if (solveKTUtil(nextX, nextY, moveI + 1, board, xMove, yMove))
                    return true;
                else
                    board[nextX][nextY] = -1; // backtracking
            }
        }

        return false;
    }

}
