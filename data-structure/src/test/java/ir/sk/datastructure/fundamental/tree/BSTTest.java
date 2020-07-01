package ir.sk.datastructure.fundamental.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 6/28/2020.
 */
public class BSTTest {

    private BST bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST();

        bst.add(6);
        bst.add(4);
        bst.add(8);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(9);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeNotEmpty() {
        assertTrue(!bst.isEmpty());
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        assertTrue(bst.containsNode(6));
        assertTrue(bst.containsNode(4));

        assertFalse(bst.containsNode(1));
    }

    @Test
    public void givenABinaryTree_WhenAddingExistingElement_ThenElementIsNotAdded() {
        int initialSize = bst.getSize();

        assertTrue(bst.containsNode(3));
        bst.add(3);
        assertEquals(initialSize, bst.getSize());
    }

    @Test
    public void givenABinaryTree_WhenLookingForNonExistingElement_ThenReturnsFalse() {
        assertFalse(bst.containsNode(99));
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        assertTrue(bst.containsNode(9));
        bst.delete(9);
        assertFalse(bst.containsNode(9));
    }

    @Test
    public void givenABinaryTree_WhenDeletingNonExistingElement_ThenTreeDoesNotDelete() {

        int initialSize = bst.getSize();

        assertFalse(bst.containsNode(99));
        bst.delete(99);
        assertFalse(bst.containsNode(99));
        assertEquals(initialSize, bst.getSize());
    }

    @Test
    public void it_deletes_the_root() {
        int value = 12;
        BST bst = new BST();
        bst.add(value);

        assertTrue(bst.containsNode(value));
        bst.delete(value);
        assertFalse(bst.containsNode(value));
    }

    @Test
    public void givenABinaryTree_WhenTraversingInOrder_ThenPrintValues() {
        bst.traverseInOrder(bst.root);
        System.out.println();
        bst.traverseInOrderWithoutRecursion();
    }

    @Test
    public void givenABinaryTree_WhenTraversingPreOrder_ThenPrintValues() {
        bst.traversePreOrder(bst.root);
        System.out.println();
        bst.traversePreOrderWithoutRecursion();
    }

    @Test
    public void givenABinaryTree_WhenTraversingPostOrder_ThenPrintValues() {
        bst.traversePostOrder(bst.root);
        System.out.println();
        bst.traversePostOrderWithoutRecursion();
    }

    @Test
    public void givenABinaryTree_WhenTraversingLevelOrder_ThenPrintValues() {
        bst.traverseLevelOrder();
    }
}