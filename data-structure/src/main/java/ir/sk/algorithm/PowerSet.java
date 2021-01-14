package ir.sk.algorithm;

import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A power set of set S is the set of all possible subsets of S, including the empty set and S itself.
 * <p>
 * The powerset of {1, 2, 3} is:
 * {{}, {2}, {3}, {2, 3}, {1, 2}, {1, 3}, {1, 2, 3}, {1}}
 *
 * The total number of subsets of any given set is equal to 2^n
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
    public static <T> Set<Set<T>> powerSetRecursive(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
        for (Set<T> set : powerSetRecursive(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

    /**
     * @param set
     */
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
