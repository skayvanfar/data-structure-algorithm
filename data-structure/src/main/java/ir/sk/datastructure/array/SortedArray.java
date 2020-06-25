package ir.sk.datastructure.array;

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


    public void insert(int value) {// put element into array
        int j;
        for(j = 0; j < num; j++) // find where it goes
            if(a[j] > (value)) // (linear search)
                break;
        for(int k = num; k > j; k--) // move bigger ones up
            a[k] = a[k - 1];
        a[j] = value; // insert it
        num++; // increment size
    }

    public boolean delete(int value) {
        int j = find(value);
        if(j == num) // can’t find it
            return false;
        else // found it
        {
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
