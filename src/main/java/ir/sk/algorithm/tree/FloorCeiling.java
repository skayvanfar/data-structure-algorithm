package ir.sk.algorithm.tree;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Created by sad.kayvanfar on 6/12/2021.
 */
public class FloorCeiling {

    /**
     * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order.
     * <p>
     * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
     * For x = 0:    floor doesn't exist in array,  ceil  = 1
     * For x = 1:    floor  = 1,  ceil  = 1
     * For x = 5:    floor  = 2,  ceil  = 8
     * For x = 20:   floor  = 19,  ceil doesn't exist in array
     *
     * @param array
     */
    @TimeComplexity("O(n)")
    public static int ceilingInSortedArray(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;
        int i;

      /* If x is smaller than or equal to first
         element,then return the first element */
        if (x <= array[low])
            return low;

        /* Otherwise, linearly search for ceil value */
        for (i = low; i < high; i++) {
            if (array[i] == x)
                return i;

        /* if x lies between arr[i] and arr[i+1]
        including arr[i+1], then return arr[i+1] */
            if (array[i] < x && array[i + 1] >= x)
                return i + 1;
        }

      /* If we reach here then x is greater than the
      last element of the array,  return -1 in this case */
        return -1;

    }

    /**
     * Instead of using linear search, binary search is used here to find out the index.
     */
    @TimeComplexity("O(Log n)")
    public static int ceilingInSortedArrayBinarySearch(int arr[], int low, int high, int x) {
        int mid;

      /* If x is smaller than or equal to the
         first element, then return the first element */
        if (x <= arr[low])
            return low;

      /* If x is greater than the last
         element, then return -1 */
        if (x > arr[high])
            return -1;

      /* get the index of middle element
         of arr[low..high]*/
        mid = (low + high) / 2;  /* low + (high - low)/2 */

      /* If x is same as middle element,
         then return mid */
        if (arr[mid] == x)
            return mid;

      /* If x is greater than arr[mid], then
         either arr[mid + 1] is ceiling of x or
         ceiling lies in arr[mid+1...high] */
        else if (arr[mid] < x) {
            if (mid + 1 <= high && x <= arr[mid + 1])
                return mid + 1;
            else
                return ceilingInSortedArrayBinarySearch(arr, mid + 1, high, x);
        }

      /* If x is smaller than arr[mid],
         then either arr[mid] is ceiling of x
         or ceiling lies in arr[low...mid-1] */
        else {
            if (mid - 1 >= low && x > arr[mid - 1])
                return mid;
            else
                return ceilingInSortedArrayBinarySearch(arr, low, mid - 1, x);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Imagine we are moving down the tree, and assume we are root node.
     * The comparison yields three possibilities,
     *
     * A) Root data is equal to key. We are done, root data is ceil value.
     *
     * B) Root data < key value, certainly the ceil value can't be in left subtree.
     *    Proceed to search on right subtree as reduced problem instance.
     *
     * C) Root data > key value, the ceil value may be in left subtree.
     *    We may find a node with is larger data than key value in left subtree,
     *    if not the root itself will be ceil node.
     *
     * @param node
     * @param input
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int ceilOfBST(TreeNode node, int input) {
        if (node == null)
            return -1;

        // We found equal key
        if (node.value == input) {
            return node.value;
        }

        // If root's key is smaller,
        // ceil must be in right subtree
        if (node.value < input) {
            return ceilOfBST(node.right, input);
        }

        // Else, either left subtree or root
        // has the ceil value
        int ceil = ceilOfBST(node.left, input);

        return (ceil >= input) ? ceil : node.value;
    }
}
