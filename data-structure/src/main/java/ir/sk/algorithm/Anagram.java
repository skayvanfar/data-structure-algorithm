package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class Anagram {

    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void doAnagram(int newSize) {
        int limit;
        if (newSize == 1)                     // if too small,
            return;                           // go no further

        for (int j = 0; j < newSize; j++)         // for each position,
        {
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
}
