package ir.sk.algorithm.treeandgraph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by sad.kayvanfar on 1/3/2021.
 */
public class LevelByLevelBFSTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void levelByLevelBFS() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        List<List<Integer>> result = LevelByLevelBFS.levelByLevelBFS(root);
        System.out.println(result);
    }

    @Test
    public void levelByLevelBFSReverse() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        List<List<Integer>> result = LevelByLevelBFS.levelByLevelBFSReverse(root);
        System.out.println(result);
    }

    @Test
    public void levelByLevelBFSZigzag() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        List<List<Integer>> result = LevelByLevelBFS.levelByLevelBFSZigzag(root);
        System.out.println(result);
    }


    @Test
    public void levelByLevelBFSAverage() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        List<Double> result = LevelByLevelBFS.levelByLevelBFSAverage(root);
        System.out.println(result);
    }

    @Test
    public void levelByLevelBFSMinimumDepth() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        int result = LevelByLevelBFS.levelByLevelBFSMinimumDepth(root);
        System.out.println(result);
    }

    @Test
    public void levelByLevelBFSMaximumDepth() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        int result = LevelByLevelBFS.levelByLevelBFSMaximumDepth(root);
        System.out.println(result);
    }

    @Test
    public void levelOrderSuccessorBFS() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        int result = LevelByLevelBFS.levelOrderSuccessorBFS(root, 3);
        System.out.println(result);
    }

    @Test
    public void connectLevelOrderSiblingsBFS() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        LevelByLevelBFS.connectLevelOrderSiblingsBFS(root);
        root.printLevelOrderByNextNode();
    }
}