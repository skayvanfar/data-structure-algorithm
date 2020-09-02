package ir.sk.datastructure.fundamental.tree.binarytree.binarysearchtree;

import ir.sk.helper.TimeComplexity;

/**
 * AVLTree is a self-balancing binary search tree (BST).
 * A self-balancing tree is a binary search tree that balances the height after insertion and deletion according to some balancing rules.
 *
 * The balance factor of node N is height(right(N)) – height(left(N)).
 * In an AVL Tree, the balance factor of a node could be only one of 1, 0, or -1 values.
 *
 * Time Complexity: O(Log n)
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/3/2020.
 */
public class AVLTree {

    private AVLNode root;

    public AVLTree() {
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public AVLNode getRoot() {
        return root;
    }

    private void updateHeight(AVLNode n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(AVLNode n) {
        return n == null ? -1 : n.height;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    public int getBalance(AVLNode n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    @TimeComplexity("O(n)")
    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    @TimeComplexity("O(n)")
    private AVLNode rotateLeft(AVLNode y) {
        AVLNode x = y.right;
        AVLNode z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     * use the right rotation and left rotation operations in more complex combinations
     * to keep the AVL Tree balanced after any change in its nodes.
     *
     * @param z
     * @return
     */
    private AVLNode reBalance(AVLNode z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    @TimeComplexity("O(log n)")
    public AVLNode insert(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return reBalance(node);
    }

    @TimeComplexity("O(log n)")
    public AVLNode delete(AVLNode node, int key) {
        if (node == null) {
            return node;
        } else if (node.key > key) {
            node.left = delete(node.left, key);
        } else if (node.key < key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                AVLNode mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = reBalance(node);
        }
        return node;
    }

    private AVLNode mostLeftChild(AVLNode node) {
        AVLNode current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    @TimeComplexity("O(log n)")
    public AVLNode search(int key) {
        AVLNode current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }
}

class AVLNode {
    int key;
    int height;
    AVLNode left;
    AVLNode right;

    AVLNode(int key) {
        this.key = key;
    }
}
