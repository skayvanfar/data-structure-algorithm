package ir.sk.algorithm.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sad.kayvanfar on 1/4/2021.
 */
public class RootToLeafPathTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void hasPathByDFSWithSum() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        boolean result = RootToLeafPath.hasPathByDFSWithSum(root, 10);
        System.out.println(result);
    }

    @Test
    public void allPathByDFSWithSum() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        List<List<Integer>> result = RootToLeafPath.allPathByDFSWithSum(root, 10);
        System.out.println(result);
    }

    @Test
    public void allPathByDFS() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        List<List<Integer>> result = RootToLeafPath.allPathByDFS(root);
        System.out.println(result);
    }

    @Test
    public void findPathByDFSWithMaximumSum() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        List<Integer> result = RootToLeafPath.findPathByDFSWithMaximumSum(root);
        System.out.println(result);
    }

    @Test
    public void findSumOfPathNumbers() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        int result = RootToLeafPath.findSumOfPathNumbers(root);
        System.out.println(result);
    }

    @Test
    public void hasPathWithSequenceIterative() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        boolean result = RootToLeafPath.hasPathWithSequenceIterative(root, new int[]{1, 3, 6});
        System.out.println(result);
    }

    @Test
    public void hasPathWithSequenceRecursive() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));

        boolean result = RootToLeafPath.hasPathWithSequenceRecursive(root, new int[]{1, 3, 6});
        System.out.println(result);
    }

    @Test
    public void countAllPathSum() {
        TreeNode root = new TreeNode(12,
                new TreeNode(7,
                        new TreeNode(4),
                        null
                ),
                new TreeNode(1,
                        new TreeNode(10),
                        new TreeNode(5)));

        int result = RootToLeafPath.countAllPathSum(root, 11);
        System.out.println(result);
    }

    @Test
    public void findDiameter() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(7),
                                new TreeNode(8,
                                        null,
                                        new TreeNode(10))),
                        new TreeNode(6,
                                new TreeNode(9,
                                        new TreeNode(11),
                                        null),
                                null)));

        int result = RootToLeafPath.findDiameter(root);
        System.out.println("Tree Diameter: " + result);
    }

    @Test
    public void findMaximumPathSum() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(7),
                                new TreeNode(8,
                                        null,
                                        new TreeNode(10))),
                        new TreeNode(6,
                                new TreeNode(9,
                                        new TreeNode(11),
                                        null),
                                null)));

        int result = RootToLeafPath.findMaximumPathSum(root);
        System.out.println("Maximum Path Sum: " + result);
    }
}