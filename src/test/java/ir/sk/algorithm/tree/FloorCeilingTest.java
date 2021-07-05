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

    @Test
    public void ceilingInSortedArrayBinarySearch() {
        int arr[] = {1, 2, 8, 10, 10, 12, 19};
        int n = arr.length;
        int x = 8;
        int index = FloorCeiling.ceilingInSortedArrayBinarySearch(arr, 0, n-1, x);
        if(index == -1)
            System.out.println("Ceiling of "+x+" doesn't exist in array");
        else
            System.out.println("ceiling of "+x+" is "+arr[index]);
    }

    @Test
    public void ceilOfBST() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        for (int i = 0; i < 16; i++) {
            System.out.println(i + " " + FloorCeiling.ceilOfBST(root, i));
        }
    }

    @Test
    public void floorOfBST() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        for (int i = 0; i < 16; i++) {
            System.out.println(i + " " + FloorCeiling.floorOfBST(root, i));
        }
    }
}