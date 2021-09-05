package ir.sk.algorithm.others;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.Backtracking;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e.,
 * maze[N-1][N-1]. A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
 *
 * In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination.
 * Note that this is a simple version of the typical Maze problem.
 * For example, a more complex version can be that the rat can move in 4 directions and a more complex version can be with a limited number of moves.
 *
 * Algorithm:
 *
 * Create a solution matrix, initially filled with 0’s.
 * Create a recursive function, which takes initial matrix, output matrix and position of rat (i, j).
 * if the position is out of the matrix or the position is not valid then return.
 * Mark the position output[i][j] as 1 and check if the current position is destination or not. If destination is reached print the output matrix and return.
 * Recursively call for position (i+1, j) and (i, j+1).
 * Unmark position (i, j), i.e output[i][j] = 0.
 *
 * Java program to solve Rate in a Maze problem using backtracking
 * <p>
 * Created by sad.kayvanfar on 2/15/2021.
 */
@Backtracking
@TimeComplexity("O(2^(n^2))")
@SpaceComplexity("O(n^2)")
public class RatInMaze {

    private int[][] maze;
    private int[][] result;
    // size of the maze
    private int size;

    public RatInMaze(int[][] maze) {
        this.maze = maze;
        this.size = maze.length;
        this.result = new int[size][size];
    }

    /**
     * This function solves the Maze problem using Backtracking.
     * It mainly uses recursive solveMaze function to solve the problem.
     * It returns false if no path is possible, otherwise return true and
     * prints the path in the form of 1s. there may be more than one solution,
     * this function prints one of the feasible solutions.
     *
     * @return
     */
    public boolean solveMaze() {
        if (solveMaze(maze, 0, 0, result) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }

        printSolution(result);
        return true;
    }

    /**
     * @param maze
     * @param x
     * @param y
     * @param result
     * @return
     */
    private boolean solveMaze(int[][] maze, int x, int y, int[][] result) {
        // if (x, y is goal) return  true
        if (x == size - 1 && y == size - 1 && maze[x][y] == 1) {
            result[x][y] = 1;
            return true;
        }

        // check if maze[x][y] is valid
        if (isSafe(maze, x, y)) {
            // Check if the current block is already part of solution path.
            if (result[x][y] == 1)
                return false;

            // mark x, y as part of the solution path
            result[x][y] = 1;

            /* Move forward in x direction */
            if (solveMaze(maze, x + 1, y, result))
                return true;

            /* If moving in x direction doesn't give
            solution then Move down in y direction */
            if (solveMaze(maze, x, y + 1, result))
                return true;

            /* If moving in y direction doesn't give
            solution then Move backwards in x direction */
            if (solveMaze(maze, x - 1, y, result))
                return true;

            /* If moving backwards in x direction doesn't give
            solution then Move upwards in y direction */
            if (solveMaze(maze, x, y - 1, result))
                return true;

            /* If none of the above movements works then
            BACKTRACK: unmark x, y as part of solution
            path */
            result[x][y] = 0;
            return false;
        }
        return false;
    }

    /**
     * A utility function to check if x, y is valid index for N*N maze
     *
     * @param maze
     * @param x
     * @param y
     * @return
     */
    private boolean isSafe(int[][] maze, int x, int y) {
        // if (x, y outside maze) return false
        return (x >= 0 && x < size && y >= 0 && y < size && maze[x][y] == 1);
    }

    /**
     * A utility function to print solution matrix sol[N][N]
     *
     * @param sol
     */
    public void printSolution(int sol[][]) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }
}
