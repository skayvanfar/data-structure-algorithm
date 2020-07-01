package ir.sk.datastructure.fundamental.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * General Tree
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class GeneralTree<T> {

    private  TreeNode<T> root;

    public GeneralTree() {
    }

    public GeneralTree(T value) {
        if (value == null)
            throw new IllegalArgumentException("Cannot insert null value!");
        this.root = new TreeNode<>(value);
    }

    public GeneralTree(T value, GeneralTree<T>... children) {
        if (value == null)
            throw new IllegalArgumentException("Cannot insert null value!");
        this.root = new TreeNode<>(value);
        for (GeneralTree<T> child : children) {
            this.root.addChild(child.root);
        }
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    /**
     * Depth-First Search (DFS) manner
     *
     * @param treeNode
     */
    public void traverseDFS(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }

        visit(treeNode.getValue());

        TreeNode<T> child;
        for (int i = 0; i < treeNode.childrenCount(); i++) {
            child = treeNode.getChild(i);
            traverseDFS(child);
        }
    }

    /**
     * Breadth-First Search(BFS) visits all the nodes of a level before going to the next level.
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
     *
     * @param treeNode
     */
    public void traverseLevelOrder(TreeNode<T> treeNode) {
        if (treeNode == null) {
            return;
        }

        Queue<TreeNode<T>> nodes = new LinkedList<>();
        nodes.add(treeNode);

        while (!nodes.isEmpty()) {

            TreeNode<T> node = nodes.remove();

            visit(node.getValue());

            for (TreeNode treeNode1 : nodes) {
                nodes.add(treeNode1);
            }
        }
    }

    private void visit(T value) {
        System.out.print(" " + value);
    }
}


class TreeNode<T> {

    private T value;

    private List<TreeNode> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int childrenCount() {
        return this.children.size();
    }

    public void addChild(TreeNode<T> child) {
        if (child == null)
            throw new IllegalArgumentException("Cannot insert null value!");

        this.children.add(child);
    }

    public TreeNode<T> getChild(int index) {
        return this.children.get(index);
    }

}

