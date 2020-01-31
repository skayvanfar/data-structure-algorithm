package ir.sk.datastructure.array;

import java.util.List;

/**
 * Unordered array data structure like ArrayList in java without using index. Duplicate is allowed.
 * When duplicate is not allowed, It's like Set in java
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class UnOrderedArray<T> {

    private Object[] a;                     // ref to array a
    private int num;                        // number of data items

    public UnOrderedArray(int max) {
        a = new Object[max];                // create the array
        num = 0;                            // no items yet
    }

    public boolean find(T searchKey) {
        int j;
        for(j = 0; j < num; j++)            // for each element, Linear Search
            if(a[j] == searchKey)           // found item?
                break;                      // exit loop before end
        if(j == num)                        // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }

    /**
     * put element into array
     * @param value
     */
    public void insert(T value) {
        a[num] = value;                     // insert it
        num++;                              // increment size
    }

    public boolean delete(T value) {
        int j;
        for(j = 0; j < num; j++)            // look for it
            if(value == a[j])
                break;
        if(j == num)                        // can't find it
            return false;
        else {                              // found it
            for(int k = j; k < num; k++)    // move higher ones down
                a[k] = a[k+1];
            num--;                          // decrement size
            return true;
        }
    }

    /**
     * displays array contents
     */
    public void display() {
        for(int j=0; j<num; j++)            // for each element,
            System.out.print(a[j] + " ");   // display it
        System.out.println("");
    }
}
