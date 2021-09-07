package ir.sk.algorithm.array.set;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.paradigm.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combination {

    /**
     * Input two numbers n, k, and the algorithm outputs all combinations of k numbers in [1..n].
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combinationByBacktracking(int n, int k) {
        // record "path"
        LinkedList<Integer> track = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (k <= 0 || n <= 0) return result;
        combinationByBacktracking(n, k, 1, track, result);
        return result;
    }

    /**
     * For example, input n = 4, k = 2, the output is as follows, the order does not matter, but it cannot contain duplicates (according to the definition of the combination,[1,2]and[2,1]are also duplicates):
     *
     * If you are given three 4, 2, you may follow these steps:
     * <p>
     * Fix the first number to 1;
     * Then the second number can be 2;
     * Then you can change the second number to 3;
     * Then you can change the second number to 4;
     * Then you can only change the first place,and repeat 2-5.
     * <p>
     * Path: recorded in track
     * Selection List: those elements that do not exist in track
     * End Condition: all elements appear in track
     *
     * @param n
     * @param k
     * @param start
     * @param track
     * @param result
     */
    @TimeComplexity("O(n! * n), T(n) = n * T(n-1) = n!")
    @SpaceComplexity("O(n)")
    @Backtracking
    private static void combinationByBacktracking(int n, int k, int start, LinkedList<Integer> track, List<List<Integer>> result) {
        // trigger the ending condition, reach the bottom of tree
        if (k == track.size()) {
            result.add(new LinkedList(track));
            return;
        }

        for (int i = start; i < n; i++) {
            // select
            track.add(i);
            // go to the next decision tree
            combinationByBacktracking(n, k, i + 1, track, result);
            // deselect
            track.removeLast();
        }
    }
}
