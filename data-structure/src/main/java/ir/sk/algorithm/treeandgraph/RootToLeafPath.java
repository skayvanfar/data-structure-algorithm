package ir.sk.algorithm.treeandgraph;

import ir.sk.helper.Backtracking;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by sad.kayvanfar on 1/4/2021.
 */
public class RootToLeafPath {

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
    public static boolean hasPathByDFSWithSum(TreeNode node, int sum) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null && node.value == sum)
            return true;

        return hasPathByDFSWithSum(node.left, sum - node.value) || hasPathByDFSWithSum(node.right, sum - node.value);

    }

    public static List<List<Integer>> allPathByDFSWithSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPathByDFSWithSum(root, sum, currentPath, allPaths);
        return allPaths;
    }

    /**
     * Given a binary tree and a number ‘S’,
     * find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.     *
     *
     * @param node
     * @param sum
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(n log n)")
    @Backtracking
    public static void allPathByDFSWithSum(TreeNode node, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null)
            return;

        currentPath.add(node.value);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (node.left == null && node.right == null && node.value == sum)
            allPaths.add(new ArrayList<>(currentPath));
        else {
            allPathByDFSWithSum(node.left, sum - node.value, currentPath, allPaths);
            allPathByDFSWithSum(node.right, sum - node.value, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }

    public static List<List<Integer>> allPathByDFS(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        allPathByDFS(root, currentPath, allPaths);
        return allPaths;
    }

    /**
     * Given a binary tree, return all root-to-leaf paths.
     *
     * @param node
     * @param currentPath
     * @param allPaths
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(n log n)")
    @Backtracking
    private static void allPathByDFS(TreeNode node, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (node == null)
            return;

        currentPath.add(node.value);

        if (node.left == null && node.right == null)
            allPaths.add(new ArrayList<>(currentPath));

        allPathByDFS(node.left, currentPath, allPaths);
        allPathByDFS(node.right, currentPath, allPaths);

        currentPath.remove(currentPath.size() - 1);
    }

    public static List<Integer> allPathByDFSWithMaximumSum(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
        List<Integer> maxPath = new ArrayList<>();
        allPathByDFSWithMaximumSum(root, 0, currentPath, maxPath);
        return maxPath;
    }

    /**
     * Given a binary tree, find the root-to-leaf path with the maximum sum.
     *
     * @param node
     * @param currentPath
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(n log n)")
    @Backtracking
    private static void allPathByDFSWithMaximumSum(TreeNode node, int sum, List<Integer> currentPath, List<Integer> maxPath) {
        if (node == null)
            return;

        currentPath.add(node.value);
        sum += node.value;

        if (node.left == null && node.right == null) {
            int maxSum = maxPath.stream().mapToInt(a->a).sum();
            if (sum > maxSum){
                maxPath.clear();
                maxPath.addAll(currentPath);
            }
        }

        allPathByDFSWithMaximumSum(node.left, sum, currentPath, maxPath);
        allPathByDFSWithMaximumSum(node.right, sum, currentPath, maxPath);

        currentPath.remove(currentPath.size() - 1);
    }

}
