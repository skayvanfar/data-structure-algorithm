package ir.sk.datastructure.fundamental.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 7/28/2020.
 */
public class TwoThreeTreeTest {
    TwoThreeTree twoThreeTree;

    @Before
    public void setUp() throws Exception {
        twoThreeTree = new TwoThreeTree();
        for (int i = 0; i < 10; i++) {
            twoThreeTree.insert(i);
        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        twoThreeTree.bfsList();
    }

    @Test
    public void search() {
    }

    @Test
    public void remove() {
    }
}