package ir.sk.algorithm.tree;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  You are given the root of a binary tree. Invert the binary tree in place. That is, all left children should become right children, and all right children should become left children.
 *
 */
public class InvertBinaryTree {

    /**
     * (1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
     * (2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
     * (3)  Swap left and right subtrees.
     *           temp = left-subtree
     *           left-subtree = right-subtree
     *           right-subtree = temp
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTreeRecursive(root.right);
        TreeNode left = invertTreeRecursive(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * Alternatively, we can solve the problem iteratively, in a manner similar to breadth-first search.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
