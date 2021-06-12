package ir.sk.algorithm.tree;

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
}
