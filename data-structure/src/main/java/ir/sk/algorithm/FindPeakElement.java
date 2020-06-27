package ir.sk.algorithm;

/**
 * Created by sad.keyvanfar on 6/27/2020.
 */
public class FindPeakElement {

    public static int findPeak(int array[], int low, int high) {
        int mid = (low + high) / 2;
        if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1])
            return array[mid];
        else if (array[mid] < array[mid - 1])
            return findPeak(array, low, mid - 1);
        else
            return findPeak(array, mid + 1, high);
    }
}
