package ir.sk.algorithm.array;

import ir.sk.helper.*;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.pattern.RunnerPattern;
import ir.sk.helper.pattern.XOR;
import ir.sk.helper.recursiontype.TailRecursion;
import ir.sk.helper.technique.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayAlgorithms {

    /**
     * Given a 2D matrix of characters and a target word, write a function
     * that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.
     * <p>
     * String str = 'FOAM'
     * const matrix = [
     * ['F', 'A', 'C', 'I'],
     * ['O', 'B', 'Q', 'P'],
     * ['A', 'N', 'O', 'B'],
     * ['M', 'A', 'S', 'S']
     * ]
     *
     * @param matrix
     * @param world
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    public static boolean findWord(char[][] matrix, char[] world) {
        for (int i = 0; i < matrix.length; i++) {
            boolean founded = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != world[j]) {
                    founded = false;
                    break;
                }
            }
            if (founded)
                return founded;
        }

        for (int j = 0; j < matrix[0].length; j++) {
            boolean founded = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != world[i]) {
                    founded = false;
                    break;
                }
            }
            if (founded)
                return founded;
        }

        return false;
    }

    /**
     * We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index. Now,
     * if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
     * You should assume that the array is circular which means two things:
     * <p>
     * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
     * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
     * Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static boolean loopExistsInCircularArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isForward = array[i] >= 0;
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we ca't find cycle for this number
            do {
                slow = findNextIndex(array, isForward, slow); // move one step for slow pointer
                fast = findNextIndex(array, isForward, fast); // move one step for fast pointer
                if (fast != -1)
                    fast = findNextIndex(array, isForward, fast); // move another step for fast pointer
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    private static int findNextIndex(int[] array, boolean isForward, int currentIndex) {
        boolean direction = array[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + array[currentIndex]) % array.length;
        if (isForward != direction)
            return -1; // change in direction, return -1

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    /**
     * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
     * <p>
     * use two pointers starting at both the ends of the input array. At any step,
     * whichever pointer gives us the bigger square we add it to the result array and move to the next/previous number according to the pointer.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static int[] makeSquaresSortedArray(int[] array) {
        int[] squares = new int[array.length];
        int highestSquareIds = array.length - 1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int leftSquare = array[left] * array[left];
            int rightSquare = array[right] * array[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIds--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIds--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Magic Index (Fixed Point): A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
     * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
     * array A.
     * <p>
     * Linearly search for an index i such that arr[i] == i. Return the first such index found.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int magicIndexNaive(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i)
                return i;
        }
        return -1;
    }

    /**
     * See {@link #magicIndexNaive(int[])}
     *
     * @param array
     * @return
     */
    public static int magicIndexBinarySearch(int[] array) {
        return magicIndexBinarySearch(array, 0, array.length - 1);
    }


    /**
     * First check whether middle element is Fixed Point or not. If it is, then return it;
     * otherwise check whether index of middle element is greater than value at the index.
     * If index is greater, then Fixed Point(s) lies on the right side of the middle point
     * (obviously only if there is a Fixed Point). Else the Fixed Point(s) lies on left side.
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(Log n)")
    @SpaceComplexity("O(1)")
    @BinarySearch
    @DecreaseAndConquer
    private static int magicIndexBinarySearch(int arr[], int low, int high) {
        if (high >= low) {
            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if (mid == arr[mid])
                return mid;
            if (mid > arr[mid])
                return magicIndexBinarySearch(arr, (mid + 1), high);
            else
                return magicIndexBinarySearch(arr, low, (mid - 1));
        }

        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given an array arr[] of positive integers, the task is to find whether it is possible to make this array strictly decreasing by modifying at most one element.
     * <p>
     * For every element arr[i], if it is greater than both arr[i – 1] and arr[i + 1] or it is smaller than both arr[i – 1] and arr[i + 1] then arr[i] needs to be modified.
     * i.e arr[i] = (arr[i – 1] + arr[i + 1]) / 2. If after modification, arr[i] = arr[i – 1] or arr[i + 1] then the array cannot be made strictly decreasing without affecting at most one element else count all such modifications, if the count of modifications in the end is less than or equal to 1 then print Yes else print No.
     *
     * @return
     */
    @TimeComplexity("O(n)")
    public static boolean checkPossibility(int[] arr) {
        int n = arr.length;

        // To store the number of modifications
        // required to make the array
        // strictly decreasing
        int modify = 0;

        // Check whether the last element needs
        // to be modify or not
        if (arr[n - 1] >= arr[n - 2]) {
            arr[n - 1] = arr[n - 2] - 1;
            modify++;
        }

        // Check whether the first element needs
        // to be modify or not
        if (arr[0] <= arr[1]) {
            arr[0] = arr[1] + 1;
            modify++;
        }

        // Loop from 2nd element to the 2nd last element
        for (int i = n - 2; i > 0; i--) {

            // Check whether arr[i] needs to be modified
            if ((arr[i - 1] <= arr[i] && arr[i + 1] <= arr[i])
                    || (arr[i - 1] >= arr[i] && arr[i + 1] >= arr[i])) {

                // Modifying arr[i]
                arr[i] = (arr[i - 1] + arr[i + 1]) / 2;
                modify++;

                // Check if arr[i] is equal to any of
                // arr[i-1] or arr[i+1]
                if (arr[i] == arr[i - 1] || arr[i] == arr[i + 1])
                    return false;
            }
        }

        // If more than 1 modification is required
        if (modify > 1)
            return false;

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given a list of numbers, where every number shows up twice except for one number, find that one number.
     *
     * Input: [4, 3, 2, 4, 1, 3, 2]
     * Output: 1
     *
     * One solution is to check every element if it appears once or not. Once an element with a single occurrence is found, return it. Time complexity of this solution is O(n2).
     *
     * A better solution is to use hashing.
     * 1) Traverse all elements and put them in a hash table. Element is used as key and the count of occurrences is used as the value in the hash table.
     * 2) Traverse the array again and print the element with count 1 in the hash table.
     * This solution works in O(n) time but requires extra space.
     * The best solution is to use XOR. XOR of all array elements gives us the number with a single occurrence. The idea is based on the following two facts.
     * a) XOR of a number with itself is 0.
     * b) XOR of a number with 0 is number itself.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @XOR
    public static int findSingleNumber(int array[]) {
        // Do XOR of all elements and return
        int res = array[0];
        for (int i = 1; i < array.length; i++)
            res = res ^ array[i];

        return res;
    }
}
