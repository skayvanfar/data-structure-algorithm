package ir.sk.algorithm.tree;

import ir.sk.algorithm.stack.parsing.Expression;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Stack;

/**
 * The expression tree is a binary tree in which each internal node corresponds
 * to the operator and each leaf node corresponds to the operand
 * <p>
 * Inorder traversal of expression tree produces infix version of given postfix expression
 * (same with postorder traversal it gives prefix expression)
 *
 * @author <a href="sad.keyvanfar@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class ExpressionTree {

    /**
     * Function to construct an expression tree from the given postfix expression
     *
     * @param postfix
     * @return
     */
    public static Node constructExpressionTree(String postfix) {
        // create an empty stack to store tree pointers
        Stack<Node> s = new Stack<>();

        // traverse the postfix expression
        for (char c : postfix.toCharArray()) {
            // if the current token is an operator
            if (isOperator(c)) {
                // pop two nodes `x` and `y` from the stack
                Node x = s.pop();
                Node y = s.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively
                Node node = new Node(c, y, x);

                // push the current node into the stack
                s.add(node);
            }
            // if the current token is an operand, create a new binary tree node
            // whose root is the operand and push it into the stack
            else {
                s.add(new Node(c));
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return s.peek();
    }

    // Function to check if a given token is an operator
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '×' || c == '/' || c == '^');
    }

    /**
     * Print the infix expression for an expression tree
     *
     * @param root
     */
    public static void inFix(Node<Character> root) {
        if (root == null) {
            return;
        }

        // if the current token is an operator, print open parenthesis
        if (isOperator(root.value)) {
            System.out.print("(");
        }

        inFix(root.left);
        System.out.print(root.value);
        inFix(root.right);

        // if the current token is an operator, print close parenthesis
        if (isOperator(root.value)) {
            System.out.print(")");
        }
    }

    /**
     * Print the postfix expression for an expression tree
     *
     * @param root
     */
    public static void postFix(Node root)
    {
        if (root == null) {
            return;
        }
        postFix(root.left);
        postFix(root.right);
        System.out.print(root.value);
    }

    /**
     * You are given a binary tree representation of an arithmetic expression. In this tree, each leaf is an integer value,
     * and a non-leaf node is one of the four operations: '+', '-', '*', or '/'.
     * Write a function that takes this tree and evaluates the expression.
     * <p>
     * Example:
     * <p>
     * ....*
     * .../ \
     * ..+   +
     * ./ \  / \
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
    public static int evaluateExpressionTree(Node<Character> node) {
        if (node.left == null || node.right == null)
            return Integer.valueOf(node.value + "");
        else {
            int leftValue = evaluateExpressionTree(node.left);
            int rightValue = evaluateExpressionTree(node.right);
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
