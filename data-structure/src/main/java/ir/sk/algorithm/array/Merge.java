package ir.sk.algorithm.array;

/**
 * Created by sad.kayvanfar on 12/26/2020.
 */
public class Merge {
    public static int[] mergeByTwoFinger(int[] l, int[] r) {
        int a[] = new int[l.length + r.length];
        mergeByTwoFinger(a, l, r, l.length, r.length);
        return a;
    }

    /**
     * twoFingerAlgorithm - merge - union - binary merge
     * two finger algorithm that helps us merge two sorted arrays together in one sorted array.
     * Time Complexity: O(n)
     *
     * @param a     returned array
     * @param l     first ordered array
     * @param r     second ordered array
     * @param left  last index of l array to compare
     * @param right last index of r array to compare
     */
    public static void mergeByTwoFinger(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        // compares the elements of both sub-arrays one by one and places the smaller element into the input array.
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        // When we reach the end of one of the sub-arrays,
        // the rest of the elements from the other array are copied into the input array
        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }

    }
}
