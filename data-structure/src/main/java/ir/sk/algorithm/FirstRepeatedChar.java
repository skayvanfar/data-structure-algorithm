package ir.sk.algorithm;

/**
 * an algorithm for printing the first repeated character if there are duplicated elements in it.
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/5/2020.
 */
public class FirstRepeatedChar {

    /**
     * using two loops like BubbleSort, InsertionSort, SelectionSort, ...
     * Time Complexity (n^2)
     * Space Complexity (1)
     *
     * @param array
     * @return
     */
    public static char firstRepeatedCharByTwoLoops(char[] array) {
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j])
                    return ch;
            }
        }
        return '\u0000';
    }

    /**
     * using hash like CountSort, ...
     * Time Complexity (n)
     * Space Complexity (256)
     *
     * @param array
     * @return
     */
    public static char firstRepeatedCharByHash(char[] array) {
        int[] counter = new int[256];

        for (int i = 0; i < array.length; i++) {
            // using the value as key (array[i]) if the value can't be used as key we should use a hash function
            if (counter[array[i]]==1) {
                return array[i];
            } else
                counter[array[i]]++;
        }

        return '\u0000';
    }
}
