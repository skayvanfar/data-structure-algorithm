package ir.sk.algorithm.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 9/19/2020.
 */
public class LowestCommonAncestorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lowestCommonAncestorForBST() {
    }

    @Test
    public void commonAncestorByParentForbt() {
    }

    @Test
    public void lCAForBT() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        LowestCommonAncestor.lCAForBT(root, 4, 5);
        System.out.println(LowestCommonAncestor.value);
    }

    @Test
    public void lCAForBTBySameSide() {
    }
}