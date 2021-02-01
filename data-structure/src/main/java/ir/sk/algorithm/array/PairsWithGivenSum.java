package ir.sk.algorithm.array;

import ir.sk.helper.*;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.technique.BruteForce;

import java.util.Arrays;

/**
 * Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
 *
 * <p>
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsWithGivenSum {

    /***************
     *  Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
     **Fast *************/

    /**
     * Given an array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
     * we consider all possible pairs of elements in the array and check their sum by two loops.
     *
     * @param input
     * @param targetValue
     * @return
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @MultipleLoopsPattern
    public static boolean isPairSum(int[] input, int targetValue) {

        for (int i = 0; i < input.length; i++)
            for (int j = i + 1; j < input.length; j++)
                if (input[i] + input[j] == targetValue)
                    return true;

        return false;
    }

    /**
     * Since the given array is sorted, a brute-force solution could be to iterate through the array,
     * taking one number at a time and searching for the second number through Binary Search.
     *
     * @param input
     * @param targetValue
     * @return
     */
    @TimeComplexity("O(n*Log n)")
    @SpaceComplexity("O(1)")
    public static boolean isPairSumBinarySort(int[] input, int targetValue) {

        for (int i = 0; i < input.length; i++)
            if (Arrays.binarySearch(input, targetValue - input[i]) != 1)
                return true;

        return false;
    }

    /**
     * Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
     *
     * You can keep variables that point to different parts of an array.
     * Having multiple pointers helps to avoid O(n²) time complexity if for example you wanted to calculate a target sum from a pair of numbers in a sorted array.
     * You can have a pointer at the beginning of the array and at the end of the array and you would move the pointers on every iteration. This would reduce the time complexity to O(n).
     *
     * point: array must be SORTED to work
     * @param input
     * @param targetValue
     * @return
     */
    @MultiplePointerPattern
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static boolean isPairSumTwoPointers(int[] input, int targetValue) {

        int pointerOne = 0;
        int pointerTwo = input.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];

            if (sum == targetValue) {
                return true;
            } else if (sum < targetValue) {
                pointerOne++;
            } else {
                pointerTwo--;
            }
        }

        return false;
    }

    /**
     * Given an array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
     *
     * @param array
     * @param targetValue
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n + k)")
    @FrequencyCountingPattern
    public static boolean isPairSumByHashing(int[] array, int targetValue) {
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();

        int range = max - min;

        // as a cache
        boolean[] counting = new boolean[range];

        for (int i = 0; i < array.length; i++) {
            counting[array[i] - min] = true;
        }

        for (int i = 0; i < array.length; i++) {
            int value = targetValue - array[i];
            if (counting[value - min] && value > array[i])
                return true;
        }
        return false;
    }

    /***************
     * variant of PairsWithGivenSum
     * find all pairs with sum k within an array (assuming all distinct elements)
     ***************/

    /**
     * A simple solution is be traverse each element and check if there’s another number in the array which can be added to it to give sum.
     *
     * @param arr
     * @param sum
     */
    @BruteForce
    @TimeComplexity("O(n2)")
    @SpaceComplexity("O(1)")
    public static int getPairsCount(int[] arr, int sum) {

        int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        // O(n)
        for (int i = 0; i < arr.length; i++)
            // O(n)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;

        return count;
    }

    /**
     * for every element check if it can be combined with any other element (other than itself!) to give the desired sum
     *
     * @param arr
     * @param sum
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n + k)")
    @Point("Using hashtable is trade off between time and space" +
            "change Multiply O(n)*O(n) into O(n)+O(n) by using hashtable")
    @FrequencyCountingPattern
    public static int getPairsCountByHashing(int[] arr, int sum) {

        int count = 0;// Initialize result

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // for negative numbers
        int range = max - min + 1;

        @Point("When you want to use array as hashtable use like below")
        boolean[] counting = new boolean[range];

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            counting[arr[i] - min] = true;
        }

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            int value = sum - arr[i];
            // O(1)
            if (counting[value - min] && value > arr[i])
                count++;
        }

        return count;
    }

    /**
     * Given an array of sorted numbers, remove all duplicates from it (set it zero). You should not use any extra space;
     *
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static void deleteDuplicates(int[] arr) {
        int start = 0, end = 1;

        while (end < arr.length) {
            if (arr[start] == arr[end])
                arr[end] = 0;
            else
                start = end;
            end++;
        }
    }

    /**
     * Given an array of sorted numbers, remove all duplicates from it.
     * You should not use any extra space;
     * after removing the duplicates in-place return the new length of the array.
     *
     * In this problem, we need to remove the duplicates in-place such that the resultant length of the array remains sorted.
     * As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates. In other words,
     * we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number.
     * So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.
     * TODO: 1/7/2021 need more attention
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static void deleteDuplicatesAndShift(int[] arr) {
        int nextNonDuplicate = 1;

        for (int i = 0; i < arr.length;i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
    }

    /**
     *  Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
     *
     * // TODO: 1/16/2021 need more attention 
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    public static int deleteDuplicatesAll(int[] arr, int key) {
        int nextElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }
}
