package ir.sk.algorithm.basic;

import ir.sk.helper.InPlace;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Stack;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class Utils {


    /**
     * shifting - right rotation just one unit
     *
     * @param array      the source array.
     * @param startIndex starting position
     * @param endIndex   finishing position
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static void rightRotate(int[] array, int startIndex, int endIndex) {
        int temp = array[endIndex];
        int k = endIndex - 1;
        while (k >= startIndex) {
            array[k + 1] = array[k];
            k--;
        }
        array[startIndex] = temp;
    }

    /**
     * shifting - left rotation just one unit
     *
     * @param array      the source array.
     * @param startIndex starting position
     * @param endIndex   finishing position
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static void leftRotate(int[] array, int startIndex, int endIndex) {
        int temp = array[startIndex];
        int k = startIndex;
        while (k < endIndex) {
            array[k] = array[k + 1];
            k++;
        }
        array[endIndex] = temp;
    }

    /**
     * shifting - right rotation unit number
     *
     * @param array      the source array.
     * @param startEndex starting position
     * @param endIndex   finishing position
     * @param unit       the number of rotations
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(unit)")
    public static void rightRotate(int[] array, int startEndex, int endIndex, int unit) { // TODO: 7/14/2020 incorrect
        int m = startEndex;
        int[] temp = new int[unit];
        for (int k = endIndex + 1 - unit; k <= endIndex; k++) {
            temp[m] = array[k];
            m++;
        }

        int k = endIndex - unit;
        while (k >= startEndex) {
            array[k + unit] = array[k];
            k--;
        }
        for (int l = 0; l < unit; l++) {
            array[l] = temp[l];
        }
    }

    /**
     * shifting - left rotation unit number
     *
     * @param array      the source array.
     * @param startIndex starting position
     * @param endIndex   finishing position
     * @param unit       the number of rotations
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(unit)")
    public static void leftRotate(int[] array, int startIndex, int endIndex, int unit) {
        int[] temp = new int[unit];

        // move unit number from startIndex of array into a temp array
        for (int k = 0; k < unit; k++) {
            temp[k] = array[startIndex + k];
        }

        // shift other elements by unit
        int k = startIndex;
        while ((k + unit) <= endIndex) {
            array[k] = array[k + unit];
            k++;
        }

        // move all elements from temp into a latest elements array until endIndex
        for (int l = 0; l < unit; l++) {
            array[k + l] = temp[l];
        }
    }

    public static int[] leftRotateArray(int[] arr, int d) {
        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        return rotated;
    }

    /**
     * @param arr
     * @param init
     * @return
     */
    public static int[] rotateArray(int[] arr, int init) {
        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, init, rotated, 0, n - init);
        System.arraycopy(arr, 0, rotated, n - init, init);

        return rotated;
    }

    /**
     * @param a
     * @param b
     */
    public static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }

    /**
     * swap all primitive data
     * b = swap(a, a=b);
     * usage: z = swap(a, a=b, b=c, ... y=z);
     *
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T gSwap(T... args) {
        return args[0];
    }

    /**
     * checks if a number is prime by checking for divisibility on numbers less than it. It only
     * needs to go up to the square root of n because if n is divisible by a number greater than its square root then
     * it's divisible by something smaller than it.
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(sqrt(n))=O(n)")
    @SpaceComplexity("O(1)")
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
