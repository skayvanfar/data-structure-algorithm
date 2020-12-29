package ir.sk.algorithm;

import ir.sk.helper.*;

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
     * a method to compute all permutations of a string of unique characters.
     * Building from permutations of first n-1 characters.
     * we took all the permutations of a1 a2 a3 and added a4 into all possible locations, we would get all permutations of a1 a2 a3 a4.
     *
     * @param str
     * @return
     */
    @TimeComplexity("O(n!)")
    public static ArrayList<String> getPerms(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) { //base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first char
        String remainder = str.substring(1); // remove the first char
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    /**
     * Insert char c at index i in word
     *
     * @param word
     * @param c
     * @param i
     * @return
     */
    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    /**
     * @param str
     */
    public static void permutation(String str) {
        permutation(str, "");
    }

    /**
     * @param str
     * @param prefix
     */
    @TimeComplexity("O (n2 * n!)=O(n!)")
    private static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    /**
     * Generating permutation using Heap Algorithm (Heap’s Algorithm)
     *
     * @param array
     * @param size
     */
    @TimeComplexity("O(n!)")
    @SpaceComplexity("O(n)")
    @DivideAndConquer
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
     * @param n
     * @param elements
     * @param delimiter
     * @param <T>
     */
    public static <T> void heapPermutationIterative(int n, T[] elements, char delimiter) {

        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        printArray(elements, delimiter);

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                printArray(elements, delimiter);
                indexes[i]++;
                i = 0;
            } else {
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

    /**
     * @param str
     * @return
     */
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
     * @param str
     * @return
     */
    public static Set<String> permutation2(String str) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                result.add(swap(str, i, j));
            }
        }
        return result;
    }

    private static String swap(String str, int a, int b) {
        if (a == b) return str;
        else if (a < b) {
            String first = str.substring(0, a) + str.substring(a + 1, b + 1);
            String second = str.charAt(a) + str.substring(b + 1);
            return first + second;
        } else {
            String first = str.substring(0, b + 1);
            String second = str.charAt(a) + str.substring(b+1, a) + str.substring(a+1);
            return first + second;
        }

    }
}