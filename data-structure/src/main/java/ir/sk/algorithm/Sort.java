package ir.sk.algorithm;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Sort {

    /**
     * compare and swap
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int out = 0; out < n; out++) {
            for (int in = 1; in < (n - out); in++)
                if (array[in - 1] > array[in])
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
    public static void selectionSort(int[] array) {
        int out, in, min;
        for (out = 0; out < array.length - 1; out++) { // outer loop
            min = out; // minimum
            for (in = out + 1; in < array.length; in++) // inner loop
                if (array[in] < array[min]) // if min greater,
                    min = in; // we have a new min
            array[out] = swap(array[min], array[min] = array[out]); // swap them
        } // end for(out)
    }

    /**
     * compare and copy
     * twice faster than bubble sort and faster than selection sort
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        int in, out;
        for (out = 1; out < array.length; out++) // out is dividing line
        {
            int temp = array[out]; // remove marked item
            in = out; // start shifts at out
            while (in > 0 && array[in - 1] >= temp) { // until one is smaller,
                array[in] = array[in - 1]; // shift item right,
                --in; // go left one position
            }
            array[in] = temp; // insert marked item
        } // end for
    }

    static <T> T swap(T... args) {   // usage: z = swap(a, a=b, b=c, ... y=z);
        return args[0];
    }

    public <T extends Comparable> void mergeSort(T[] array) {
        // provides workspace
        T[] workSpace = (T[]) new Object[array.length];
        recMergeSort(array, workSpace, 0, array.length-1);
    }

    private <T extends Comparable> void recMergeSort(T[] array, T[] workSpace, int lowerBound,
                              int upperBound) {
        if (lowerBound == upperBound)            // if range is 1,
            return;                              // no use sorting
        else {                                    // find midpoint
            int mid = (lowerBound + upperBound) / 2;
            // sort low half
            recMergeSort(array, workSpace, lowerBound, mid);
            // sort high half
            recMergeSort(array, workSpace, mid + 1, upperBound);
            // merge them
            merge(array, workSpace, lowerBound, mid + 1, upperBound);
        }  // end else
    }  // end recMergeSort()

    //-----------------------------------------------------------
    private <T extends Comparable> void merge(T[] array, T[] workSpace, int lowPtr,
                       int highPtr, int upperBound) {
        int j = 0;                             // workspace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;       // # of items

        while (lowPtr <= mid && highPtr <= upperBound)
            if (array[lowPtr].compareTo(array[highPtr]) < 0)
                workSpace[j++] = array[lowPtr++];
            else
                workSpace[j++] = array[highPtr++];

        while (lowPtr <= mid)
            workSpace[j++] = array[lowPtr++];

        while (highPtr <= upperBound)
            workSpace[j++] = array[highPtr++];

        for (j = 0; j < n; j++)
            array[lowerBound + j] = workSpace[j];
    }  // end merge()
}
