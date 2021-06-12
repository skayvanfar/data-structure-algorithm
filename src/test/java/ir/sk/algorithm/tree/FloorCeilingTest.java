package ir.sk.algorithm.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 6/12/2021.
 */
public class FloorCeilingTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ceilingInSortedArray() {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int n = arr.length;
        int x = 3;
        int index = FloorCeiling.ceilingInSortedArray(arr, x);
        if(index == -1)
            System.out.println("Ceiling of "+x+" doesn't exist in array");
        else
            System.out.println("ceiling of "+x+" is "+arr[index]);
    }
}