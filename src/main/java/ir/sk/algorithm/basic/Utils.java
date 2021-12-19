package ir.sk.algorithm.basic;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Arrays;
import java.util.Random;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class Utils {


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
     * @param elements
     * @param index1
     * @param index2
     */
    @TimeComplexity("O(1)")
    public static void swapInArray(int[] elements, int index1, int index2) {
        int tmp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = tmp;
    }

    /**
     * randomPermutationGenerator
     * <p>
     * The idea is to start from the last element, swap it with a randomly selected element from the whole array (including last).
     * Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int[] shuffleByFisherYates(int[] arr) {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = arr.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i
            // o(1)
            int j = r.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            Utils.swapInArray(arr, i, j);
        }
        return arr;
    }

}
