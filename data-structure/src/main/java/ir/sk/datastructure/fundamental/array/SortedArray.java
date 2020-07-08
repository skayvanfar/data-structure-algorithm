package ir.sk.datastructure.fundamental.array;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class SortedArray  {

    private int[] a;                 // ref to array a
    private int num;               // number of data items

    public SortedArray(int max) {
        a = new int[max];             // create array
        num = 0;
    }

    public int size() {
        return num;
    }

    /**
     * Binary Search
     *
     * Time Complexity: O(Log n)
     *
     * @param searchKey
     * @return
     */
    public int find(int searchKey) {
        int lowerBound = 0;
        int upperBound = num-1;
        int curIn;

        while(true) {
            curIn = (lowerBound + upperBound ) / 2;
            if(a[curIn] == searchKey)
                return curIn;              // found it
            else if(lowerBound > upperBound)
                return num;             // can't find it
            else                          // divide range{
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
        }  // end else divide range
    }  // end while


    /**
     * put element into array
     *
     * Time Complexity: O(n)
     *
     * @param value
     */
    public void insert(int value) {
        int j;
        // find where it goes
        for(j = 0; j < num; j++)
            if(a[j] > (value)) // (linear search)
                break;

        // Shifting
        for(int k = num; k > j; k--)
            a[k] = a[k - 1];
        a[j] = value;
        num++;
    }

    /**
     * Time Complexity: O(n)
     * @param value
     * @return
     */
    public boolean delete(int value) {
        int j = find(value);
        if(j == num) // can’t find it
            return false;
        else {
            // Shifting
            for(int k = j; k < num; k++) // move bigger ones down
                a[k] = a[k + 1];
            num--; // decrement size
            return true;
        }
    }

    /**
     * displays array contents
     */
    public void display() {
        for(int j = 0; j < num; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }
}
