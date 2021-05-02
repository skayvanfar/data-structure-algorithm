package ir.sk.algorithm.array;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.HashingIndexPattern;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.technique.BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
 *
 * <p>
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class PairsWithGivenSum {

    /***************
     * find all pairs with sum k within an array (assuming all distinct elements)
     ***************/

    /**
     * A simple solution is be traverse each element and check if there’s another number in the array which can be added to it to give sum.
     */
    @BruteForce
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @MultipleLoopsPattern
    public static int getPairsCountWithSum(int[] arr, int sum) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == sum)
                    count++;

        return count;
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
    public static int countPairSumBinarySort(int[] input, int targetValue) {
        int count = 0;
        for (int i = 0; i < input.length; i++)
            if (Arrays.binarySearch(input, targetValue - input[i]) != 1)
                count++;
        return count;
    }

    /**
     * Given a sorted array of integers, we need to see if there are two numbers in it such that their sum is equal to a specific value.
     * <p>
     * You can keep variables that point to different parts of an array.
     * Having multiple pointers helps to avoid O(n²) time complexity if for example you wanted to calculate a target sum from a pair of numbers in a sorted array.
     * You can have a pointer at the beginning of the array and at the end of the array and you would move the pointers on every iteration. This would reduce the time complexity to O(n).
     * <p>
     * point: array must be SORTED to work
     *
     * @param input
     * @param targetValue
     * @return
     */
    @MultiplePointerPattern
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int countPairSumTwoPointers(int[] input, int targetValue) {
        int count = 0;
        int pointerOne = 0;
        int pointerTwo = input.length - 1;

        while (pointerOne < pointerTwo) {
            int sum = input[pointerOne] + input[pointerTwo];

            if (sum == targetValue)
                count++;
            else if (sum < targetValue)
                pointerOne++;
            else
                pointerTwo--;
        }

        return count;
    }

    /**
     * for every element check if it can be combined with any other element (other than itself!) to give the desired sum
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n + k)")
    @Point("Using hashtable is trade off between time and space" +
            "change Multiply O(n)*O(n) into O(n)+O(n) by using hashtable")
    @HashingIndexPattern
    public static int getPairsCountByHashing(int[] arr, int sum) {

        int count = 0;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        // for negative numbers
        int range = max - min + 1;

        @Point("When you want to use array as hashtable use like below")
        boolean[] counting = new boolean[range];

        // O(n)
        for (int i = 0; i < arr.length; i++)
            counting[arr[i] - min] = true;

        // O(n)
        for (int i = 0; i < arr.length; i++) {
            int value = sum - arr[i];
            // O(1)
            if (counting[value - min] && value > arr[i])
                count++;
        }

        return count;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Returns the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}.
     *
     * @param a the array of integers
     * @return the number of triples (i, j, k) with {@code i < j < k}
     * such that {@code a[i] + a[j] + a[k] == 0}
     */
    @TimeComplexity("O(n^3)")
    @SpaceComplexity("O(1)")
    @BruteForce
    public static int countOfThreeSum(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Count triples that sum to 0.
     *
     * A pair a[i] and a[j] is part of a triple
     * that sums to 0 if and only if the value -(a[i] + a[j]) is in the array
     */
    @TimeComplexity("O(n^2 Log n)")
    @SpaceComplexity("O(1)")
    public static int countOfThreeSumBinarySearch(int[] a, int sum) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (Arrays.binarySearch(a, sum - a[i] - a[j]) > j)
                    cnt++;
        return cnt;
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
     * taking one number at a time. Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0.
     * At this stage, our problem translates into finding a pair whose sum is equal to “-Y−Z” (as from the above equation Y + Z == -X).
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
    @Difficulty(type = DifficultyType.MEDIUM)
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
    private static void searchPair(int[] array, int targetSum, int left, List<List<Integer>> triplets) {
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
    @Difficulty(type = DifficultyType.MEDIUM)
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
    @Difficulty(type = DifficultyType.MEDIUM)
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
    @Difficulty(type = DifficultyType.MEDIUM)
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
     * <p>
     * This problem follows the Two Pointers pattern and shares similarities with Triplet Sum to Zero.
     * <p>
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
    @Difficulty(type = DifficultyType.MEDIUM)
    public static List<List<Integer>> searchQuadrupletsSumNumber(int[] array, int target) {
        Arrays.sort(array);
        @Point("skip")
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
