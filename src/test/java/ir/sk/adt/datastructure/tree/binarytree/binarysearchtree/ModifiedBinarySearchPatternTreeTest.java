package ir.sk.adt.datastructure.tree.binarytree.binarysearchtree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 6/28/2020.
 */
public class ModifiedBinarySearchPatternTreeTest {

    private BinarySearchTree binarySearchTree;

    @Before
    public void setUp() throws Exception {
        binarySearchTree = new BinarySearchTree();

        binarySearchTree.root = new BSTNode(4);

        binarySearchTree.add(4);
        binarySearchTree.add(2);
        binarySearchTree.add(6);
        binarySearchTree.add(1);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(7);

    }

    @After
    public void tearDown() throws Exception {
    }

    public void add() {
        binarySearchTree = new BinarySearchTree();

        binarySearchTree.root = new BSTNode(4);

        binarySearchTree.add2(2);
        binarySearchTree.add2(6);
        binarySearchTree.add2(1);
        binarySearchTree.add2(3);
        binarySearchTree.add2(5);
        binarySearchTree.add2(7);
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeNotEmpty() {
        assertTrue(!binarySearchTree.isEmpty());
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        assertTrue(binarySearchTree.containsNode(6));
        assertTrue(binarySearchTree.containsNode(4));

        assertFalse(binarySearchTree.containsNode(1));
    }

    @Test
    public void givenABinaryTree_WhenAddingExistingElement_ThenElementIsNotAdded() {
        int initialSize = binarySearchTree.getSize();

        assertTrue(binarySearchTree.containsNode(3));
        binarySearchTree.add(3);
        assertEquals(initialSize, binarySearchTree.getSize());
    }

    @Test
    public void givenABinaryTree_WhenLookingForNonExistingElement_ThenReturnsFalse() {
        assertFalse(binarySearchTree.containsNode(99));
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        assertTrue(binarySearchTree.containsNode(9));
        binarySearchTree.delete(9);
        assertFalse(binarySearchTree.containsNode(9));
    }

    @Test
    public void givenABinaryTree_WhenDeletingNonExistingElement_ThenTreeDoesNotDelete() {

        int initialSize = binarySearchTree.getSize();

        assertFalse(binarySearchTree.containsNode(99));
        binarySearchTree.delete(99);
        assertFalse(binarySearchTree.containsNode(99));
        assertEquals(initialSize, binarySearchTree.getSize());
    }

    @Test
    public void it_deletes_the_root() {
        int value = 12;
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(value);

        assertTrue(binarySearchTree.containsNode(value));
        binarySearchTree.delete(value);
        assertFalse(binarySearchTree.containsNode(value));
    }

    @Test
    public void givenABinaryTree_WhenTraversingInOrder_ThenPrintValues() {
        binarySearchTree.traverseInOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.traverseInOrderIterative();
    }

    @Test
    public void givenABinaryTree_WhenTraversingPreOrder_ThenPrintValues() {
        binarySearchTree.traversePreOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.traversePreOrderIterative();
    }

    @Test
    public void givenABinaryTree_WhenTraversingPostOrder_ThenPrintValues() {
        binarySearchTree.traversePostOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.traversePostOrderIterative();
    }

    @Test
    public void givenABinaryTree_WhenTraversingLevelOrder_ThenPrintValues() {
        binarySearchTree.traverseLevelOrder();
    }
}