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
                new GeneralTree<>(7,
                        new GeneralTree<>(19,
                                new GeneralTree<>(1),
                                new GeneralTree<>(12),
                                new GeneralTree<>(31)),
                        new GeneralTree<>(21),
                        new GeneralTree<>(14,
                                new GeneralTree<>(23),
                                new GeneralTree<>(6)));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void traverseDFSRecursive() {
        generalTree.traverseDFSRecursive(generalTree.getRoot());
    }

    @Test
    public void traverseLevelOrder() {
        generalTree.traverseDFSRecursive(generalTree.getRoot());
    }
}