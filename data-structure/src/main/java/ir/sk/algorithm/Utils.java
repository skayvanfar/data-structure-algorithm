package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class Utils {


    /**
     * shifting - right rotation just one unit
     * <p>
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * @param array the source array.
     * @param startIndex     starting position
     * @param endIndex     finishing position
     */
    public static void rightRotate(int[] array, int startIndex, int endIndex) {
        int temp = array[endIndex];
        int k = endIndex - 1;
        while (k >= startIndex) {
            array[k + 1] = array[k];
            k--;
        }
        array[startIndex] = temp;
    }

    /**
     * shifting - left rotation just one unit
     * <p>
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * @param array the source array.
     * @param startIndex     starting position
     * @param endIndex     finishing position
     */
    public static void leftRotate(int[] array, int startIndex, int endIndex) {
        int temp = array[startIndex];
        int k = startIndex;
        while (k < endIndex) {
            array[k] = array[k + 1];
            k++;
        }
        array[endIndex] = temp;
    }

    /**
     * shifting - right rotation unit number
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(unit)
     *
     * @param array the source array.
     * @param startEndex     starting position
     * @param endIndex     finishing position
     * @param unit  the number of rotations
     */
    public static void rightRotate(int[] array, int startEndex, int endIndex, int unit) { // TODO: 7/14/2020 incorrect
        int m = startEndex;
        int[] temp = new int[unit];
        for (int k = endIndex + 1 - unit; k <= endIndex; k++) {
            temp[m] = array[k];
            m++;
        }

        int k = endIndex - unit;
        while (k >= startEndex) {
            array[k + unit] = array[k];
            k--;
        }
        for (int l = 0; l < unit; l++) {
            array[l] = temp[l];
        }
    }

    /**
     * shifting - left rotation unit number
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(unit)
     *
     * @param array the source array.
     * @param startIndex     starting position
     * @param endIndex     finishing position
     * @param unit  the number of rotations
     */
    public static void leftRotate(int[] array, int startIndex, int endIndex, int unit) {
        int[] temp = new int[unit];

        // move unit number from startIndex of array into a temp array
        for (int k = 0; k < unit; k++) {
            temp[k] = array[startIndex + k];
        }

        // shift other elements by unit
        int k = startIndex;
        while ((k + unit) <= endIndex) {
            array[k] = array[k + unit];
            k++;
        }

        // move all elements from temp into a latest elements array until endIndex
        for (int l = 0; l < unit; l++) {
            array[k + l] = temp[l];
        }
    }

    public static int[] leftRotateArray(int[] arr, int d){
        // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
        int n = arr.length;

        // Create new array for rotated elements:
        int[] rotated = new int[n];

        // Copy segments of shifted elements to rotated array:
        System.arraycopy(arr, d, rotated, 0, n - d);
        System.arraycopy(arr, 0, rotated, n - d, d);

        return rotated;
    }

    /**
     * @param a
     * @param b
     */
    public static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }

    /**
     * swap all primitive data
     * b = swap(a, a=b);
     * usage: z = swap(a, a=b, b=c, ... y=z);
     *
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T gSwap(T... args) {
        return args[0];
    }

    /**
     * two finger algorithm that helps us merge two sorted arrays together in one sorted array.
     * Time Complexity: O(n)
     *
     * @param a     returned array
     * @param l     first ordered array
     * @param r     second ordered array
     * @param left  last index of l array to compare
     * @param right last index of r array to compare
     */
    public static void twoFingerAlgorithm(int[] a, int[] l, int[] r, int left, int right) {

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

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param a
     */
    public static int[] reverse(int a[]) {
        int[] b = new int[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j--;
        }
        return b;
    }

    /**
     * This algorithm iterate over an array and swap elements until you reach the midpoint.
     * This is also known as reversing an array in-place because no additional buffer is used.
     * <p>
     * Time Complexity: O(n/2)=O(n)
     * Space Complexity: O(1)
     *
     * @param array
     */
    public static void inPlaceReverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * Time Complexity: O(n)
     *
     * @param str
     * @return
     */
    public static String recursiveReverse(String str) {
        if (str.length() == 1)
            return str;
        else
            return str.charAt(str.length() - 1) + recursiveReverse(str.substring(0, str.length() - 1));

    }
}
