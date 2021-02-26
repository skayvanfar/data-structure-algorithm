package ir.sk.algorithm.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeAlgorithmsTest {

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

        String result = TreeAlgorithms.treeSerialization(root);
        System.out.println(result);
    }

    @Test
    public void treeDeserialization() {
        Node<String> result = TreeAlgorithms.treeDeserialization("Ali,Vali,Saeed,Reza,Mehran,Mohsen,Amir");
        System.out.println(result);
    }

    @Test
    public void makeFullBinaryTree() {
        Node root = new Node(1,
                new Node(2,
                        new Node(4), null),
                new Node(3,
                        new Node(6),
                        new Node(7)));
        TreeAlgorithms.makeFullBinaryTree(root);
        System.out.println(root);
    }

    @Test
    public void removeHalfNodes() {
        Node root = new Node(1,
                new Node(2,
                        new Node(4), null),
                new Node(3,
                        new Node(6),
                        new Node(7)));
        TreeAlgorithms.removeHalfNodes(root);
        System.out.println(root);
    }

    @Test
    public void buildTreeByInOrderAndPreOrder() {
        char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};

        Node root = TreeAlgorithms.buildTreeByInOrderAndPreOrder(preorder, inorder);
        System.out.println();
    }

    @Test
    public void buildTreeByInOrderAndPreOrderByMap() {
        char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};

        Node root = TreeAlgorithms.buildTreeByInOrderAndPreOrderByMap(preorder, inorder);
        System.out.println();
    }

    @Test
    public void buildTreeByInOrderAndPreOrderIterative() {
        char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};

        Node root = TreeAlgorithms.buildTreeByInOrderAndPreOrderIterative(preorder, inorder);
        System.out.println();
    }
}