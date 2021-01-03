package ir.sk.algorithm.treeandgraph;

/**
 * Created by sad.kayvanfar on 9/19/2020.
 */
class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode parent;

    TreeNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
