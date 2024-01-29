package ir.sk.algorithm.mathematic;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.DivideAndConquer;
import ir.sk.helper.paradigm.DynamicProgramming;
import ir.sk.helper.paradigm.DynamicProgrammingType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 2/7/2020.
 */
public class Algorithms {


    /**
     * The Towers of Hanoi
     * Divide-and-conquer algorithm and recursive
     * <p>
     * (1) Only one disk can be moved at a time.
     * (2) A disk is slid off the top of one tower onto another tower.
     * (3) A disk cannot be placed on top of a smaller disk.
     * 
     * T(n):
     *    1             n = 1
     *    2*T(n-1) + 1  n > 1
     *
     * @param n      the number of disks
     * @param src    the name of the source rod
     * @param buffer the name of the auxiliary rod
     * @param dest   is the name of the destination rod
     */
    @TimeComplexity("O(2^n)")
    @SpaceComplexity("O(n)")
    @DivideAndConquer
    public static void towerOfHanoi(int n, char src, char buffer, char dest) {
        if (n == 1)
            System.out.println("Disk 1 from " + src + " to " + dest);
        else {
            towerOfHanoi(n - 1, src, dest, buffer);   // src to buffer

            System.out.println("Disk " + n +   // move bottom
                    " from " + src + " to " + dest);
            towerOfHanoi(n - 1, buffer, src, dest);   // buffer to dest
        }

    }

    /**
     * @param n the number of people standing in the circle
     * @return the safe position who will survive the execution
     * f(N) = 2L + 1 where N =2^M + L and 0 <= L < 2^M
     */
    public int getSafePosition(int n) {
        // find value of L for the equation
        int valueOfL = n - Integer.highestOneBit(n);
        int safePosition = 2 * valueOfL + 1;

        return safePosition;
    }

    public static int[][] magicSquare(int n) {
        int[][] magicSquare = new int[n][n];

        int number = 1;
        int row = 0;
        int column = n / 2;
        int curr_row;
        int curr_col;
        while (number <= n * n) {
            magicSquare[row][column] = number;
            number++;
            curr_row = row;
            curr_col = column;
            row -= 1;
            column += 1;
            if (row == -1) {
                row = n - 1;
            }
            if (column == n) {
                column = 0;
            }
            if (magicSquare[row][column] != 0) {
                row = curr_row + 1;
                column = curr_col;
                if (row == -1) {
                    row = n - 1;
                }
            }
        }
        return magicSquare;
    }

    /**
     * sums the digits in a number
     * <p>
     * The runtime will be the number of digits in the number. A number with d digits can have a
     * value up to 10 ^ d. If n = 10 ^ d , then d = log n. Therefore, the runtime is 0( log n).
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(log n)")
    public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Power Set: a method to return all subsets of a set.
     *
     * @param set
     * @param index
     * @return
     */
    @SpaceComplexity("O(n*2^n)")
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {//Base case - add empty set
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>()); // Empty set
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allSubsets.addAll(moresubsets);
        }
        return allSubsets;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
     * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
     * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
     * the bottom right.
     *
     * @param maze
     * @return
     */
    @TimeComplexity("O(2^(r+c)) where r = row, c = col")
    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
        /* If out of bounds or not available, return.*/
        if (col < 0 || row < 0 || !maze[row][col])
            return false;


        boolean isAtOrigin = (row == 0) && (col == 0);

        /* If there's a path from the start to here, add my location. */
        if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * @param maze
     * @return
     */
    @TimeComplexity("O(rc)")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    public static ArrayList<Point> memoizedDPGetPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints))
            return path;

        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
                                   HashSet<Point> failedPoints) {
        /* If out of bounds or not available, return.*/
        if (col < 0 || row < 0 || !maze[row][col])
            return false;

        Point p = new Point(row, col);

        /* If we've already visited this cell, return. */
        if (failedPoints.contains(p))
            return false;

        boolean isAtOrigin = (row == 0) && (col == 0);

        /* If there's a path from start to my current loc ation, add my location.*/
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p); // Cache result
        return false;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    @TimeComplexity("O(2^(r+c))")
    public static int findMinPath(int[][] array, int r, int c) {
        int R = array.length;
        int C = array[0].length;
        if (r >= R || c >= C) return 100000000; // Infinity
        if (r == R - 1 && c == C - 1) return 0;
        return array[r][c] + Math.min(findMinPath(array, r + 1, c), findMinPath(array, r, c + 1));
    }

    @TimeComplexity("O(r*c)")
    @DynamicProgramming(type = DynamicProgrammingType.TOP_DAWN_MEMOIZATION)
    public static int findMinPathByDP(int[][] array, int r, int c, int[][] memo) {
        int R = array.length;
        int C = array[0].length;
        if (r >= R || c >= C) return 100000000; // Infinity
        if (r == R - 1 && c == C - 1) return 0;
        if (memo[r][c] != -1) return memo[r][c];
        memo[r][c] = array[r][c] + Math.min(findMinPathByDP(array, r + 1, c, memo), findMinPathByDP(array, r, c + 1, memo));
        return memo[r][c];
    }

}
