package ir.sk.algorithm.tree;

import ir.sk.algorithm.stack.parsingarithmeticexpression.Expression;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * The expression tree is a binary tree in which each internal node corresponds
 * to the operator and each leaf node corresponds to the operand
 * <p>
 * Inorder traversal of expression tree produces infix version of given postfix expression
 * (same with postorder traversal it gives prefix expression)
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class ExpressionTree {

    /**
     * You are given a binary tree representation of an arithmetic expression. In this tree, each leaf is an integer value,
     * and a non-leaf node is one of the four operations: '+', '-', '*', or '/'.
     * Write a function that takes this tree and evaluates the expression.
     * <p>
     * Example:
     * <p>
     * *
     * / \
     * +    +
     * / \  / \
     * 3  2  4  5
     * <p>
     * This is a representation of the expression (3 + 2) * (4 + 5), and should return 45.
     * <p>
     * using LRV DFS ,traversePostOrder
     *
     * @param node
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int calculateExpression(Node<Character> node) {
        if (node.left == null || node.right == null)
            return Integer.valueOf(node.value + "");
        else {
            int leftValue = calculateExpression(node.left);
            int rightValue = calculateExpression(node.right);
            return Expression.calculator(leftValue, rightValue, node.value);
        }
    }

}

class Node<T> {
    T value;
    Node<T> left;
    Node<T> right;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
