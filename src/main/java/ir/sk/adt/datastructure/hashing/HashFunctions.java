package ir.sk.adt.datastructure.hashing;

import ir.sk.helper.Remainder;

/**
 * for (n = tableSize) transform key into 0, 1, 2, ..., n-1
 * Created by sad.keyvanfar on 7/6/2020.
 */
public class HashFunctions {

    /**
     * The most commonly used method for hashing integers is calledmodular hashing
     *
     * @param key
     * @param tableSize
     * @return
     */
    @Remainder
    public static int division(int key, int tableSize) {
        return key % tableSize;
    }

    /**
     * @param key
     * @param tableSize
     * @return
     */
    public static int multiplication(int key, int tableSize) {
        int k = 10;
        return (tableSize * (k * key % 1));
    }
}
