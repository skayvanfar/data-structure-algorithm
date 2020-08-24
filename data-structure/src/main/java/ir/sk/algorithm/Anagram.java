package ir.sk.algorithm;

import ir.sk.helper.Point;

import java.util.Arrays;

/**
 * an anagram of a string is another string with exactly the same quantity of each character in it, in any order
 * "Listen = Silent"
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Anagram {

    private final static int CHARACTER_RANGE = 256;

    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void doAnagram(int newSize) {
        if (newSize == 1)                     // if too small,
            return;                           // go no further

        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);             // anagram remaining
            if (newSize == 2)                    // if innermost,
                displayWord();                 // display it
            rotate(newSize);                  // rotate word
        }
    }

    // rotate left all chars from position to end
    public static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char temp = arrChar[position];       // save first letter
        for (j = position + 1; j < size; j++)       // shift others left
            arrChar[j - 1] = arrChar[j];
        arrChar[j - 1] = temp;                 // put first on right
    }

    public static void displayWord() {
        if (count < 99)
            System.out.print(" ");
        if (count < 9)
            System.out.print(" ");
        System.out.print(++count + " ");
        for (int j = 0; j < size; j++)
            System.out.print(arrChar[j]);
        System.out.print("   ");
        System.out.flush();
        if (count % 6 == 0)
            System.out.println("");
    }


    /**
     * rearrange the characters of each string by sorting their characters, which will produce two normalized arrays of characters.
     * If two strings are anagrams, their normalized forms should be the same.
     * <p>
     * Time Complexity: O(nlogn) because sorting an array of n characters takes O(n log n) time.
     * Space Complexity: O(n+n)
     *
     * @param string1
     * @param string2
     * @return
     */
    public static boolean isAnagramSort(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        char[] a1 = string1.toCharArray();
        char[] a2 = string2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }

    /**
     * (like CountingSort)
     * We'll increment the counts for each character in the first string, and decrement the count for each character in the second.
     * If the two strings are anagrams,
     * then the result will be that everything balances to 0.
     * <p>
     * time complexity: O(n)
     * Space Complexity: O(CHARACTER_RANGE)
     *
     * @param string1
     * @param string2
     * @return
     */
    public static boolean isAnagramCounting(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        int count[] = new int[CHARACTER_RANGE];
        for (int i = 0; i < string1.length(); i++) {
            count[string1.charAt(i)]++;
            count[string2.charAt(i)]--;
        }
        for (int i = 0; i < CHARACTER_RANGE; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    static final int MAX = 256;

    /**
     *  time complexity to compare two count arrays is O(1)
     *  as the number of elements in them are fixed
     * @param arr1
     * @param arr2
     * @return
     */
    // This function returns true if contents
    // of arr1[] and arr2[] are same, otherwise
    // false.
    private static boolean compare(char arr1[], char arr2[]) {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    /**
     * Given a smaller strings and a bigger string b, design an algorithm to find all permutations
     * of the shorter string within the longer one. Print the location of each permutation
     * This function search for all permutations
     * of pat[] in txt[]
     *
     * time complexity: O(n)
     *
     * size is fixed which is typically true as we have maximum 256 possible characters in ASCII. The idea is to use two count arrays:
     *
     * 1) The first count array store frequencies of characters in pattern.
     * 2) The second count array stores frequencies of characters in current window of text.
     *
     * using count array window (frame)
     *
     * @param pat
     * @param txt
     */
   public static void searchAnagramsInTextByHashing(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // countP[]:  Store count of all
        // characters of pattern
        // countTW[]: Store count of current
        // window of text
        char[] countP = new char[MAX];
        char[] countTW = new char[MAX];
        for (int i = 0; i < M; i++) {
            (countP[pat.charAt(i)])++;
            (countTW[txt.charAt(i)])++;
        }

        // Traverse through remaining characters
        // of pattern
        for (int i = M; i < N; i++) {
            // Compare counts of current window
            // of text with counts of pattern[]
            if (compare(countP, countTW))
                System.out.println("Found at Index " + (i - M));

            // Add current character to current
            // window
            (countTW[txt.charAt(i)])++;

            // Remove the first character of previous
            // window
            countTW[txt.charAt(i - M)]--;
        }

        // Check for the last window in text
        if (compare(countP, countTW))
            System.out.println("Found at Index " +
                    (N - M));
    }

    /**
     *
     * using count array window (frame)
     *
     * Given the number of trailing days  and a client's total daily expenditures for a period of  days, find and print the number of times the client will receive a notification over all  days.
     *
     * For example,  and . On the first three days, they just collect spending data. At day ,
     * we have trailing expenditures of . The median is  and the day's expenditure is . Because ,
     * there will be a notice. The next day, our trailing expenditures are  and the expenditures are .
     * This is less than  so no notice will be sent. Over the period, there was one notice sent.
     *
     * time complexity: O(n * max number in the array)
     *
     * 2 thoughts that help:
     * 1.) Counting sort
     * 2.) A Queue
     *
     * @param expenditure
     * @param d
     * @return
     */
    ///////////////////////////////////////////////////////////////////////////////////////
    static int activityNotificationsByHashing(int[] expenditure, int d) {;

        int notificationCount = 0;

        @Point("using count array window (frame)")
        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }

        for (int i = d; i < expenditure.length; i++) {

            double median = getMedianByCountArray(d, data);

            if (expenditure[i] >= 2 * median) {
                notificationCount++;

            }

            data[expenditure[i]]++;
            data[expenditure[i - d]]--;

        }

        return notificationCount;

    }
    private static double getMedianByCountArray(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == null && count >= d/2) {
                    m1 = j;
                }
                if (m2 == null && count >= d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }
}
