package ir.sk.algorithm.tree;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BacktrackingDFS;

import java.util.ArrayList;
import java.util.List;

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
    @BacktrackingDFS
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
    @BacktrackingDFS
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

    public static List<Integer> findPathByDFSWithMaximumSum(TreeNode root) {
        List<Integer> currentPath = new ArrayList<>();
        List<Integer> maxPath = new ArrayList<>();
        findPathByDFSWithMaximumSum(root, 0, currentPath, maxPath);
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
    @BacktrackingDFS
    private static void findPathByDFSWithMaximumSum(TreeNode node, int sum, List<Integer> currentPath, List<Integer> maxPath) {
        if (node == null)
            return;

        currentPath.add(node.value);
        sum += node.value;

        if (node.left == null && node.right == null) {
            int maxSum = maxPath.stream().mapToInt(a -> a).sum();
            if (sum > maxSum) {
                maxPath.clear();
                maxPath.addAll(currentPath);
            }
        }

        findPathByDFSWithMaximumSum(node.left, sum, currentPath, maxPath);
        findPathByDFSWithMaximumSum(node.right, sum, currentPath, maxPath);

        currentPath.remove(currentPath.size() - 1);
    }

    public static int findSumOfPathNumbers(TreeNode root) {
        return findSumOfPathNumbers(root, 0);
    }

    /**
     * Given a binary tree where each node can only have a digit (0-9) value,
     * each root-to-leaf path will represent a number.
     * Find the total sum of all the numbers represented by all paths.
     *
     * @param node
     * @param pathSum
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @BacktrackingDFS
    @Point("1 * 10 + 7 => 17")
    private static int findSumOfPathNumbers(TreeNode node, int pathSum) {
        if (node == null)
            return 0;

        // 1 * 10 + 7 => 17
        pathSum = 10 * pathSum + node.value;

        if (node.left == null && node.right == null) {
            return pathSum;
        }

        return findSumOfPathNumbers(node.left, pathSum) + findSumOfPathNumbers(node.right, pathSum);
    }

    /**
     * Given a binary tree and a number sequence,
     * find if the sequence is present as a root-to-leaf path in the given tree.
     *
     * @param root
     * @param sequence
     * @return
     */
    @TimeComplexity("O(h), h is height of tree")
    @SpaceComplexity("O(1)")
    public static boolean hasPathWithSequenceIterative(TreeNode root, int[] sequence) {
        TreeNode currentNode = root;

        int i = 0;
        while (currentNode != null) {
            if (currentNode.left == null && currentNode.right == null)
                return true;

            if (currentNode.left != null && currentNode.left.value == sequence[i])
                currentNode = currentNode.left;
            else if (currentNode.right != null && currentNode.right.value == sequence[i])
                currentNode = currentNode.right;
            else
                currentNode = null;
            i++;
        }
        return false;
    }

    /**
     * Given a binary tree and a number sequence,
     * find if the sequence is present as a root-to-leaf path in the given tree.
     *
     * @param root
     * @param sequence
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean hasPathWithSequenceRecursive(TreeNode root, int[] sequence) {
        if (root == null)
            return sequence.length == 0;
        return hasPathWithSequenceRecursive(root, sequence, 0);
    }

    public static boolean hasPathWithSequenceRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {
        if (currentNode == null)
            return false;

        if (sequenceIndex >= sequence.length || currentNode.value != sequence[sequenceIndex])
            return false;

        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1)
            return true;

        return hasPathWithSequenceRecursive(currentNode.left, sequence, sequenceIndex + 1)
                || hasPathWithSequenceRecursive(currentNode.right, sequence, sequenceIndex + 1);

    }

    public static int countAllPathSum(TreeNode root, int sum) {
        List<Integer> currentPath = new ArrayList<>();
        return countAllPathSum(root, currentPath, sum);
    }

    /**
     * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
     * Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
     *
     * @param currentNode
     * @param sum
     * @return
     */
    @TimeComplexity("O(n h), where h is the height of the tree")
    @SpaceComplexity("O(n)")
    @BacktrackingDFS
    public static int countAllPathSum(TreeNode currentNode, List<Integer> currentPath, int sum) {
        if (currentNode == null)
            return 0;

        int count = 0;
        currentPath.add(currentNode.value);
        if (currentPath.stream().mapToInt(a -> a).sum() == sum)
            count = 1;
        else if (currentPath.stream().mapToInt(a -> a).sum() > sum) {
            List<Integer> list = new ArrayList<>(currentPath);
            list.remove(0);
            if (list.stream().mapToInt(a -> a).sum() == sum)
                count = 1;
        }

        count = countAllPathSum(currentNode.left, currentPath, sum) +
                countAllPathSum(currentNode.right, currentPath, sum) + count;

        currentPath.remove(currentPath.size() - 1);
        return count;
    }

}
