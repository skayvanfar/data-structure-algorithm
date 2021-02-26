package ir.sk.algorithm;

import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.Point;
import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BinarySearch;
import ir.sk.helper.technique.DecreaseAndConquer;

/**
 * Searching Algorithms are designed to check for an element or retrieve an element from any data structure where it is stored.
 * Based on the type of search operation, these algorithms are generally classified into two categories:
 *
 * Sequential Search: In this, the list or array is traversed sequentially and every element is checked. For example: Linear Search.
 * Interval Search: These algorithms are specifically designed for searching in sorted data-structures.
 * These type of searching algorithms are much more efficient than Linear Search as they repeatedly target the center of the search structure and divide the search space in half. For Example: Binary Search.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Search {

    /**
     * Given an array arr[] of n elements, write a function to search a given element searchKey in array[].
     *
     * Start from the leftmost element of arr[] and one by one compare x with each element of arr[]
     * If element matches with an element, return the index.
     * If element doesn’t match with any of elements, return -1.
     *
     * @param array
     * @param searchKey
     * @return index of the element
     */
    @TimeComplexity("O(n)")
    public static int linerSearch(int array[], int searchKey) {
        for (int i = 0; i < array.length; i++) { // interval [left, right)
            if (array[i] == searchKey)
                return i;
        }
        return -1;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        int high = array.length - 1; // interval [left, right]
        while (low <= high) { // It should be terminated when the search interval is empty, [2, 2] this The interval is not empty
            @Point("int mid = low + (high-low) / 2, Too large a direct addition causes an overflow.")
            int mid = (low + high) / 2;
            if (key == array[mid])
                return mid;
            else if (key < array[mid])
                high = mid + 1; // Because mid has already been searched, it should be removed from the search interval.
            else
                low = mid + 1; // Because mid has already been searched, it should be removed from the search interval.
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

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given a sorted array and a target number.
     * Return the index of the first target number in the array if it exists, otherwise return -1.
     *
     * @param array
     * @param target
     * @return
     */
    public static int leftBoundBinarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        // search interval is [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                // search interval is [mid+1, right]
                left = mid + 1;
            } else if (array[mid] > target) {
                // search interval is [left, mid-1]
                right = mid - 1;
            } else if (array[mid] == target) {
                // shrink right border
                right = mid - 1;
            }
        }
        // check out of bounds
        if (left >= array.length || array[left] != target)
            return -1;
        return left;
    }
}
