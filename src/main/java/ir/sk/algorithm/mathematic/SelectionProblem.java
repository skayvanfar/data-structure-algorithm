package ir.sk.algorithm.mathematic;

import java.util.*;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
/**
 * a selection algorithm is an algorithm for finding the 
 * kth smallest value in a collection of ordered values, such as numbers
 * Selection includes as special cases the problems of finding the minimum, median, and maximum element in the collection
*/
public class SelectionProblem {
    
    /**
     * median = "the middle" value
     */
    @TimeComplexity("O(n Log n) as we need to sort the array first")
    public static double median(int a[]) {
        // First we sort the array
        Arrays.sort(a);

        // check for even case
        if (a.length % 2 != 0)
            return a[a.length / 2];

        return (double) (a[(a.length - 1) / 2] + a[a.length / 2]) / 2.0;
    }

    @TimeComplexity("O(n + p) = O(n)")
    @SpaceComplexity("O(p) where P is the size of auxiliary array")
    public static double medianUsingCountingSort(int[] array) {
        int n = array.length;

        int max = Arrays.stream(array).max().getAsInt();

        // Frequency Array
        int[] counting = new int[max + 1];

        // store count of each character
        for (int i = 0; i < n; i++) {
            counting[array[i]]++;
        }

        double median = 0;
        if (n % 2 == 0) {
            Integer m1 = null;
            Integer m2 = null;
            int count = 0;
            for (int j = 0; j < counting.length; j++) {
                count += counting[j];
                if (m1 == null && count >= n / 2) {
                    m1 = j;
                }
                if (m2 == null && count >= n / 2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < counting.length; j++) {
                count += counting[j];
                if (count > n / 2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }



    // partition function similar to quick sort 
    // Considers last element as pivot and adds 
    // elements with less value to the left and 
    // high value to the right and also changes 
    // the pivot position to its respective position 
    // in the final array. 
    public static int partition(int[] arr, int low, 
                                int high) 
    { 
        int pivot = arr[high], pivotloc = low; 
        for (int i = low; i <= high; i++) { 
            // inserting elements of less value 
            // to the left of the pivot location 
            if (arr[i] < pivot) { 
                int temp = arr[i]; 
                arr[i] = arr[pivotloc]; 
                arr[pivotloc] = temp; 
                pivotloc++; 
            } 
        } 
  
        // swapping pivot to the final pivot location 
        int temp = arr[high]; 
        arr[high] = arr[pivotloc]; 
        arr[pivotloc] = temp; 
  
        return pivotloc; 
    } 
  
    /**
     * QuickSelect is a selection algorithm to find the k-th smallest element in an unordered list.
     * It is related to the quick sort sorting algorithm.
    */
    // finds the kth position (of the sorted array) 
    // in a given unsorted array i.e this function 
    // can be used to find both kth largest and 
    // kth smallest element in the array. 
    // ASSUMPTION: all elements in arr[] are distinct 
    @TimeComplexity("O(n)")
    public static int kthSmallestWithQuickSelect(int[] arr, int low, 
                                  int high, int k) 
    { 
        // find the partition 
        int partition = partition(arr, low, high); 
  
        // if partition value is equal to the kth position, 
        // return value at k. 
        if (partition == k - 1) 
            return arr[partition]; 
  
        // if partition value is less than kth position, 
        // search right side of the array. 
        else if (partition < k - 1) 
            return kthSmallestWithQuickSelect(arr, partition + 1, high, k); 
  
        // if partition value is more than kth position, 
        // search left side of the array. 
        else
            return kthSmallestWithQuickSelect(arr, low, partition - 1, k); 
    } 
  
}
