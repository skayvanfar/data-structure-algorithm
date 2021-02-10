package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/10/2021.
 */
public class DuplicateTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteDuplicates() {
        int arr[] = new int[]{2, 3, 3, 3, 6, 9, 9};
        Duplicate.deleteDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void deleteDuplicatesAndShift() {
        int arr[] = new int[]{2, 3, 3, 3, 6, 9, 9};
        Duplicate.deleteDuplicatesAndShift(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void deleteDuplicatesAll() {
        int arr[] = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        Duplicate.deleteDuplicatesAll(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

}