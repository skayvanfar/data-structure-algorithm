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
        printInorder(root);
    }

    @Test
    public void buildTreeByInOrderAndPreOrderByMap() {
        char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};

        Node root = TreeAlgorithms.buildTreeByInOrderAndPreOrderByMap(preorder, inorder);
        printInorder(root);
    }

    @Test
    public void buildTreeByInOrderAndPreOrderIterative() {
        char[] preorder = {'A', 'B', 'D', 'E', 'C', 'F'};
        char[] inorder = {'D', 'B', 'E', 'A', 'F', 'C'};

        Node root = TreeAlgorithms.buildTreeByInOrderAndPreOrderIterative(preorder, inorder);
        printInorder(root);
    }


    @Test
    public void fixBST() {
         /*   6
            / \
           10  2
          / \ / \
         1  3 7 12

        10 and 2 are swapped
        */
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);

        System.out.println("Inorder Traversal" +
                " of the original tree");

        printInorder(root);

        TreeAlgorithms.fixBST(root);

        System.out.println("\nInorder Traversal" +
                " of the fixed tree");
        printInorder(root);
    }

    /* This function is here just to test buildTree() */
    static void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.value + " ");
        printInorder(node.right);
    }

}