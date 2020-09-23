package ir.sk.algorithm;

import ir.sk.helper.Memoization;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class Algorithms {

    /**
     * Using loop
     *
     * @param n
     * @return
     */
    public static int triangleByLoop(int n) {
        int total = 0;
        while (n > 0) // until n is 1
        {
            total = total + n; // add n (column height) to total
            --n; // decrement column height
        }
        return total;
    }

    /**
     * Using Recursion
     *
     * @param n
     * @return
     */
    public static int triangleByRecursive(int n) {
        if (n == 1)
            return 1;
        else
            return (n + triangleByRecursive(n - 1));
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int div(int a, int b) {
        if (a < b)
            return 0;
        else
            return mod(a - b, b) + 1;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    @TimeComplexity("O(a/b)")
    @SpaceComplexity("O(1)")
    public static int div2(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    /**
     * computes a % b
     *
     * @param a
     * @param b
     * @return
     */
    public static int mod(int a, int b) {
        if (a < b)
            return a;
        else
            return mod(a - b, b);
    }

    /**
     * @param a
     * @param b
     * @return
     */
    @TimeComplexity("O(1)")
    @SpaceComplexity("O(1)")
    public static int mod2(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    /**
     * computes the [integer] square root of a number. If the number is not a
     * perfect square (there is no integer square root) , then it returns -1. It does this by successive
     * guessing. If n is 100, it first guesses SO. Too high? Try something lower - halfway between 1
     * and SO.
     *
     * @param n
     * @return
     */
    public static int sqrtByBinarySearch(int n) {
        return sqrt_helper(n, 1, n);
    }

    @TimeComplexity("O(log n)")
    private static int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1; // no square root
        int guess = (min + max) / 2;
        if (guess * guess == n) { // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }

    /**
     * computes the [integer] square root of a number. If the number is not
     * a perfect square (there is no integer square root), then it returns -1. It does this by trying
     * increasingly large numbers until it finds the right value (or is too high)
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(sqrt(n))")
    @SpaceComplexity("O(1)")
    public static int sqrtByIteration(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }

    /**
     * the Euclidean algorithm, or Euclid's algorithm, is an efficient method for
     * computing the greatest common divisor (GCD) of two numbers, the largest number
     * that divides both of them without leaving a remainder.
     * <p>
     * decrease-and-conquer (Divide-and-conquer algorithm) algorithm and recursive
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcdByEuclidean(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcdByEuclidean(b, mod(a, b));
    }

    /**
     * @param n
     * @param m
     * @return
     */
    @TimeComplexity("O(m)")
    @SpaceComplexity("O(1)")
    public static int powerByRecursive(int n, int m) {
        if (m == 1)
            return n;
        else
            return (n * powerByRecursive(n, m - 1));
    }

    /**
     * Pascal
     *
     * @param n
     * @param m
     * @return
     */
    public static int combinationByRecursive(int n, int m) {
        if (n == m || m == 0)
            return 1;
        else
            return combinationByRecursive(n - 1, m) + combinationByRecursive(n - 1, m - 1);
    }

    /**
     * The Towers of Hanoi
     * Divide-and-conquer algorithm and recursive
     * <p>
     * (1) Only one disk can be moved at a time.
     * (2) A disk is slid off the top of one tower onto another tower.
     * (3) A disk cannot be placed on top of a smaller disk.
     *
     * @param n      the number of disks
     * @param src    the name of the source rod
     * @param buffer the name of the auxiliary rod
     * @param dest   is the name of the destination rod
     */
    @TimeComplexity("O(2^n)")
    @SpaceComplexity("O(n)")
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
     * Time Complexity: O(n)
     *
     * @param a
     * @return
     */
    @TimeComplexity("O(n)")
    public static double mean(int a[]) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];

        return (double) sum / (double) a.length;
    }

    /**
     * @param array
     * @return
     */
    @TimeComplexity("O(n + p) = O(n)")
    @SpaceComplexity("O(p) where P is the size of auxiliary array")
    public static double meanUsingCountingSort(int array[]) {
        int n = array.length;

        int max = Arrays.stream(array).max().getAsInt();

        // Frequency Array
        int[] counting = new int[max + 1];

        // store count of each character
        for (int i = 0; i < n; i++) {
            counting[array[i]]++;
        }

        // mode is the index with maximum count
        int mode = 0;
        int k = counting[0];
        int t = max + 1;
        for (int i = 1; i < t; i++) {
            if (counting[i] > k) {
                k = counting[i];
                mode = i;
            }
        }
        return mode;
    }

    /**
     * "the middle" value
     *
     * @param a
     * @return
     */
    @TimeComplexity("O(n Log n) as we need to sort the array first")
    public static double median(int a[]) {
        // First we sort the array
        Arrays.sort(a);

        // check for even case
        if (a.length % 2 != 0)
            return a[a.length / 2];

        return (double) (a[(a.length - 1) / 2] + a[a.length / 2]) / 2.0;
    }

    /**
     * @param array
     * @return
     */
    @TimeComplexity("O(n + p) = O(n)")
    @SpaceComplexity("O(p) where P is the size of auxiliary array")
    public static double medianUsingCountingSort(int[] array) {
        int n = array.length;

        int max = Arrays.stream(array).max().getAsInt();

        // Frequency Array
        int[] counting = new int[max + 1];

        // store count of each character
        for (int i = 0; i < n; i++) {
            counting[array[i]]++;
        }

        double median = 0;
        if (n % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < counting.length; j++) {
                count += counting[j];
                if (m1 == null && count >= n / 2) {
                    m1 = j;
                }
                if (m2 == null && count >= n / 2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < counting.length; j++) {
                count += counting[j];
                if (count > n / 2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
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
    @Memoization
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
}
