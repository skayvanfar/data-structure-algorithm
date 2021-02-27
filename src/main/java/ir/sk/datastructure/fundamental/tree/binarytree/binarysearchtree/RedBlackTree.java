package ir.sk.datastructure.fundamental.tree.binarytree.binarysearchtree;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * A Red-Black tree is essentially a different representation of a 2-3 tree.
 * Red-Black Trees are one of several self-balanced tree structures. In a Red-Black Tree, in addition to the usual Binary Tree properties, each node contains the extra property Color. This color can be either red or black, and it is used to add a set of rules, called the red-black rules, that are used for balancing the tree:
 * <p>
 * Every node is either red or black.
 * The root is always black.
 * If a node is red, its children must be black.
 * Every leaf is black.
 * Every path from the root to a leaf or a null child must contain the same number of black nodes.
 * <p>
 * Created by sad.keyvanfar on 7/28/2020.
 */
public class RedBlackTree {

    private static final int RED = 0;
    private static final int BLACK = 1;

    private static final Node nil = new Node(-1);
    private Node root = nil;

    public static class Node {

        int key = -1, color = BLACK;
        Node left = nil, right = nil, parent = nil;

        public Node(int key) {
            this.key = key;
        }
    }

    public void printTree(Node node) {
        if (node == nil)
            return;

        printTree(node.left);
        System.out.print(((node.color == RED) ? "Color: Red " : "Color: Black ") + "Key: " + node.key + " Parent: " + node.parent.key + "\n");
        printTree(node.right);
    }

    @TimeComplexity("O(Log n)")
    public Node findNode(Node findNode, Node node) {
        if (root == nil)
            return null;


        if (findNode.key < node.key) {
            if (node.left != nil)
                return findNode(findNode, node.left);

        } else if (findNode.key > node.key) {
            if (node.right != nil)
                return findNode(findNode, node.right);

        } else if (findNode.key == node.key)
            return node;

        return null;
    }

    @TimeComplexity("O(Log n)")
    public void add(Node node) {
        Node temp = root;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key < temp.key) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else
                        temp = temp.left;

                } else if (node.key >= temp.key) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;
                        break;
                    } else
                        temp = temp.right;

                }
            }
            fixTree(node);
        }
    }

    //Takes as argument the newly inserted node
    private void fixTree(Node node) {
        while (node.parent.color == RED) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    rotateLeft(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateRight(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                rotateLeft(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    private void rotateLeft(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else
                node.parent.right = node.right;

            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil)
                node.right.left.parent = node;

            node.right = node.right.left;
            node.parent.left = node;
        } else {//Need to rotate root
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    private void rotateRight(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left)
                node.parent.left = node.left;
            else
                node.parent.right = node.left;


            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil)
                node.left.right.parent = node;

            node.left = node.left.right;
            node.parent.right = node;
        } else {//Need to rotate root
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }

    void deleteTree() {
        root = nil;
    }

    //This operation doesn't care about the new Node's connections
    //with previous node's left and right. The caller has to take care
    //of that.
    private void transplant(Node target, Node with) {
        if (target.parent == nil)
            root = with;
        else if (target == target.parent.left)
            target.parent.left = with;
        else
            target.parent.right = with;
        with.parent = target.parent;
    }

    @TimeComplexity("O(Log n)")
    public boolean delete(Node z) {
        if ((z = findNode(z, root)) == null) return false;
        Node x;
        Node y = z; // temporary reference y
        int y_original_color = y.color;

        if (z.left == nil) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == nil) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = treeMinimum(z.right);
            y_original_color = y.color;
            x = y.right;
            if (y.parent == z)
                x.parent = y;
            else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (y_original_color == BLACK)
            deleteFixup(x);
        return true;
    }

    private void deleteFixup(Node x) {
        while (x != root && x.color == BLACK) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateLeft(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == BLACK && w.right.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                    continue;
                } else if (w.right.color == BLACK) {
                    w.left.color = BLACK;
                    w.color = RED;
                    rotateRight(w);
                    w = x.parent.right;
                }
                if (w.right.color == RED) {
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                Node w = x.parent.left;
                if (w.color == RED) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    rotateRight(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == BLACK && w.left.color == BLACK) {
                    w.color = RED;
                    x = x.parent;
                    continue;
                } else if (w.left.color == BLACK) {
                    w.right.color = BLACK;
                    w.color = RED;
                    rotateLeft(w);
                    w = x.parent.left;
                }
                if (w.left.color == RED) {
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK;
    }

    Node treeMinimum(Node subTreeRoot) {
        while (subTreeRoot.left != nil) {
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }
}
