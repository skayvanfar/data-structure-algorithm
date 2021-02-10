package ir.sk.algorithm.array;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.MultiplePointerPattern;

/**
 * Remove duplicates from an array
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/10/2021.
 */
public class Duplicate {

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
     * <p>
     * In this problem, we need to remove the duplicates in-place such that the resultant length of the array remains sorted.
     * As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates. In other words,
     * we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number.
     * So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.
     * TODO: 1/7/2021 need more attention
     *
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static void deleteDuplicatesAndShift(int[] arr) {
        int nextNonDuplicate = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
    }

    /**
     * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
     * <p>
     * // TODO: 1/16/2021 need more attention
     *
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
