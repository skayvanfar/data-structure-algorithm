package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void treeSerialization() {
        Node<String> root = new Node("Ali",
                new Node("Vali",
                        new Node("Saeed"),
                        new Node("Reza")),
                new Node("Mehran",
                        new Node("Mohsen"),
                        new Node("Amir")));

        String result = TreeGraphAlgorithms.treeSerialization(root);
        System.out.println(result);
    }

    @Test
    public void treeDeserialization() {
        Node<String> result = TreeGraphAlgorithms.treeDeserialization("Ali,Vali,Saeed,Reza,Mehran,Mohsen,Amir");
        System.out.println(result);
    }

    @Test
    public void makeFullBinaryTree() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), null),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        TreeGraphAlgorithms.makeFullBinaryTree(root);
        System.out.println(root);
    }

    @Test
    public void removeHalfNodes() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), null),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        TreeGraphAlgorithms.removeHalfNodes(root);
        System.out.println(root);
    }
}