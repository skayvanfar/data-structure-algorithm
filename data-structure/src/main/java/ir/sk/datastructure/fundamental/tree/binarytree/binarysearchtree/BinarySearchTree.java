package ir.sk.datastructure.fundamental.tree.binarytree.binarysearchtree;

import ir.sk.helper.BinarySearch;
import ir.sk.helper.Point;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Vanilla BST is used as basic data structure when you need O(log n) time
 * Time Complexity: O(h) where h is height of Binary Search Tree, if tree is balanced it becomes O(log n)
 * it's between ordered array and ordered list. benefit of both. binary search of ordered array and fast insert of linked list.
 * <p>
 * Binary Search Tree is Binary tree with ordering and all operation have almost O(log n) time Complexity for balanced ones.
 * A binary tree is a recursive data structure where each node can have 2 children at most.
 * <p>
 * BST Property: A common type of binary tree is a binary search tree, in which every node has a value that is greater than or equal
 * to the node values in the left sub-tree, and less than or equal to the node values in the right sub-tree.
 * <p>
 * It's usually implemented by pointers.
 * <p>
 * Main Operations: insert-delete-traverse
 * traverse: DFS(In-order,Pre-order,Post-order)-BFS
 * <p>
 * h is the maximum height of the tree
 * <p>
 * Created by sad.keyvanfar on 6/28/2020.
 */
public class BinarySearchTree {

    public BinarySearchTree() {
    }

    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    BSTNode root;

    public BSTNode getRoot() {
        return root;
    }

    /**
     *
     * @param value
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * (Binary search)
     * First, we have to find the place where we want to add a new node in order to keep the tree sorted. We'll follow these rules starting from the root node:
     * <p>
     * if the new node's value is lower than the current node's, we go to the left child
     * if the new node's value is greater than the current node's, we go to the right child
     * when the current node is null, we've reached a leaf node and we can insert the new node in that position
     *
     * @param current
     * @param value
     * @return
     */
    @TimeComplexity("O(h)")
    @BinarySearch
    private BSTNode addRecursive(BSTNode current, int value) {

        if (current == null)
            return new BSTNode(value);

        if (value < current.value)
            current.left = addRecursive(current.left, value);
        else if (value > current.value)
            current.right = addRecursive(current.right, value);

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(BSTNode current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    /**
     * @param value
     * @return
     */
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    /**
     * @param current
     * @param value
     * @return
     */
    @TimeComplexity("O(h)")
    @BinarySearch
    private boolean containsNodeRecursive(BSTNode current, int value) {
        if (current == null)
            return false;

        if (value == current.value)
            return true;

        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    /**
     * First, we have to find the node to delete
     * Once we find the node to delete, there are 3 main different cases:
     * <p>
     * a node has no children – this is the simplest case; we just need to replace this node with null in its parent node
     * a node has exactly one child – in the parent node, we replace this node with its only child.
     * a node has two children – this is the most complex case because it requires a tree reorganization:
     * First, we need to find the node that will replace the deleted node. We'll use the smallest node of the node to be deleted's right sub-tree
     * <p>
     * Then we have to find the smallest node in the right sub-tree and swap with it.
     * After this exchange the node will have one sub-tree at most and then we remove it grounded on some of the above two rules.
     * Here we have to say that it can be done analogical swap,
     * just that we get the left sub-tree and it is the biggest element
     *
     * @param current
     * @param value
     * @return
     */
    @TimeComplexity("O(h)")
    private BSTNode deleteRecursive(BSTNode current, int value) {
        if (current == null)
            return null;

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null)
                return null;

            // Case 2: only 1 child
            if (current.right == null)
                return current.left;

            if (current.left == null)
                return current.right;

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }

        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(BSTNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    /**
     * Depth-First Search is a type of traversal that goes deep as much as possible in every child before exploring the next sibling.
     * LVR
     * @param BSTNode
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    public void traverseInOrder(BSTNode BSTNode) {
        if (BSTNode != null) {
            traverseInOrder(BSTNode.left);
            visit(BSTNode.value);
            traverseInOrder(BSTNode.right);
        }
    }

    /**
     * VLR
     * @param BSTNode
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    public void traversePreOrder(BSTNode BSTNode) {
        if (BSTNode != null) {
            visit(BSTNode.value);
            traversePreOrder(BSTNode.left);
            traversePreOrder(BSTNode.right);
        }
    }

    /**
     * LRV
     * @param BSTNode
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    public void traversePostOrder(BSTNode BSTNode) {
        if (BSTNode != null) {
            traversePostOrder(BSTNode.left);
            traversePostOrder(BSTNode.right);
            visit(BSTNode.value);
        }
    }

    /**
     * In the recursive version, a stack is required as we need to remember the current node so that after
     * completing the left subtree we can go to the right subtree.
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    @Point("transform recursive into iterative approach by using Stack")
    public void traversePreOrderIterative() {
        Stack<BSTNode> stack = new Stack<>();
        BSTNode current;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    /**
     *
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    public void traverseInOrderIterative() {
        Stack<BSTNode> stack = new Stack<BSTNode>();
        BSTNode current = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            while (current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            visit(current.value);
            if (current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
    }

    /**
     * In preorder and inorder traversals, after popping the stack element we do not need to visit the
     * same vertex again. But in postorder traversal, each node is visited twice.
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(h)")
    public void traversePostOrderIterative() {
        Stack<BSTNode> stack = new Stack<BSTNode>();
        BSTNode prev = root;
        BSTNode current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null)
                    stack.push(current.right);

                if (current.left != null)
                    stack.push(current.left);

            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    /**
     * Breadth-First Search visits all the nodes of a level before going to the next level.
     * <p>
     * This kind of traversal is also called level-order and visits all the levels of the tree starting from the root, and from left to right.
     * <p>
     * Level order traversal is defined as follows:
     * • Visit the root.
     * • While traversing level 1, keep all the elements at level 1+1 in queue.
     * • Go to the next level and visit all the nodes at that level.
     * • Repeat this until all levels are completed.
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(w) w is the maximum width of the tree")
    public void traverseLevelOrder() {
        if (root == null)
            return;

        Queue<BSTNode> BSTNodes = new LinkedList<>();
        BSTNodes.add(root);

        while (!BSTNodes.isEmpty()) {

            BSTNode BSTNode = BSTNodes.remove();

            visit(BSTNode.value);

            if (BSTNode.left != null)
                BSTNodes.add(BSTNode.left);


            if (BSTNode.right != null)
                BSTNodes.add(BSTNode.right);

        }
    }

    @TimeComplexity("O(h)")
    public BSTNode search(int key) {
        BSTNode current = root;
        while (current != null) {
            if (current.value == key)
                break;

            current = current.value < key ? current.right : current.left;
        }
        return current;
    }

}

/**
 * store int values and keep a reference to each child
 */
class BSTNode {

    int value;
    BSTNode left;
    BSTNode right;

    BSTNode(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
