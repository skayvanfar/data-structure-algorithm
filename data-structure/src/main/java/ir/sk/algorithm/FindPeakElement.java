package ir.sk.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sad.keyvanfar on 6/27/2020.
 */
public class FindPeakElement {

    /**
     * to find peak element by linear traverse and iterative
     * Time complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static boolean findPeakByLoop(int array[], int low, int high) {
        // first or last element is peak element
        if (array.length == 1)
            return true;
        if (array[0] >= array[1])
            return true;
        if (array[array.length - 1] >= array[array.length - 2])
            return true;

        // check for every other element
        for (int i = 1; i < array.length - 1; i++) {
            // check if the neighbors are smaller
            if (array[i] >= array[i - 1] && array[i] >= array[i + 1])
                return true;
        }
        return false;
    }

    /**
     * to find peak element by decrease-and-conquer (Divide-and-conquer algorithm) and recursive
     * Time Complexity: O(Logn)
     * Space complexity: O(1)
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static boolean findPeakByRecursive(int array[], int low, int high) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1])
            return true;
        else if (array[mid] < array[mid - 1])
            return findPeakByRecursive(array, low, mid - 1);
        else
            return findPeakByRecursive(array, mid + 1, high);
    }

    /**
     * Time Complexity: O(mn)
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public static boolean findPeakIn2DArrayByLoop(int array[][], int low, int high) {
        // first or last element is peak element
        if (array.length == 1)
            return true;
        if (array[0][0] >= array[0][1] && array[0][0] >= array[1][0])
            return true;
        if (array[array.length - 1][array.length - 1] >= array[array.length - 1][array.length - 2]
                && array[array.length - 1][array.length - 1] >= array[array.length - 2][array.length - 1])
            return true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][0] >= array[i][1] && array[i][0] >= array[i - 1][0] && array[i][0] >= array[i + 1][0]
                        && array[i][array.length - 1] >= array[i][array.length - 2] && array[i][array.length - 1] >= array[i - 1][array.length - 1] && array[i][array.length - 1] >= array[i + 1][array.length - 1])
                    return true;
            }
        }

        // check for every other element
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // check if the neighbors are smaller
                if (array[i][j] >= array[i][j - 1] && array[i][j] >= array[i][j + 1]
                        && array[i][j] >= array[i - 1][j] && array[i][j] >= array[i + 1][j])
                    return true;
            }
        }
        return false;
    }

    /**
     * Greedy Ascent Algorithm works on the principle, that it selects a particular element to start with.
     * Then it begins traversing across the array, by selecting the neighbour with higher value.
     * If there is no neighbour with a higher value than the current element, it just returns the current element.
     * <p>
     * Time Complexity: O(mn)
     *
     * @param array
     * @param i
     * @param j
     * @return
     */
    public static int greedyAscentAlgorithmByRecursive(int[][] array, int i, int j) {
        if (i > 0 && array[i - 1][j] > array[i][j]) return greedyAscentAlgorithmByRecursive(array, i - 1, j);
        else if (i < array.length - 1 && array[i + 1][j] > array[i][j])
            return greedyAscentAlgorithmByRecursive(array, i + 1, j);
        else if (j > 0 && array[i][j - 1] > array[i][j]) return greedyAscentAlgorithmByRecursive(array, i, j - 1);
        else if (j < array.length - 1 && array[i][j + 1] > array[i][j])
            return greedyAscentAlgorithmByRecursive(array, i, j + 1);
        else return array[i][j];
    }

    /**
     * Time Complexity : O(rows * log(columns))
     * Auxiliary Space: O(columns/2) for Recursion Call Stack
     * @param array
     * @param col1
     * @param col2
     * @return
     */
    public static int decreaseAndConquerByRecursive(int[][] array, int col1, int col2) {
        int mid = (col1 + col2) / 2;
        int max = findMaxIndex(array, mid);
        if (col1 == col2)
            return array[max][mid];
        if (array[max][mid] < array[max][mid+1])
            return decreaseAndConquerByRecursive(array, mid + 1, col2);
        else if (array[max][mid] > array[max][mid-1])
            return decreaseAndConquerByRecursive(array, col1, mid + 1);
        else
            return array[max][mid];
    }

    private static int findMaxIndex(int[][] array, int col) {
        List<Integer> integers = Arrays.stream(array).map(ints -> ints[col]).collect(Collectors.toList());
        return integers.indexOf(integers.stream().max(Integer::compareTo).get());
    }

}
