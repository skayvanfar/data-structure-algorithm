package ir.sk.algorithm.array;

import ir.sk.helper.BruteForce;
import ir.sk.helper.RunnerPattern;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class Array {

    /**
     * Given a 2D matrix of characters and a target word, write a function
     * that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.
     *
     * String str = 'FOAM'
     * const matrix = [
     *   ['F', 'A', 'C', 'I'],
     *   ['O', 'B', 'Q', 'P'],
     *   ['A', 'N', 'O', 'B'],
     *   ['M', 'A', 'S', 'S']
     * ]
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
     *
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
}
