package ir.sk.algorithm;

import java.util.Arrays;
import java.util.Collections;

/**
 * A permutation of a set is a rearrangement of its elements. A set which consists of n elements has n! permutations.
 * Here n! is the factorial, which is the product of all positive integers smaller or equal to n.
 *
 * The array of integers [3,4,7] has three elements and six permutations:
 *
 * n! = 3! = 1 x 2 x 3 = 6
 *
 * Permutations: [3,4,7]; [3,7,4]; [4,7,3]; [4,3,7]; [7,3,4]; [7,4,3]
 *
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class Permutation {

    /**
     * print all permutations of a string
     * If we had the answer to P ("ab"), how could we generate P ("abc")?
     * Well, the additional letter is "c," so we can just stick c in at every possible point. That is:
     * P("abc")
     * P("abc")
     * P("abc")
     * P("abc")
     * insert "c" into all locations of all strings in P("ab")
     * insert "c" into all locations of all strings in {"ab","ba"}
     * merge({"cab", ""acb", "abc"}, {"cba", abca", bac"})
     * {"cab", "acb", "abc", "cba", "bca", bac"}
     *
     * @param elements
     * @param delimiter
     * @param <T>
     */
    public static <T> void heapGenerateRecursive(T[] elements, char delimiter) {
        heapGenerateRecursive(elements.length, elements, delimiter);
    }

    /**
     * Described recursively as a decrease and conquer method
     *
     * It's a recursive algorithm which produces all permutations by swapping one element per iteration
     *
     * @param n
     * @param elements
     * @param delimiter
     * @param <T>
     */
    public static <T> void heapGenerateRecursive(int n, T[] elements, char delimiter) {

        if(n == 1) {
            printArray(elements, delimiter);
        } else {
            for(int i = 0; i < n-1; i++) {
                heapGenerateRecursive(n - 1, elements, delimiter);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            heapGenerateRecursive(n - 1, elements, delimiter);
        }
    }

    /**
     * @param n
     * @param elements
     * @param delimiter
     * @param <T>
     */
    public static <T> void heapGenerateIterative(int n, T[] elements, char delimiter) {

        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        printArray(elements, delimiter);

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ?  0: indexes[i], i);
                printArray(elements, delimiter);
                indexes[i]++;
                i = 0;
            }
            else {
                indexes[i] = 0;
                i++;
            }
        }
    }

    /**
     * If the elements are comparable, we can generate permutations sorted by the natural order of the elements
     *
     * @param elements
     * @param delimiter
     * @param <T>
     */
    public static <T extends Comparable<T>> void printAllOrdered(T[] elements, char delimiter) {

        Arrays.sort(elements);
        boolean hasNext = true;

        while(hasNext) {
            printArray(elements, delimiter);
            int k = 0, l = 0;
            hasNext = false;
            for (int i = elements.length - 1; i > 0; i--) {
                if (elements[i].compareTo(elements[i - 1]) > 0) {
                    k = i - 1;
                    hasNext = true;
                    break;
                }
            }

            for (int i = elements.length - 1; i > k; i--) {
                if (elements[i].compareTo(elements[k]) > 0) {
                    l = i;
                    break;
                }
            }

            swap(elements, k, l);
            Collections.reverse(Arrays.asList(elements).subList(k + 1, elements.length));
        }
    }

    /**
     * If n is big, we can generate a random permutation by shuffling the array
     *
     * @param elements
     * @param delimiter
     * @param <T>
     */
    public static <T> void printRandom(T[] elements, char delimiter) {

        Collections.shuffle(Arrays.asList(elements));
        printArray(elements, delimiter);
    }

    private static <T> void swap(T[] elements, int a, int b) {

        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private static <T> void printArray(T[] elements, char delimiter) {

        String delimiterSpace = delimiter + " ";
        for(int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }

}