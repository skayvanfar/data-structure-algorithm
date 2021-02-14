package ir.sk.algorithm;

import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BinarySearch;
import ir.sk.helper.technique.DecreaseAndConquer;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Search {

    /**
     * @param array
     * @param searchKey
     * @return
     */
    @TimeComplexity("O(n)")
    public static int linerSearch(int array[], int searchKey) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchKey)
                return i;
        }
        return -1;
    }

    /**
     * binary search, also known as half-interval search,[1] logarithmic search,[2] or binary chop,[3] is a search algorithm
     * that finds the position of a target value within a sorted array.
     * Binary search compares the target value to the middle element of the array.
     * If they are not equal, the half in which the target cannot lie is eliminated and the search continues on the remaining half,
     * again taking the middle element to compare to the target value, and repeating this until the target value is found.
     * If the search ends with the remaining half being empty, the target is not in the array
     *
     * @param array
     * @param key
     * @return
     */
    @TimeComplexity("O(Log n)")
    @DecreaseAndConquer
    @Implementation(type = ImplementationType.Iterative)
    public static int binarySearchByLoop(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == array[mid])
                return mid;
            else if (key < array[mid])
                high = mid + 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static int binarySearchByRecursive(int array[], int key) {
        return binarySearchByRecursive(array, key, 0, array.length - 1);
    }

    /**
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(Log n)")
    @DecreaseAndConquer
    @BinarySearch
    @Implementation(type = ImplementationType.Recursive)
    @RecurrenceRelation("T(n) = T(n/2) + O(1)")
    public static int binarySearchByRecursive(int array[], int key, int low, int high) {
        if (low > high)
            return -1;
        else {
            int mid = (low + high) / 2;
            if (key == array[mid])
                return mid;
            else if (key < array[mid])
                // Tail recursive call
                return binarySearchByRecursive(array, key, low, mid - 1);
            else
                // Tail recursive call
                return binarySearchByRecursive(array, key, mid + 1, high);
        }
    }
}
