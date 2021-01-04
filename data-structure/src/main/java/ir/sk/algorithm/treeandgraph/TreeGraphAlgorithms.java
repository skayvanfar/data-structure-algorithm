package ir.sk.algorithm.treeandgraph;

import ir.sk.helper.Backtracking;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeGraphAlgorithms {

    /**
     * @param array
     * @return
     */
    public static TreeNode createMinimalBSTByOrderedArray(int array[]) {
        return createMinimalBSTByOrderedArray(array, 0, array.length - 1);
    }

    /**
     * Tree: Given a sorted (increasing order) array with unique integer elements, write an
     * algorithm to create a binary search tree with minimal height.
     * <p>
     * The algorithm is as follows:
     * 1. Insert into the tree the middle element of the array.
     * 2. Insert (into the left subtree) the left subarray elements.
     * 3. Insert (into the right subtree) the right subarray elements.
     * 4. Recurse.
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static TreeNode createMinimalBSTByOrderedArray(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBSTByOrderedArray(arr, start, mid - 1);
        n.right = createMinimalBSTByOrderedArray(arr, mid + 1, end);
        return n;
    }

    /**
     * We've used an Integer instead of int so that we can know when last_printed has been set to a value.
     * If you don't like the use of static variables, then you can tweak this code to use a wrapper class for the
     * integer, as shown below.
     * class Wraplnt {
     * public int value;
     * }
     */
    private static Integer lastPrinted = null;

    /*
     * Implement a function to check if a binary tree is a valid binary search tree.
     * */

    /**
     * Implement a function to check if a binary tree is a valid binary search tree.
     * In-Order Traversal
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean checkValidBSTByInorder(TreeNode n) {
        if (n == null) return true;

        // II Check I recurse left
        if (!checkValidBSTByInorder(n.left)) return false;

        // II Check current
        if (lastPrinted != null && n.value <= lastPrinted) {
            return false;
        }
        lastPrinted = n.value;

        // Check I recurse right
        if (!checkValidBSTByInorder(n.right)) return false;

        return true;
    }

    /**
     * @param n
     * @param low  bound
     * @param high bound
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean checkValidBSTByBoundaries(TreeNode n, int low, int high) {
        if (n == null) return true;

        int value = n.value;
        if (value >= low && value <= high
                && checkValidBSTByBoundaries(n.left, low, value)
                && checkValidBSTByBoundaries(n.right, value, high))
            return true;
        else
            return false;
    }

    /**
     * Given a binary tree and a number ‘S’,
     * find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
     * <p>
     * VLR
     *
     * @param node
     * @param sum
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean hasPathByDFS(TreeNode node, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && node.value == sum)
                return true;

        return hasPathByDFS(node.left, sum - node.value) || hasPathByDFS(node.right, sum - node.value);

    }

    public static List<List<Integer>> allPathByDFS(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPathByDFS(root, sum, currentPath, allPaths);
        return allPaths;
    }

    /**
     * Given a binary tree and a number ‘S’,
     * find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.     *
     *
     *  @param node
     * @param sum
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(n log n)")
    @Backtracking
    public static void allPathByDFS(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null)
            return;

        currentPath.add(node.value);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (node.left == null && node.right == null && node.value == sum)
            allPaths.add(new ArrayList<>(currentPath));
        else {
            allPathByDFS(node.left, sum - node.value, currentPath, allPaths);
            allPathByDFS(node.right, sum - node.value, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

}
