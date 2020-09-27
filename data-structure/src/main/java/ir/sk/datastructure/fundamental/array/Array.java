package ir.sk.datastructure.fundamental.array;

import ir.sk.algorithm.basic.RotationShift;
import ir.sk.helper.TimeComplexity;

/**
 * Unordered array data structure like ArrayList in java without using index. Duplicate is allowed.
 * When duplicate is not allowed, It's like Set in java
 * <p>
 * Unordered arrays offer fast insertion but slow searching and deletion.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Array {

    private int[] array;                     // ref to array a
    private int size;                        // number of data items

    public Array(int max) {
        array = new int[max];                // create the array
        size = 0;                            // no items yet
    }

    /**
     * @param searchKey
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean find(int searchKey) {
        int j;
        for (j = 0; j < size; j++)            // for each element, Linear Search
            if (array[j] == searchKey)           // found item?
                break;                      // exit loop before end
        if (j == size)                        // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }

    /**
     * put element into array
     *
     * @param value
     */
    @TimeComplexity("O(1)")
    public void insert(int value) {
        array[size] = value;                     // insert it
        size++;                              // increment size
    }

    /**
     * @param index
     * @param value
     */
    @TimeComplexity("O(n)")
    public void insert(int index, int value) {
        RotationShift.rightShift(array, index, size);
        array[index] = value;
        size++;
    }

    /**
     * after delete element, move all elements after index location (shift)
     *
     * @param value
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean delete(int value) {
        int j;
        for (j = 0; j < size; j++)            // look for it
            if (value == array[j])
                break;
        if (j == size)                        // can't find it
            return false;
        else {                              // found it
            RotationShift.leftShift(array, j, size);
            return true;
        }
    }

    /**
     * displays array contents
     */
    public void display() {
        for (int j = 0; j < size; j++)            // for each element,
            System.out.print(array[j] + " ");   // display it
        System.out.println("");
    }
}
