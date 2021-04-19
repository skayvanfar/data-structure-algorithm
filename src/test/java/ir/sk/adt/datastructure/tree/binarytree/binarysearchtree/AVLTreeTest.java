package ir.sk.adt.datastructure.tree.binarytree.binarysearchtree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/3/2020.
 */
public class AVLTreeTest {

    AVLTree avlTree;

    @Before
    public void setUp() throws Exception {
        avlTree = new AVLTree();
        for (int i = 0; i < 10; i++)
            avlTree.insert(i);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void givenEmptyTree_whenHeightCalled_shouldReturnMinus1() {
        AVLTree tree = new AVLTree();
        Assert.assertEquals(-1, tree.height());
    }

    @Test
    public void givenEmptyTree_whenInsertCalled_heightShouldBeZero() {
        AVLTree tree = new AVLTree();
        tree.insert(1);
        Assert.assertEquals(0, tree.height());
    }

    @Test
    public void givenEmptyTree_whenInsertCalled_treeShouldBeAvl() {
        AVLTree tree = new AVLTree();
        tree.insert(1);
        Assert.assertTrue(isAVL(tree));
    }

    @Test
    public void givenSampleTree_whenInsertCalled_treeShouldBeAvl() {
        int newKey = 11;
        avlTree.insert(newKey);
        Assert.assertTrue(isAVL(avlTree));
    }

    @Test
    public void givenSampleTree_whenFindExistingKeyCalled_shouldReturnMatchedNode() {
        int existingKey = 2;
        AVLNode result = avlTree.search(existingKey);
        Assert.assertEquals(result.value, existingKey);
    }

    @Test
    public void givenSampleTree_whenFindNotExistingKeyCalled_shouldReturnNull() {
        int notExistingKey = 11;
        AVLNode result = avlTree.search(notExistingKey);
        Assert.assertNull(result);
    }

    @Test
    public void givenEmptyTree_whenDeleteCalled_treeShouldBeAvl() {
        AVLTree tree = new AVLTree();
        tree.delete(1);
        Assert.assertTrue(isAVL(tree));
    }

    @Test
    public void givenSampleTree_whenDeleteCalled_treeShouldBeAvl() {
        avlTree.delete(1);
        Assert.assertTrue(isAVL(avlTree, avlTree.getRoot()));
    }

    private boolean isAVL(AVLTree avlTree) {
        return isAVL(avlTree, avlTree.getRoot());
    }

    private boolean isAVL(AVLTree tree, AVLNode node) {
        if (node == null)
            return true;
        int balance = tree.getBalanceFactor(node);
        return (balance <= 1 && balance >= -1) && isAVL(tree, node.left) && isAVL(tree, node.right);
    }
}