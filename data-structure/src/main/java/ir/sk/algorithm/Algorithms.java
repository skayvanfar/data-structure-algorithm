package ir.sk.algorithm;

import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/7/2020.
 */
public class Algorithms {

    /**
     * @param n
     * @return
     */
    public static int factorialByRecursive(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorialByRecursive(n - 1));
    }

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

    public static int div(int a, int b) {
        if (a < b)
            return 0;
        else
            return mod(a - b, b) + 1;
    }

    public static int mod(int a, int b) {
        if (a < b)
            return a;
        else
            return mod(a - b, b);
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
     * Divide-and-conquer algorithm and recursive
     *
     * @param topN
     * @param src
     * @param inter
     * @param dest
     */
    public static void doTowers(int topN,
                                char src, char inter, char dest) {
        if (topN == 1)
            System.out.println("Disk 1 from " + src + " to " + dest);
        else {
            doTowers(topN - 1, src, dest, inter);   // src to inter

            System.out.println("Disk " + topN +   // move bottom
                    " from " + src + " to " + dest);
            doTowers(topN - 1, inter, src, dest);   // inter to dest
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

}
