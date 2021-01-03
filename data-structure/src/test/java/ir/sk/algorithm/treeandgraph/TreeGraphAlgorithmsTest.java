package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeGraphAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createMinimalBSTByOrderedArray() {
    }

    @Test
    public void checkValidBSTByInorder() {
    }

    @Test
    public void checkValidBSTByBoundaries() {
    }

    @Test
    public void hasPathByDFS() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        boolean result = TreeGraphAlgorithms.hasPathByDFS(root, 10, 0);
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
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        TreeGraphAlgorithms.allPathByDFS(root, 10, 0, currentPath, allPaths);
        System.out.println(allPaths);
    }
}