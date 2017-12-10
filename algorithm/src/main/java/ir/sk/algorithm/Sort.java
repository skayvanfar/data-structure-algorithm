package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Sort {

    /**
     * compare and swap
     * @param array
     */
    public static void bubbleSort(int [] array) {
        int n = array.length;
        for(int out = 0; out < n; out++){
            for(int in = 1; in < (n - out); in++)
                if(array[in - 1] > array[in])
                    array[in] = swap(array[in - 1], array[in - 1] = array[in]); // swap them A[j], A[j - 1]
        }
    }


    /**
     * compare and swap
     * The selection sort performs the same number of comparisons as the bubble sort.
     * but lower swap
     *
     * @param array
     */
    public static void selectionSort(int [] array) {
        int out, in, min;
        for(out = 0; out < array.length - 1; out++) { // outer loop
            min = out; // minimum
            for(in = out + 1; in < array.length; in++) // inner loop
                if(array[in] < array[min]) // if min greater,
                    min = in; // we have a new min
            array[out] = swap(array[min], array[min] = array[out]); // swap them
        } // end for(out)
    }

    /**
     * compare and copy
     * twice faster than bubble sort and faster than selection sort
     * @param array
     */
    public static void insertionSort(int [] array) {
        int in, out;
        for(out=1; out<array.length; out++) // out is dividing line
        {
            int temp = array[out]; // remove marked item
            in = out; // start shifts at out
            while(in>0 && array[in-1] >= temp) { // until one is smaller,
                array[in] = array[in-1]; // shift item right,
                    --in; // go left one position
            }
            array[in] = temp; // insert marked item
        } // end for
    }

    static <T> T swap(T... args) {   // usage: z = swap(a, a=b, b=c, ... y=z);
        return args[0];
    }
}
