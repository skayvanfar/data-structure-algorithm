package ir.sk.datastructure.fundamental.tree;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * General Tree is used to show real models like organization tree
 * <p>
 * Time Complexity: O(n)
 * Main Operations: insert-delete-traverse
 * traverse: DFS-BFS
 *
 * Tree can be: Balanced- Unbalanced, Complete, Full, Perfect(Full+Complete)
 *
 * Created by sad.keyvanfar on 7/1/2020.
 */
public class GeneralTree<T> {

    private GeneralNode<T> root;

    public GeneralTree() {
    }

    public GeneralTree(T value) {
        if (value == null)
            throw new IllegalArgumentException("Cannot insert null value!");
        this.root = new GeneralNode<>(value);
    }

    public GeneralTree(T value, GeneralTree<T>... children) {
        if (value == null)
            throw new IllegalArgumentException("Cannot insert null value!");
        this.root = new GeneralNode<>(value);
        for (GeneralTree<T> child : children) {
            this.root.addChild(child.root);
        }
    }

    public GeneralNode<T> getRoot() {
        return root;
    }

    /**
     * Depth-First Search (DFS) manner
     *
     * @param generalNode
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public void traverseDFS(GeneralNode<T> generalNode) {
        if (generalNode == null) {
            return;
        }

        visit(generalNode.getValue());

        GeneralNode<T> child;
        for (int i = 0; i < generalNode.childrenCount(); i++) {
            child = generalNode.getChild(i);
            traverseDFS(child);
        }
    }

    /**
     * Breadth-First Search(BFS) visits all the nodes of a level before going to the next level.
     * <p>
     * This kind of traversal is also called level-order and visits all the levels of the tree starting from the root, and from left to right.
     * <p>
     * Level order traversal is defined as follows:
     * • Visit the root.
     * • While traversing level 1, keep all the elements at level 1+1 in queue.
     * • Go to the next level and visit all the nodes at that level.
     * • Repeat this until all levels are completed.
     *
     * @param generalNode
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public void traverseLevelOrder(GeneralNode<T> generalNode) {
        if (generalNode == null) {
            return;
        }

        Queue<GeneralNode<T>> nodes = new LinkedList<>();
        nodes.add(generalNode);

        while (!nodes.isEmpty()) {

            GeneralNode<T> node = nodes.remove();

            visit(node.getValue());

            for (GeneralNode generalNode1 : nodes) {
                nodes.add(generalNode1);
            }
        }
    }

    private void visit(T value) {
        System.out.print(" " + value);
    }
}


/**
 * @param <T>
 */
class GeneralNode<T> {

    private T value;

    private List<GeneralNode> children;

    public GeneralNode(T value) {
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

    public void addChild(GeneralNode<T> child) {
        if (child == null)
            throw new IllegalArgumentException("Cannot insert null value!");

        this.children.add(child);
    }

    public GeneralNode<T> getChild(int index) {
        return this.children.get(index);
    }

}

