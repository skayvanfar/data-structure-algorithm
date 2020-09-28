package ir.sk.algorithm.treeandgraph;

import ir.sk.helper.Memoization;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sad.kayvanfar on 9/14/2020.
 */
public class TreeIsBalanced {

    /**
     * @param root
     * @return
     */
    public int getHeight(TreeNode root) {
        if (root == null) return -1; // Base case
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * check if a binary tree is balanced. For the purposes of
     * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
     * node never differ by more than one.
     * <p>
     * it's not very efficient
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(nLog(n))")
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;// Base case

        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }


    /**
     * @param root
     * @param memo
     * @return
     */
    @Memoization
    public int getHeightMemo(TreeNode root, Map<TreeNode, Integer> memo) {
        if (memo.get(root) != null) return memo.get(root);
        if (root == null) return -1; // Base case
        int height = Math.max(getHeightMemo(root.left, memo), getHeightMemo(root.right, memo)) + 1;
        memo.put(root, height);
        return height;
    }

    /**
     * @param root
     * @param memo
     * @return
     */
    public boolean isBalancedMemo(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) return true;// Base case

        int heightDiff = getHeightMemo(root.left, memo) - getHeightMemo(root.right, memo);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalancedMemo(root.left, memo) && isBalancedMemo(root.right, memo);
        }
    }

    public boolean isBalancedMemo(TreeNode root) {
        return isBalancedMemo(root, new HashMap<>());
    }


    /**
     * @param root
     * @return
     */
    @TimeComplexity("O(nLog(n))")
    @SpaceComplexity("O(H) where H is the height of the tree")
    int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error -> pass it back
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    boolean isBalanced2(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

}

