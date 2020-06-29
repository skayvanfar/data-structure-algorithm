package ir.sk.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * A binary tree is a recursive data structure where each node can have 2 children at most.
 *
 * A common type of binary tree is a binary search tree, in which every node has a value that is greater than or equal
 * to the node values in the left sub-tree, and less than or equal to the node values in the right sub-tree.
 * Created by sad.keyvanfar on 6/28/2020.
 */
public class BST {

    Node root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    /**
     * First, we have to find the place where we want to add a new node in order to keep the tree sorted. We'll follow these rules starting from the root node:
     *
     * if the new node's value is lower than the current node's, we go to the left child
     * if the new node's value is greater than the current node's, we go to the right child
     * when the current node is null, we've reached a leaf node and we can insert the new node in that position
     *
     * @param current
     * @param value
     * @return
     */
    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.value) {
            return true;
        }

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
     *
     * a node has no children – this is the simplest case; we just need to replace this node with null in its parent node
     * a node has exactly one child – in the parent node, we replace this node with its only child.
     * a node has two children – this is the most complex case because it requires a tree reorganization:
     * First, we need to find the node that will replace the deleted node. We'll use the smallest node of the node to be deleted's right sub-tree
     * @param current
     * @param value
     * @return
     */
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

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

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    // Depth-First Search is a type of traversal that goes deep as much as possible in every child before exploring the next sibling.
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param node
     */
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            visit(node.value);
            traverseInOrder(node.right);
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param node
     */
    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }

    /**
     * In the recursive version, a stack is required as we need to remember the current node so that after
     * completing the left subtree we can go to the right subtree.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if(current.right != null)
                stack.push(current.right);

            if(current.left != null)
                stack.push(current.left);
        }
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            while(current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            visit(current.value);
            if(current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
    }

    /**
     * In preorder and inorder traversals, after popping the stack element we do not need to visit the
     * same vertex again. But in postorder traversal, each node is visited twice.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node prev = root;
        Node current = root;
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
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }

    /**
     * Breadth-First Search visits all the nodes of a level before going to the next level.
     *
     * This kind of traversal is also called level-order and visits all the levels of the tree starting from the root, and from left to right.
     *
     * Level order traversal is defined as follows:
     * • Visit the root.
     * • While traversing level 1, keep all the elements at level 1+1 in queue.
     * • Go to the next level and visit all the nodes at that level.
     * • Repeat this until all levels are completed.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }


    /**
     * store int values and keep a reference to each child
     */
    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

}
