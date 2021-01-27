package ir.sk.algorithm;

import ir.sk.helper.*;
import ir.sk.helper.complexity.BCR;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;

import java.util.*;

/**
 * A permutation of a set is a rearrangement of its elements. A set which consists of n elements has n! permutations.
 * Here n! is the factorial, which is the product of all positive integers smaller or equal to n.
 * <p>
 * The array of integers [3,4,7] has three elements and six permutations:
 * <p>
 * n! = 3! = 1 x 2 x 3 = 6
 * <p>
 * Permutations: [3,4,7]; [3,7,4]; [4,7,3]; [4,3,7]; [7,3,4]; [7,4,3]
 * <p>
 * Created by sad.keyvanfar on 8/23/2020.
 */
public class Permutation {

    private final static int MAX_CHAR = 256;

    /**
     * Generating permutation using Heap Algorithm (Heap’s Algorithm)
     *
     * @param array
     * @param size
     */
    @TimeComplexity("O(n! * n), T(n) = n * T(n-1) = n!")
    @SpaceComplexity("O(n)")
    @DivideAndConquer
    @Backtracking
    public static void heapPermutationRecursive(int array[], int size) {
        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1)
            System.out.println(Arrays.toString(array));

        for (int i = 0; i < size; i++) {
            heapPermutationRecursive(array, size - 1);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1)
                swap(array, 0, size-1);
            // If size is even, swap ith
            // and (size-1)th i.e last element
            else
                swap(array, i, size-1);
        }
    }

    /**
     * @param str
     * @return
     */
    @Backtracking
    public static List<String> permutationNew(String str) {
        List<String> result = new ArrayList<>();
        if (str.length() == 1) {
            result.add(str);
            return result;
        } else {
            for (char c : str.toCharArray()) {
                List<String> subPermList = permutationNew(str.replace(c + "", ""));
                for (String substr : subPermList) {
                    result.add(c + substr);
                }
            }
            return result;
        }
    }

    /**
     * Iterative function to generate all permutations of a String in Java
     * using Collections
     *
     * @param s
     */
    public static void permutationIterative(String s) {
        // create an empty ArrayList to store (partial) permutations
        List<String> partial = new ArrayList<>();

        // initialize the list with the first character of the string
        partial.add(String.valueOf(s.charAt(0)));

        // do for every character of the specified string
        for (int i = 1; i < s.length(); i++) {
            // consider previously constructed partial permutation one by one

            // (iterate backwards to avoid ConcurrentModificationException)
            for (int j = partial.size() - 1; j >= 0 ; j--) {
                // remove current partial permutation from the ArrayList
                String str = partial.remove(j);

                // Insert next character of the specified string in all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed string in the list

                for (int k = 0; k <= str.length(); k++) {
                    // Advice: use StringBuilder for concatenation
                    partial.add(str.substring(0, k) + s.charAt(i) +
                            str.substring(k));
                }
            }
        }

        System.out.println(partial);
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

        while (hasNext) {
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

    private static void swap(int[] elements, int a, int b) {
        int tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    private static <T> void printArray(T[] elements, char delimiter) {

        String delimiterSpace = delimiter + " ";
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }


    /**
     * Check if two strings are permutation of each other
     *
     * @param str1
     * @param str2
     * @return
     */
    @TimeComplexity("O(n Log n)")
    public static boolean arePermutationUseSorting(char[] str1, char[] str2) {

        // If length of both strings is not same,
        // then they cannot be Permutation
        if (str1.length != str2.length)
            return false;

        Arrays.sort(str1);
        Arrays.sort(str2);

        // Compare sorted strings
        for (int i = 0; i < str1.length; i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

    /**
     * @param str1
     * @param str2
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(2n)=O(n)")
    @FrequencyCountingPattern
    public static boolean arePermutationByHashing(char[] str1, char[] str2) {

        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;

        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int[MAX_CHAR];
        int count2[] = new int[MAX_CHAR];

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < str1.length && i < str2.length; i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        // Compare count arrays
        for (int i = 0; i < MAX_CHAR; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }

    /**
     * check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words
     *
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(256) = O(1)")
    @BCR(bigOTime = "O(n)")
    @FrequencyCountingPattern("Using int array")
    public static boolean palindromePermutationByHashing(char[] str) {
        int[] counting = new int[MAX_CHAR];

        for (int i = 0; i < str.length; i++) {
            counting[str[i]]++;
        }

        int odd = 0;
        for (int i = 0; i < counting.length; i++) {
            if (counting[i] % 2 != 0)
                odd++;
        }

        return odd > 1 ? false : true;
    }

}