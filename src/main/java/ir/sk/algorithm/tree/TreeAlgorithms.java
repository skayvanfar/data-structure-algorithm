package ir.sk.algorithm.tree;

import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.Point;
import ir.sk.helper.RecurrenceRelation;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BacktrackingDFS;

import java.util.*;

/**
 * Created by sad.kayvanfar on 9/15/2020.
 */
public class TreeAlgorithms {

    /**
     * @param array
     * @return
     */
    public static TreeNode createBalancedBSTBySortedArray(int array[]) {
        return createBalancedBSTBySortedArray(array, 0, array.length - 1);
    }

    /**
     * Given a sorted list of numbers, change it into a balanced binary search tree.
     * You can assume there will be no duplicate numbers in the list.
     *
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
    @TimeComplexity("O(n)")
    @RecurrenceRelation("T(n) = 2T(n/2) + C")
    private static TreeNode createBalancedBSTBySortedArray(int arr[], int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createBalancedBSTBySortedArray(arr, start, mid - 1);
        n.right = createBalancedBSTBySortedArray(arr, mid + 1, end);
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Integer prevNode = null;

    /**
     * Implement a function to check if a binary tree is a valid binary search tree.
     * In-Order Traversal
     *
     * @param node
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean checkValidBSTByInorder(TreeNode node) {
        if (node == null) return true;

        // II Check I recurse left
        if (!checkValidBSTByInorder(node.left)) return false;

        // II Check current
        if (prevNode != null && node.value <= prevNode) {
            return false;
        }
        prevNode = node.value;

        // Check I recurse right
        if (!checkValidBSTByInorder(node.right)) return false;

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
    public static void makeFullBinaryTree(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root.left == null && root.right == null) {
            return;
        } else
            queue.offer(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
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
    public static Node removeHalfNodes(Node node) {
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
            Node newRoot = node.right;
            return newRoot;
        }

        /* if current nodes is a half node with right
           child NULL right, then it's right child is
           returned and replaces it in the given tree  */
        if (node.right == null) {
            Node newRoot = node.left;
            return newRoot;
        }

        return node;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public static Node buildTreeByInOrderAndPreOrder(char[] preorder, char[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTreeByInOrderAndPreOrder(preorder, inorder, new PreIndex(), 0, inorder.length - 1);
    }

    static class PreIndex {
        int value;
    }

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * Method 1
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences.
     * By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree.
     * So we know below structure now.
     * A
     * /   \
     * /       \
     * D B E     F C
     * <p>
     * A
     * /   \
     * /       \
     * B         C
     * / \        /
     * /     \    /
     * D       E  F
     * <p>
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
     * @param preIndex
     * @param inStart
     * @param inEnd
     * @return
     */
    @TimeComplexity("O(n^2)")
    @Difficulty(type = DifficultyType.MEDIUM)
    @Point("In a Preorder sequence, the leftmost element is the root of the tree.")
    private static Node buildTreeByInOrderAndPreOrder(char[] preorder, char[] inorder, PreIndex preIndex, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;

        /* Pick current node from Preorder traversal using preIndex and increment preIndex */
        Node<Character> currentNode = new Node<>(preorder[preIndex.value++]);

        /* Else find the index of this node in Inorder traversal */
        int rootPosition = findPosition(inorder, inStart, inEnd, currentNode.value);

        /* Using index in Inorder traversal, construct left and right subtrees */
        currentNode.left = buildTreeByInOrderAndPreOrder(preorder, inorder, preIndex, inStart, rootPosition - 1);
        currentNode.right = buildTreeByInOrderAndPreOrder(preorder, inorder, preIndex, rootPosition + 1, inEnd);

        return currentNode;
    }

    /**
     * Function to find index of value in arr[start...end]
     * The function assumes that value is present in in[]
     *
     * @param start
     * @param end
     * @param arr
     * @param value
     * @return
     */
    private static int findPosition(char[] arr, int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * Method 1 improved
     * We can optimize the above solution using hashing (unordered_map in C++ or HashMap in Java).
     * We store indexes of inorder traversal in a hash table. So that search can be done O(1) time.
     *
     * @param preorder
     * @param inorder
     * @return
     */
    @TimeComplexity("O(n)")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static Node buildTreeByInOrderAndPreOrderByMap(char[] preorder, char[] inorder) {
        Map<Character, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);

        return buildTreeByInOrderAndPreOrderByMap(preorder, inorder, new PreIndex(), 0, inorder.length - 1, inMap);
    }

    private static Node buildTreeByInOrderAndPreOrderByMap(char[] preorder, char[] inorder, PreIndex preIndex, int inStart, int inEnd, Map<Character, Integer> inMap) {
        if (inStart > inEnd) return null;

        Node currentNode = new Node(preorder[preIndex.value++]);
        int rootPosition = inMap.get(currentNode.value);

        currentNode.left = buildTreeByInOrderAndPreOrderByMap(preorder, inorder, preIndex, inStart, rootPosition - 1, inMap);
        currentNode.right = buildTreeByInOrderAndPreOrderByMap(preorder, inorder, preIndex, rootPosition + 1, inEnd, inMap);

        return currentNode;
    }

    /**
     * Method 2 // TODO: 2/25/21 need more attention
     * <p>
     * Use the fact that InOrder traversal is Left-Root-Right and PreOrder traversal is Root-Left-Right.
     * Also, first node in the PreOrder traversal is always the root node and the first node in the InOrder traversal is the leftmost node in the tree.
     * Maintain two data-structures : Stack (to store the path we visited while traversing PreOrder array) and Set (to maintain the node in which the next right subtree is expected).
     * <p>
     * 1. Do below until you reach the leftmost node.
     * Keep creating the nodes from PreOrder traversal
     * If the stack’s topmost element is not in the set, link the created node to the left child of stack’s topmost element (if any), without popping the element.
     * Else link the created node to the right child of stack’s topmost element. Remove the stack’s topmost element from the set and the stack.
     * Push the node to a stack.
     * <p>
     * 2. Keep popping the nodes from the stack until either the stack is empty, or the topmost element of stack compares to the current element of InOrder traversal.
     * Once the loop is over, push the last node back into the stack and into the set.
     * <p>
     * 3. Goto Step 1.
     *
     * @param preorder
     * @param inorder
     * @return
     */
    @Difficulty(type = DifficultyType.MEDIUM)
    public static Node<Character> buildTreeByInOrderAndPreOrderIterative(char[] preorder, char[] inorder) {
        Set<Node<Character>> set = new HashSet<>();
        Stack<Node<Character>> stack = new Stack<>();

        Node<Character> root = null;
        for (int pre = 0, in = 0; pre < preorder.length; ) {

            Node<Character> node = null;
            do {
                node = new Node<>(preorder[pre]);
                if (root == null)
                    root = node;

                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    } else
                        stack.peek().left = node;

                }
                stack.push(node);
            } while (preorder[pre++] != inorder[in] && pre < preorder.length);

            node = null;
            while (!stack.isEmpty() && in < inorder.length &&
                    stack.peek().value == inorder[in]) {
                node = stack.pop();
                in++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }

        return root;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static Node<Integer> first, middle, last, prev;

    /**
     * Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct) the BST.
     * Input Tree:
     * 10
     * /  \
     * 5    8
     * / \
     * 2   20
     * <p>
     * In the above tree, nodes 20 and 8 must be swapped to fix the tree.
     * Following is the output tree
     * 10
     * /  \
     * 5    20
     * / \
     * 2   8
     * <p>
     * The inorder traversal of a BST produces a sorted array.
     * So a simple method is to store inorder traversal of the input tree in an auxiliary array.
     * Sort the auxiliary array. Finally, insert the auxiliary array elements back to the BST, keeping the structure of the BST same.
     * The time complexity of this method is O(nLogn) and the auxiliary space needed is O(n).
     * <p>
     * We can solve this in O(n) time and with a single traversal of the given BST. Since inorder traversal of BST is always a sorted array,
     * the problem can be reduced to a problem where two elements of a sorted array are swapped. There are two cases that we need to handle:
     * <p>
     * We will maintain three-pointers, first, middle, and last. When we find the first point where the current node value is smaller than the previous node value,
     * we update the first with the previous node & the middle with the current node. When we find the second point where the current node value is smaller than the previous node value,
     * we update the last with the current node. In the case of #2, we will never find the second point. So, the last pointer will not be updated.
     * After processing, if the last node value is null, then two swapped nodes of BST are adjacent.
     *
     * @param root
     */
    @TimeComplexity("O(n)")
    @Difficulty(type = DifficultyType.HARD)
    public static void fixBST(Node root) {
        // Initialize pointers needed
        // for correctBSTUtil()
        first = middle = last = prev = null;

        // Set the poiters to find out
        // two nodes
        fixBSTUtil(root);

        // Fix (or correct) the tree
        if (first != null && last != null) {
            int temp = first.value;
            first.value = last.value;
            last.value = temp;
        }
        // Adjacent nodes swapped
        else if (first != null && middle !=
                null) {
            int temp = first.value;
            first.value = middle.value;
            middle.value = temp;
        }

        // else nodes have not been swapped,
        // passed tree is really BST.
    }

    /**
     * This function does inorder traversal
     * to find out the two swapped nodes.
     * It sets three pointers, first, middle
     * and last. If the swapped nodes are
     * adjacent to each other, then first
     * and middle contain the resultant nodes
     * Else, first and last contain the
     * resultant nodes
     *
     * @param currentNode
     */
    private static void fixBSTUtil(Node<Integer> currentNode) {
        if (currentNode == null)
            return;

        fixBSTUtil(currentNode.left);
        // If this node is smaller than
        // the previous node, it's
        // violating the BST rule.
        if (prev != null && currentNode.value < prev.value) {
            // If this is first violation,
            // mark these two nodes as
            // 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = currentNode;
            }

            // If this is second violation,
            // mark this node as last
            else
                last = currentNode;
        }

        // Mark this node as previous
        prev = currentNode;

        // Recur for the right subtree
        fixBSTUtil(currentNode.right);
    }

    static int maxLevel = -1;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The idea is to do Inorder traversal of given binary tree. While doing Inorder traversal,
     * we pass level of current node also. We keep track of maximum level seen so far and value of deepest node seen so far.
     * <p>
     * See also {@link #deepestNodeInBinaryTreeByReturn(Node)}
     *
     * @param treeNode
     * @param level    depth
     */
    @Difficulty(type = DifficultyType.MEDIUM)
    @BacktrackingDFS
    @TimeComplexity("O(n)")
    @Point("tree traversal and passing parameter")
    public static void deepestNodeInBinaryTreeBYParameter(Node treeNode, int level) {
        if (treeNode != null) {
            deepestNodeInBinaryTreeBYParameter(treeNode.left, ++level);
            maxLevel = Math.max(maxLevel, level);
            deepestNodeInBinaryTreeBYParameter(treeNode.right, level);
        }
    }

    /**
     * The idea here is to find the height of the given tree
     * <p>
     * See also {@link #deepestNodeInBinaryTreeBYParameter(Node, int)}
     *
     * @param treeNode
     * @return
     */
    @TimeComplexity("O(n)")
    @Difficulty(type = DifficultyType.MEDIUM)
    @Point("tree traversal and returning")
    public static int deepestNodeInBinaryTreeByReturn(Node treeNode) {
        if (treeNode == null)
            return 0;

        int left = deepestNodeInBinaryTreeByReturn(treeNode.left) + 1;
        int right = deepestNodeInBinaryTreeByReturn(treeNode.right) + 1;

        return Math.max(left, right);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * find the height of the given tree
     *
     * @param root
     * @return
     */
    @TimeComplexity("O(n)")
    @Point("tree traversal and returning")
    public static int heightOfBT(Node root) {
        if (root == null) return 0;

        int leftHt = heightOfBT(root.left);
        int rightHt = heightOfBT(root.right);

        return Math.max(leftHt, rightHt) + 1;
    }

}