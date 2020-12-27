package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 12/26/2020.
 */
public class MergeTest {

    @Test
    public void mergeByTwoFinger() {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void kWayMarge() {
        int[] array1 = new int[]{1, 2, 4, 6, 9};
        int[] array2 = new int[]{3, 5, 6, 10};
        int[] array3 = new int[]{7, 8, 9, 11, 14};
        int[] result = Merge.kWayMargeNaive(array1, array2, array3);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void kWayMargeRecursive() {
        int[] array1 = new int[]{1, 2, 4, 6, 9};
        int[] array2 = new int[]{3, 5, 6, 10};
        int[] array3 = new int[]{7, 8, 9, 11, 14};
        int[] result = Merge.kWayMargeRecursive(0, 2, array1, array2, array3);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void kWayMargeNaive() {
    }

    @Test
    public void kWayMergeByHeap() {
        int[] array1 = new int[]{1, 2, 4, 6, 9};
        int[] array2 = new int[]{3, 5, 6, 10};
        int[] array3 = new int[]{7, 8, 9, 11, 14};
        int[] result = Merge.kWayMergeByHeap(array1, array2, array3);
        System.out.println(Arrays.toString(result));
    }
}