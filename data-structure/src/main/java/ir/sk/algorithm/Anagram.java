package ir.sk.algorithm;

import java.util.Arrays;

/**
 * an anagram of a string is another string with exactly the same quantity of each character in it, in any order
 * "Listen = Silent"
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Anagram {

    private final static int CHARACTER_RANGE= 256;

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
     *
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
     *
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
}
