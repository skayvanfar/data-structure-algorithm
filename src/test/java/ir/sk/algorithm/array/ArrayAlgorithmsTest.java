package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loopExistsInCircularArray() {
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{1, 2, -1, 2, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 2, -1, 2}));
        System.out.println(ArrayAlgorithms.loopExistsInCircularArray(new int[]{2, 1, -1, -2}));
    }

    @Test
    public void makeSquaresSortedArray() {
        System.out.println(Arrays.toString(ArrayAlgorithms.makeSquaresSortedArray(new int[]{-2, -1, 0, 2, 3})));
    }

    @Test
    public void magicIndexNaive() {
        System.out.println(ArrayAlgorithms.magicIndexNaive(new int[]{8, 9, 2, 3, 4}));
    }

    @Test
    public void magicIndexBinarySearch() {
        System.out.println(ArrayAlgorithms.magicIndexBinarySearch(new int[]{8, 9, 2, 3, 4}));
    }

    @Test
    public void checkPossibility() {
        int[] arr = {10, 5, 11, 3};

        if (ArrayAlgorithms.checkPossibility(arr))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    @Test
    public void findSingleNumber() {
        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        int n = ar.length;
        System.out.println("Element occurring once is " + ArrayAlgorithms.findSingleNumber(ar) + " ");
    }

    @Test
    public void witnesses() {
        int ar[] = {3, 6, 3, 4, 1};
        System.out.println(ArrayAlgorithms.witnesses(ar));
    }

    @Test
    public void pushZerosToEnd() {
        int ar[] = {0, 1, 0, 3, 12};
        ArrayAlgorithms.pushZerosToEnd(ar);
        System.out.println(Arrays.toString(ar));
    }

    @Test
    public void findKthLargestBySorting() {
        int ar[] = {3, 5, 2, 4, 6, 8};
        System.out.println(ArrayAlgorithms.findKthLargestBySorting(ar, 3));
    }

    @Test
    public void findKthLargest() {
        int ar[] = {3, 5, 2, 4, 6, 8};
        System.out.println(ArrayAlgorithms.findKthLargest(ar, 3));
    }

    @Test
    public void maxProductThreeNaive() {
        int arr[] = {-10, -3, 5, 6, -20};
        int n = arr.length;

        int max = ArrayAlgorithms.maxProductThreeNaive(arr, n);

        if (max == -1) {
            System.out.println("No Triplet Exists");
        } else {
            System.out.println("Maximum product is " + max);
        }
    }

    @Test
    public void maxProductThreeBySorting() {
        int arr[] = {-10, -3, 5, 6, -20};
        int n = arr.length;

        int max = ArrayAlgorithms.maxProductThreeBySorting(arr, n);

        if (max == -1) {
            System.out.println("No Triplet Exists");
        } else {
            System.out.println("Maximum product is " + max);
        }
    }

    @Test
    public void buySellStock() {
        int arr[] = {9, 11, 8, 5, 7, 10};
        int n = arr.length;

        int max = ArrayAlgorithms.buySellStock(arr);
        System.out.println(max);
    }

    @Test
    public void maximumDifference() {
        int arr[] = {9, 11, 8, 5, 7, 10};
        int n = arr.length;

        int max = ArrayAlgorithms.maximumDifference(arr);
        System.out.println(max);
    }

    @Test
    public void minCntCharDeletionsfrequency() {
        String str = "abbbcccd";
        System.out.print(ArrayAlgorithms.minCntCharDeletionsfrequency(str.toCharArray()));
    }

    @Test
    public void addTwoArrayNumber() {
        int arr[] = {9, 2, 3};
        int arr2[] = {5, 1, 2};

        int[] array = ArrayAlgorithms.addTwoArrayNumber(arr, arr2);
        System.out.println(array);
    }

    @Test
    public void sortArrayElementsByFrequency() {
        ArrayAlgorithms.sortArrayElementsByFrequency(new int[] {7, 1, 3, 4, 7, 1, 7, 1, 4, 5, 1, 9, 3});
    }

    @Test
    public void kMaxCombinations() {
        int[] a = new int[]{1, 4, 2, 3};
        int[] b = new int[]{2, 5, 1, 6};
        int[] result = ArrayAlgorithms.kMaxCombinations(a, b);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void kMaxCombinationsBetter() {
        List<Integer> a = Arrays.asList(1, 4, 2, 3);
        List<Integer> b = Arrays.asList(2, 5, 1, 6);
        List<Integer> result = ArrayAlgorithms.kMaxCombinationsBetter(a, b);
        System.out.println(result);
    }

    @Test
    public void prefixWithKeyGreaterThanX() {
        List<Integer> a = Arrays.asList(1, 1, 2, 1, 2);
        List<String> b = Arrays.asList("abc", "bac", "ab", "abc", "ab");
        List<Integer> c = Arrays.asList(5, 1, 4, 4, 4);
        List<Integer> result = ArrayAlgorithms.prefixWithKeyGreaterThanX(a, b, c);
        System.out.println(result);
    }

    @Test
    public void prefixWithKeyGreaterThanXByTrie() {
        List<Integer> a = Arrays.asList(1, 1, 2, 1, 2);
        List<String> b = Arrays.asList("abc", "bac", "ab", "abc", "ab");
        List<Integer> c = Arrays.asList(5, 1, 4, 4, 4);
        List<Integer> result = ArrayAlgorithms.prefixWithKeyGreaterThanXByTrie(a, b, c);
        System.out.println(result);
    }

    @Test
    public void pickFromBothSides() {
        List<Integer> a = Arrays.asList(5, -2, 3 , 1, 2);
        int result = ArrayAlgorithms.pickFromBothSides(a, 3);
        System.out.println(result);
    }

    @Test
    public void coverPoints() {
        List<Integer> a = Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8);
        List<Integer> b = Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8 );
        System.out.println(ArrayAlgorithms.coverPoints(a, b));
    }

    @Test
    public void longestConsecutive() {
        int[] array = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(ArrayAlgorithms.longestConsecutive(array));
    }

    @Test
    public void countInversions() {
        int[] array = new int[] {2, 4, 1, 3, 5};
        System.out.println(ArrayAlgorithms.countInversions(array));
    }

    @Test
    public void countInversionsByMergeSort() {
        int[] array = new int[] {2, 4, 1, 3, 5};
        System.out.println(ArrayAlgorithms.countInversionsByMergeSort(array, 0, array.length - 1));
    }

    @Test
    public void exelColumnToNumber() {
        System.out.println(ArrayAlgorithms.exelColumnToNumber("A"));
    }

    @Test
    public void convertToTitleExel() {
        System.out.println(ArrayAlgorithms.convertToTitleExel(26));
    }
}