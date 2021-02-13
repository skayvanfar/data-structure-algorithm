package ir.sk.algorithm.array;

import ir.sk.algorithm.basic.Utils;
import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 2/13/2021.
 */
public class CyclicSortPattern {

    /**
     * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
     * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
     * <p>
     * This problem follows the Cyclic Sort pattern. Since the input array contains unique numbers from the range 0 to ‘n’,
     * we can use a similar strategy as discussed in Cyclic Sort to place the numbers on their correct index. Once we have every number in its correct place,
     * we can iterate the array to find the index which does not have the correct number, and that index will be our missing number.
     * <p>
     * See also {@link ir.sk.algorithm.Sort#cyclicSort(int[])}
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) + O(n) = O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.EASY)
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] == nums[j])
                Utils.swapInArray(nums, i, nums[i]);
            else
                i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    /**
     * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
     * The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
     *
     * This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number with one difference.
     * In this problem, there can be many duplicates whereas in ‘Find the Missing Number’ there were no duplicates and the range was greater than the length of the array.
     *
     * See also {@link #findMissingNumber(int[])}
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) + O(n) = O(n)")
    @SpaceComplexity("O(n)")
    @Difficulty(type = DifficultyType.EASY)
    public static List<Integer> findAllMissingNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                Utils.swapInArray(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }
}
