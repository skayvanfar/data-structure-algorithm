package ir.sk.adt.datastructure.tree.binarytree.binarysearchtree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 7/28/2020.
 */
public class RedBlackTreeTest {

    RedBlackTree redBlackTree;

    @Before
    public void setUp() throws Exception {
        redBlackTree = new RedBlackTree();
        for (int i = 0; i < 10; i++) {
            RedBlackTree.Node node = new RedBlackTree.Node(i);
            redBlackTree.add(node);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        redBlackTree.printTree(new RedBlackTree.Node(5));
    }

    @Test
    public void deleteTree() {
    }

    @Test
    public void delete() {
    }
}