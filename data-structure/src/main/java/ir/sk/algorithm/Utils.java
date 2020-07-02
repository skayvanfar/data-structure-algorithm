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
        while (j >= i) {
            array[j + 1] = array[j];
            j--;
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
        return new int[]{a,b};
    }

    /**
     * swap all primitive data
     * b = swap(a, a=b);
     * usage: z = swap(a, a=b, b=c, ... y=z);
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T gSwap(T... args) {
        return args[0];
    }
}
