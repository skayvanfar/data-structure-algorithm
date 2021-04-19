package ir.sk.adt.datastructure.tree;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.technique.BFS;
import ir.sk.helper.recursiontype.HeadRecursion;
import ir.sk.helper.recursiontype.TailRecursion;
import ir.sk.helper.technique.BacktrackingDFS;

import java.util.*;

/**
 * General Tree is used to show real models like organization tree
 * <p>
 * Time Complexity: O(n)
 * Main Operations: insert-delete-traverse
 * traverse: DFS-BFS
 * <p>
 * Tree can be: Balanced- Unbalanced, Complete, Full, Perfect(Full+Complete)
 * <p>
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

    ////////////////////////////// traverse

    /**
     * Depth-First Search (DFS) manner (Recursive)
     * TailRecursive so PreOrder
     *
     * @param node
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @TailRecursion
    @BacktrackingDFS
    public void traverseDFSTailRecursive(GeneralNode<T> node) {
        visit(node);
        for (int i = 0; i < node.childrenCount(); i++)
            traverseDFSTailRecursive(node.getChild(i));
    }

    /**
     * HeadRecursive so PostOrder
     *
     * @param node
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @HeadRecursion
    @BacktrackingDFS
    public void traverseDFSHeadRecursive(GeneralNode<T> node) {
        for (int i = 0; i < node.childrenCount(); i++)
            traverseDFSHeadRecursive(node.getChild(i));
        visit(node);
    }

    /**
     *
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @BacktrackingDFS
    public void traverseDFSIterative() {
        Stack<GeneralNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            GeneralNode<T> node = stack.pop();
            visit(node);
            for (GeneralNode<T> childNode : node.getChildren())
                stack.push(childNode);
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
     * @param node
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @BFS
    public void traverseLevelOrder(GeneralNode<T> node) {
        Queue<GeneralNode<T>> nodes = new LinkedList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            GeneralNode<T> childNode = nodes.remove();

            visit(childNode);

            for (GeneralNode generalNode1 : nodes)
                nodes.add(generalNode1);
        }
    }

    private void visit(GeneralNode node) {
        System.out.print(" " + node.getValue());
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

    public List<GeneralNode> getChildren() {
        return children;
    }

    public void setChildren(List<GeneralNode> children) {
        this.children = children;
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

