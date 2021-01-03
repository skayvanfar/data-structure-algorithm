package ir.sk.algorithm.treeandgraph;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.*;

/**
 * Created by sad.kayvanfar on 1/3/2021.
 */
public class LevelByLevelBFS {
    /**
     * Given a binary tree, populate an array to represent its level-by-level traversal.
     * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
     * <p>
     * [[1],[2,3],[4,5,6,7]], 3 levels
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static List<List<Integer>> levelByLevelBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    /**
     * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order,
     * i.e., the lowest level comes first.
     * You should populate the values of all nodes in each level from left to right in separate sub-arrays.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static List<List<Integer>> levelByLevelBFSReverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // using Linkedlist
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            // append the current level at the beginning
            result.add(0, currentLevel);
        }
        return result;
    }

    /**
     * Given a binary tree, populate an array to represent its zigzag level order traversal.
     * You should populate the values of all nodes of the first level from left to right,
     * then right to left for the next level and keep alternating in the same manner for the following levels.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static List<List<Integer>> levelByLevelBFSZigzag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // add the node to the current Level based on the traverse direction
                if (!leftToRight)
                    currentLevel.add(currentNode.value);
                else
                    currentLevel.add(0, currentNode.value);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            // reverse the traversal direction
            leftToRight = !leftToRight;
            result.add(currentLevel);
        }
        return result;
    }

    /**
     * Given a binary tree, populate an array to represent the averages of all of its levels.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static List<Double> levelByLevelBFSAverage(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.value;
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(levelSum / levelSize);
        }
        return result;
    }

    /**
     * Find the minimum depth of a binary tree.
     * The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int levelByLevelBFSMinimumDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // level
        int minimumTreeDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minimumTreeDepth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // check if this is a leaf node
                if (currentNode.left == null && currentNode.right == null)
                    return minimumTreeDepth;
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

        }
        return minimumTreeDepth;
    }

    /**
     * Given a binary tree, find its maximum depth (or height).
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int levelByLevelBFSMaximumDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // level
        int minimumTreeDepth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minimumTreeDepth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

        }
        return minimumTreeDepth;
    }

    /**
     * Given a binary tree and a node, find the level order successor of the given node in the tree.
     * The level order successor is the node that appears right after the given node in the level order traversal.
     *
     * @param root
     * @param key
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int levelOrderSuccessorBFS(TreeNode root, int key) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);

            if (currentNode.value == key)
                break;
        }
        if (queue.peek() != null)
            return queue.peek().value;
        else
            return 0;
    }

    /**
     * Given a binary tree and a node, find the level order successor of the given node in the tree.
     * The level order successor is the node that appears right after the given node in the level order traversal.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void connectLevelOrderSiblingsBFS(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode previousNode = null;
            int levelSize = queue.size();

            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                if (previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);

            }
        }
    }

    /**
     * Given a binary tree, connect each node with its level order successor.
     * The last node of each level should point to the first node of the next level.
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void connectAllLevelOrderSiblingsBFS(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode previousNode = null;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                if (previousNode != null)
                    previousNode.next = currentNode;
                previousNode = currentNode;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);

            }
        }
    }

}
