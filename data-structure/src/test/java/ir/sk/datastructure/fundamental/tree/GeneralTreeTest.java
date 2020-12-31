package ir.sk.datastructure.fundamental.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class GeneralTreeTest {

    private GeneralTree<Integer> generalTree;

    @Before
    public void setUp() throws Exception {
        generalTree =
                new GeneralTree<>(1,
                        new GeneralTree<>(2,
                                new GeneralTree<>(5),
                                new GeneralTree<>(6),
                                new GeneralTree<>(7)),
                        new GeneralTree<>(3),
                        new GeneralTree<>(4,
                                new GeneralTree<>(8),
                                new GeneralTree<>(9)));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void traverseDFSTailRecursive() {
        generalTree.traverseDFSTailRecursive(generalTree.getRoot());
    }

    @Test
    public void traverseDFSHeadRecursive() {
        generalTree.traverseDFSHeadRecursive(generalTree.getRoot());
    }

    @Test
    public void traverseLevelOrder() {
        generalTree.traverseLevelOrder(generalTree.getRoot());
    }
}