package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class Utils {


    /**
     * shifting - rotation
     * <p>
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     *
     * @param array the source array.
     * @param i     starting position
     * @param j     finishing position
     */
    public static void rotate(int[] array, int i, int j) {
        int temp = array[j];
        int k = j - 1;
        while (k  >= i) {
            array[k  + 1] = array[k ];
            k--;
        }
        array[i] = temp;
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
     * @param a returned array
     * @param l first ordered array
     * @param r second ordered array
     * @param left last index of l array to compare
     * @param right last index of r array to compare
     */
    public static void twoFingerAlgorithm(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        // compares the elements of both sub-arrays one by one and places the smaller element into the input array.
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
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
