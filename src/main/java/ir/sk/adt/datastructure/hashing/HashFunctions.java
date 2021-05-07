package ir.sk.adt.datastructure.hashing;

import ir.sk.helper.Remainder;

/**
 * for (n = tableSize) transform key into 0, 1, 2, ..., n-1
 *
 * if a.equals(b) is true, then a.hashCode() must have
 * the same numerical value as b.hashCode(). Conversely, if the hashCode() values are
 * different, then we know that the objects are not equal. If the hashCode() values are
 * the same, the objects may or may not be equal, and we must use equals() to decide
 * which condition holds.
 *
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
