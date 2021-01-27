package ir.sk.algorithm.array;

import ir.sk.helper.*;

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

    /**
     * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
     * Input: [-3, 0, 1, 2, -1, 1, -2]
     * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
     * Explanation: There are four unique triplets whose sum is equal to zero.
     * <p>
     * This problem follows the Two Pointers pattern and shares similarities with Pair with Target Sum.
     * A couple of differences are that the input array is not sorted and instead of a pair we need to find triplets with a target sum of zero.
     * <p>
     * To follow a similar approach, first, we will sort the array and then iterate through it
     * taking one number at a time. Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0X+Y+Z==0.
     * At this stage, our problem translates into finding a pair whose sum is equal to “-X−X” (as from the above equation Y + Z == -XY+Z==−X).
     * <p>
     * Another difference from Pair with Target Sum is that we need to find all the unique triplets.
     * To handle this, we have to skip any duplicate number. Since we will be sorting the array,
     * so all the duplicate numbers will be next to each other and are easier to skip.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(nLogn + n^2) = O(n^2)")
    @SpaceComplexity("O(n)")
    @MultiplePointerPattern
    public static List<List<Integer>> searchTripletsSumZero(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1]) // skip same element to avoid duplicate triples
                continue;
            searchPair(array, -array[i], i + 1, triplets);
        }
        return triplets;
    }

    @TimeComplexity("O(n)")
    private static void searchPair(int[] array, int targetSum, int left, java.util.List<List<Integer>> triplets) {
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, array[left], array[right]));
                left++;
                right--;
                while (left < right && array[left] == array[left - 1])
                    left++; //skip same element to avoid duplicate triplets
                while (left < right && array[right] == array[right] + 1)
                    right--;
            } else if (targetSum > currentSum)
                left++; // we need a pair with bigger sum
            else
                right--; // we need a pair with smaller sum
        }
    }

    /**
     * Given an array of unsorted numbers and a target number,
     * find a triplet in the array whose sum is as close to the target number as possible,
     * return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
     * <p>
     * This problem follows the Two Pointers pattern and is quite similar to Triplet Sum to Zero.
     * <p>
     * We can follow a similar approach to iterate through the array,
     * taking one number at a time. At every step, we will save the difference between the triplet and the target number,
     * so that in the end, we can return the triplet with the closest sum.
     *
     * @param array
     * @param targetSum
     * @return
     */
    @TimeComplexity("O(nLogn + n^2) = O(n^2)")
    @SpaceComplexity("O(n)")
    @MultiplePointerPattern
    public static int searchTripletsSumNearNumber(int[] array, int targetSum) {
        Arrays.sort(array);
        int smallDifference = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1, right = array.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDiff = targetSum - array[i];
                if (targetDiff == 0) { // we've found a triplet with an exact sum
                    return targetSum - targetDiff; // return sum of all the numbers
                }

                if (java.lang.Math.abs(targetDiff) < java.lang.Math.abs(smallDifference)) {
                    smallDifference = targetDiff;
                }

                if (targetDiff > 0) {
                    left++; // we need triplet with bigger sum
                } else {
                    right--; // we need triplet with smaller sum
                }
            }
        }
        return targetSum - smallDifference;
    }

    /**
     * Given an array arr of unsorted numbers and a target sum,
     * count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k
     * are three different indices. Write a function to return the count of such triplets.
     * Input: [-1, 0, 2, 3], target=3
     * Output: 2
     * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
     * <p>
     * This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero. The only difference is that, in this problem, we need to find the triplets whose sum is less than the given target. To meet the condition i != j != k we need to make sure that each number is not used more than once.
     * <p>
     * Following a similar approach, first we can sort the array and then iterate through it,
     * taking one number at a time. Let’s say during our iteration we are at number ‘X’,
     * so we need to find ‘Y’ and ‘Z’ such that X + Y + Z < targetX+Y+Z<target. At this stage,
     * our problem translates into finding a pair whose sum is less than “$ target - X$”
     * (as from the above equation Y + Z == target - XY+Z==target−X).
     * We can use a similar approach as discussed in Triplet Sum to Zero.
     *
     * @param array
     * @param target
     * @return
     */
    @TimeComplexity("O(nLogn + n^2) = O(n^2)")
    @SpaceComplexity("O(n) which is required for sorting if we are not using an in-place sorting algorithm.")
    @MultiplePointerPattern
    public static int searchTripletsSumSmallerThanNumber(int[] array, int target) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count += searchPair2(array, target - array[i], i);
        }
        return count;
    }

    @TimeComplexity("O(n)")
    private static int searchPair2(int[] array, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] < targetSum) { // found the triplet
                // since array[right] >= array[left], therefore, we can replace array [right] by any
                // number between left and right to get a sum less than the target sum
                count += right - left;
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }

    /**
     * Write a function to return the list of all such triplets instead of the count.
     * How will the time complexity change in this case?
     * <p>
     * Following a similar approach we can create a list containing all the triplets.
     *
     * @param array
     * @param target
     * @return
     */
    @TimeComplexity("O(nLogn + n^3) = O(n^3)")
    @SpaceComplexity("O(n) which is required for sorting if we are not using an in-place sorting algorithm.")
    @MultiplePointerPattern
    public static List<List<Integer>> returnTripletsSumSmallerThanNumber(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            searchPair2(array, target - array[i], i, triplets);
        }
        return triplets;
    }

    @TimeComplexity("O(n)")
    private static int searchPair2(int[] array, int targetSum, int first, java.util.List<List<Integer>> triplets) {
        int count = 0;
        int left = first + 1, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] < targetSum) { // found the triplet
                // since array[right] >= array[left], therefore, we can replace array [right] by any
                // number between left and right to get a sum less than the target sum
                for (int i = right; i > left; i--) {
                    triplets.add(Arrays.asList(array[first], array[left], array[i]));
                }
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }

    /**
     * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
     * Input: [4, 1, 2, -1, 1, -3], target=1
     * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
     * Explanation: Both the quadruplets add up to the target.
     *
     * This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero.
     *
     * We can follow a similar approach to iterate through the array, taking one number at a time. At every step during the iteration,
     * we will search for the quadruplets similar to Triplet Sum to Zero whose sum is equal to the given target.
     *
     * @param array
     * @param target
     * @return
     */
    @TimeComplexity("O(nLogn + n^3) = O(n^3)")
    @SpaceComplexity("O(n) which is required for sorting if we are not using an in-place sorting algorithm.")
    @MultiplePointerPattern
    public static List<List<Integer>> searchQuadrupletsSumNumber(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < array.length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) // skipp the same element to avoid duplicate quadruplets
                continue;
            for (int j = i + 1; j < array.length - 2; j++) {
                if (j > i + 1 && array[j] == array[j - 1]) // skip same element to avoid duplicate quadruplets
                    continue;
                searchPairs3(array, target, i, j, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchPairs3(int[] array, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
        int left = second + 1;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[first] + array[second] + array[left] + array[right];
            if (sum == targetSum) { // found the quadruplet
                quadruplets.add(Arrays.asList(array[first], array[second], array[left], array[right]));
                left++;
                right--;
                while (left < right && array[left] == array[left - 1])
                    left++; // skip same element to avoid duplicate quadruplets
                while (left < right && array[right] == array[left + 1])
                    right--; // skip same element to avoid duplicate quadruplets
            } else if (sum < targetSum)
                left++; // we need a pair with a bigger sum
            else
                right--; // we need a pair with a smaller sum
        }
    }
}
