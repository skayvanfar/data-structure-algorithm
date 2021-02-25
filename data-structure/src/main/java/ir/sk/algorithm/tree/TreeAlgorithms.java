package ir.sk.algorithm.tree;

import ir.sk.helper.Point;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeAlgorithms {

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

    /////////////////////////////////////////////////////////////////

    /**
     * serializes the tree into a string representation. it use the pre-order traversal of the tree.
     * linked representation into array representation of tree
     *
     * @param node
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static String treeSerialization(Node<String> node) {
        if (node == null)
            return "";
        String left = treeSerialization(node.left);
        String right = treeSerialization(node.right);
        String result = node.value;
        if (!left.equals(""))
            result += ',' + left;
        if (!right.equals(""))
            result += ',' + right;

        return result;
    }

    public static Node<String> treeDeserialization(String str) {
        return treeDeserialization(str.split(","), 0);
    }

    /**
     * deserializes the string back to the original tree that it represents
     * array representation of into tree linked representation
     *
     * @param stringArray
     * @param index
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @Point("leftNodeIndex = (2*parentIndex)+1, rightNodeIndex = (2*parentIndex)+1 ")
    public static Node<String> treeDeserialization(String[] stringArray, int index) {
        if (index >= stringArray.length)
            return null;

        Node<String> stringNode = new Node<>(stringArray[index]);

        // leftNodeIndex = (2*parentIndex)+1, rightNodeIndex = (2*parentIndex)+1
        stringNode.left = treeDeserialization(stringArray, 2 * index + 1);
        stringNode.right = treeDeserialization(stringArray, 2 * index + 2);
        return stringNode;
    }
    /////////////////////////////////////////////////////////////////

    /**
     * Given a binary tree, remove the nodes in which there is only 1 child, so that the binary tree is a full binary tree.
     * So leaf nodes with no children should be kept, and nodes with 2 children should be kept as well.
     *
     * @param root
     */
    @TimeComplexity("O(n)")
    public static void makeFullBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root.left == null && root.right == null) {
            return;
        } else
            queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left == null || currentNode.right == null)
                break;
            if ((currentNode.left.left == null && currentNode.left.right != null)
                    || (currentNode.left.left != null && currentNode.left.right == null)) {
                currentNode.left = null;
            } else {
                queue.offer(currentNode.left);
            }
            if ((currentNode.right.left == null && currentNode.right.right != null)
                    || (currentNode.right.left != null && currentNode.right.right == null)) {
                currentNode.right = null;
            } else {
                queue.offer(currentNode.right);
            }
        }
    }

    /**
     * The idea is to use post-order traversal to solve this problem efficiently. We first process the left children, then right children,
     * and finally the node itself. So we form the new tree bottom up, starting from the leaves towards the root.
     * By the time we process the current node, both its left and right subtrees were already processed.
     *
     * @param node
     * @return
     */
    @TimeComplexity("O(n)")
    public static TreeNode removeHalfNodes(TreeNode node) {
        if (node == null)
            return null;

        node.left = removeHalfNodes(node.left);
        node.right = removeHalfNodes(node.right);

        if (node.left == null && node.right == null)
            return node;

        /* if current nodes is a half node with left
         child NULL left, then it's right child is
         returned and replaces it in the given tree */
        if (node.left == null) {
            TreeNode newRoot = node.right;
            return newRoot;
        }

        /* if current nodes is a half node with right
           child NULL right, then it's right child is
           returned and replaces it in the given tree  */
        if (node.right == null) {
            TreeNode newRoot = node.left;
            return newRoot;
        }

        return node;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public static Node buildTreeByInOrderAndPreOrder(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeByInOrderAndPreOrder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     *
     *   3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences.
     * By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree.
     * So we know below structure now.
     *                  A
     *                /   \
     *              /       \
     *            D B E     F C
     *
     *          A
     *        /   \
     *      /       \
     *     B         C
     *    / \        /
     *  /     \    /
     * D       E  F
     *
     * Algorithm: buildTree()
     * 1) Pick an element from Preorder. Increment a Preorder Index Variable (preIndex in below code) to pick next element in next recursive call.
     * 2) Create a new tree node tNode with the data as picked element.
     * 3) Find the picked element’s index in Inorder. Let the index be inIndex.
     * 4) Call buildTree for elements before inIndex and make the built tree as left subtree of tNode.
     * 5) Call buildTree for elements after inIndex and make the built tree as right subtree of tNode.
     * 6) return tNode
     *
     * @param preorder
     * @param inorder
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    @TimeComplexity("O(n^2)")
    private static Node buildTreeByInOrderAndPreOrder(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootPosition = findPosition(inStart, inEnd, inorder, preorder[preStart]);
        Node root = new Node(preorder[preStart]);
        root.left = buildTreeByInOrderAndPreOrder(preorder, inorder, preStart + 1, preStart + rootPosition - inStart, inStart, rootPosition - 1);

        root.right = buildTreeByInOrderAndPreOrder(preorder, inorder, preEnd - inEnd + rootPosition + 1, preEnd, rootPosition + 1, inEnd);
        return root;
    }

    private static int findPosition(int start, int end, int[] arr, int target) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * We can optimize the above solution using hashing (unordered_map in C++ or HashMap in Java).
     * We store indexes of inorder traversal in a hash table. So that search can be done O(1) time.
     *
     * @param preorder
     * @param inorder
     * @return
     */
    @TimeComplexity("O(n)")
    public static Node buildTreeByInOrderAndPreOrderByMap(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        Node root = buildTreeByInOrderAndPreOrderByMap(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    private static Node buildTreeByInOrderAndPreOrderByMap(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.value);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeByInOrderAndPreOrderByMap(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTreeByInOrderAndPreOrderByMap(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }

}