package ir.sk.datastructure.fundamental.array;

import ir.sk.algorithm.basic.RotationShift;
import ir.sk.helper.TimeComplexity;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class SortedArray {

    private int[] array;
    private int size;

    public SortedArray(int max) {
        array = new int[max];
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * Binary Search
     *
     * @param searchKey
     * @return
     */
    @TimeComplexity("O(Log n)")
    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = size - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (array[curIn] == searchKey)
                return curIn;              // found it
            else if (lowerBound > upperBound)
                return size;             // can't find it
            else                          // divide range{
                if (array[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
        }
    }


    /**
     * put element into array
     *
     * @param value
     */
    @TimeComplexity("O(n)")
    public void insert(int value) {
        int j;
        // find where it goes
        for (j = 0; j < size; j++)
            if (array[j] > (value)) // (linear search)
                break;

        RotationShift.rightShift(array, j, size);

        array[j] = value;
        size++;
    }

    /**
     * @param value
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean delete(int value) {
        int j = find(value);
        if (j == size)
            return false;
        else {
            RotationShift.leftShift(array, j, size);

            size--;
            return true;
        }
    }

    /**
     * displays array contents
     */
    public void display() {
        for (int j = 0; j < size; j++)
            System.out.print(array[j] + " ");
        System.out.println("");
    }
}
