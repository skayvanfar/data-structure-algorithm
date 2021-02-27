package ir.sk.algorithm.basic;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 9/16/2020.
 */
public class RotationShift {
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
        rightShift(array, startIndex, endIndex);
        array[startIndex] = temp;
    }

    /**
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void rightShift(int[] array, int startIndex, int endIndex) {
        for (int i = endIndex - 1; i >= startIndex; i--)
            array[i + 1] = array[i];
    }

    /**
     * @param array
     * @param startIndex
     * @param endIndex
     */
    public static void leftShift(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++)
            array[i] = array[i + 1];
    }

    /**
     * @param array
     * @param startIndex
     * @param endIndex
     * @param unit
     */
    public static void leftShift(int[] array, int startIndex, int endIndex, int unit) {
        for (int i = startIndex; i + unit < endIndex; i++)
            array[i] = array[i + unit];
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
        leftShift(array, startIndex, endIndex);
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
        leftShift(array, startIndex, endIndex, unit);
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
}
