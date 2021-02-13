package ir.sk.algorithm.array;

import ir.sk.algorithm.basic.Utils;
import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.InPlace;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.Stability;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 2/13/2021.
 */
public class CyclicSortPattern {

    /**
     * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
     * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
     *
     * This problem follows the Cyclic Sort pattern. Since the input array contains unique numbers from the range 0 to ‘n’,
     * we can use a similar strategy as discussed in Cyclic Sort to place the numbers on their correct index. Once we have every number in its correct place,
     * we can iterate the array to find the index which does not have the correct number, and that index will be our missing number.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) + O(n) = O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.EASY)
    public static int findMissingNumber(int[] array) {
        int i = 0;
        while (i < array.length) {
            int j = array[i];
            if (array[i] < array.length && array[i] == array[j])
                Utils.swapInArray(array, i, array[i]);
            else
                i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < array.length; i++)
            if (array[i] != i)
                return i;

        return array.length;
    }
}
