package ir.sk.algorithm.array;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.recursiontype.HeadRecursion;
import ir.sk.helper.technique.BFS;
import ir.sk.helper.technique.BacktrackingDFS;

import java.util.*;

/**
 * A power set of set S is the set of all possible subsets of S, including the empty set and S itself.
 * <p>
 * The power set of {1, 2, 3} is:
 * {{}, {2}, {3}, {2, 3}, {1, 2}, {1, 3}, {1, 2, 3}, {1}}
 * <p>
 * The total number of subsets of any given set is equal to 2^n
 * <p>
 * all the combinations of all the different sizes, then you actually end up with the Power Set of that original set.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/14/2021.
 */
public class PowerSet {

    /**
     * @param originalSet
     * @param <T>
     * @return
     */
    @TimeComplexity("O(2^n)")
    @BacktrackingDFS
    @Difficulty(type = DifficultyType.MEDIUM)
    @Implementation(type = ImplementationType.Recursive)
    @HeadRecursion
    public static <T> Set<Set<T>> powerSetRecursive(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();
        // base case
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<T> list = new ArrayList<>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSetRecursive(rest)) {
            Set<T> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    public static void findPowerSetRecursive2(int[] s) {
        Deque<Integer> set = new ArrayDeque<>();
        findPowerSetRecursive2(s, set, s.length);
    }

    /**
     * The idea is to consider two cases for every character.
     * (i) Consider current character as part of current subset (ii) Do not consider current character as part of current subset.
     *
     * @param S
     * @param set
     * @param n
     */
    @TimeComplexity("O(2^n)")
    private static void findPowerSetRecursive2(int[] S, Deque<Integer> set, int n) {
        // if we have considered all elements
        if (n == 0) {
            System.out.println(set);
            return;
        }

        // consider the n'th element
        set.addLast(S[n - 1]);
        findPowerSetRecursive2(S, set, n - 1);

        // or don't consider the n'th element
        set.removeLast();
        findPowerSetRecursive2(S, set, n - 1);
    }

    /**
     * To generate all subsets of the given set,
     * we can use the Breadth First Search (BFS) approach.
     * We can start with an empty set, iterate through all numbers one-by-one,
     * and add them to existing sets to create new subsets.
     * <p>
     * Given set: [1, 5, 3]
     * <p>
     * Start with an empty set: [[]]
     * Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
     * Add the second number (5) to all the existing subsets: [[], [1], [5], [1,5]];
     * Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]].
     *
     * @param nums
     * @return
     */

    @TimeComplexity("O(2^n)")
    @SpaceComplexity("O(2^n)")
    @Implementation(type = ImplementationType.Iterative)
    @BFS
    public static List<List<Integer>> findSubSets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing sunsets and insert the current number in them to create new sunSets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    /**
     * Given a set of numbers that might contain duplicates, find all of its distinct subsets.
     * <p>
     * This problem follows the Subsets pattern and we can follow a similar Breadth First Search (BFS) approach.
     * The only additional thing we need to do is handle duplicates. Since the given set can have duplicate numbers,
     * if we follow the same approach discussed in Subsets, we will end up with duplicate subsets,
     * which is not acceptable. To handle this, we will do two extra things:
     * <p>
     * Sort all numbers of the given set. This will ensure that all duplicate numbers are next to each other.
     * Follow the same BFS approach but whenever we are about to process a duplicate (i.e., when the current and the previous numbers are same),
     * instead of adding the current number (which is a duplicate) to all the existing subsets,
     * only add it to the subsets which were created in the previous step.
     * todo more attention
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(2^n)")
    @SpaceComplexity("O(2^n)")
    @Implementation(type = ImplementationType.Iterative)
    @BFS
    public static List<List<Integer>> findSubsetsWithDuplicates(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;

            // if current and the previous elements are the same, create new subsets from the subsets added in the previous step
            if (i > 0 && nums[i] == nums[i - 1])
                startIndex = endIndex + 1;
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    /**
     * Another way to generate subsets is based on the bit representation of integers.
     *
     * @param set
     */
    @TimeComplexity("O(n*2^n)")
    @SpaceComplexity("O(n)")
    public static void powerSetBinary(char set[]) {
        int n = set.length;

        // Run a loop for printing all 2^n
        // subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");

            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }
}
