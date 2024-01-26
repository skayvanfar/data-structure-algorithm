package ir.sk.algorithm.mathematic;

import java.util.*;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

public class SelectionProblem {
    
    /**
     * median = "the middle" value
     */
    @TimeComplexity("O(n Log n) as we need to sort the array first")
    public static double median(int a[]) {
        // First we sort the array
        Arrays.sort(a);

        // check for even case
        if (a.length % 2 != 0)
            return a[a.length / 2];

        return (double) (a[(a.length - 1) / 2] + a[a.length / 2]) / 2.0;
    }

    @TimeComplexity("O(n + p) = O(n)")
    @SpaceComplexity("O(p) where P is the size of auxiliary array")
    public static double medianUsingCountingSort(int[] array) {
        int n = array.length;

        int max = Arrays.stream(array).max().getAsInt();

        // Frequency Array
        int[] counting = new int[max + 1];

        // store count of each character
        for (int i = 0; i < n; i++) {
            counting[array[i]]++;
        }

        double median = 0;
        if (n % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < counting.length; j++) {
                count += counting[j];
                if (m1 == null && count >= n / 2) {
                    m1 = j;
                }
                if (m2 == null && count >= n / 2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < counting.length; j++) {
                count += counting[j];
                if (count > n / 2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

}
