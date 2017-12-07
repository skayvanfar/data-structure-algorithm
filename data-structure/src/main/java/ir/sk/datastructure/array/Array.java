package ir.sk.datastructure.array;

/**
 * Unordered array data structure like Set in java. Duplicate isn't allowed.
 * When duplicate is allowed, It's like ArrayList in java
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Array<T> {

    private Object[] a;                     // ref to array a
    private int num;                        // number of data items

    public Array(int max) {
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

    public void insert(T value) {           // put element into array
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

    public void display() {                 // displays array contents
        for(int j=0; j<num; j++)            // for each element,
            System.out.print(a[j] + " ");   // display it
        System.out.println("");
    }
}
