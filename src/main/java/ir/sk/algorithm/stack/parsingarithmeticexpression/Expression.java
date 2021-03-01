package ir.sk.algorithm.stack.parsingarithmeticexpression;


import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Stack;

/**
 * Expressions can be written in one of three forms:
 * Infix Notation: Operators are written between the operands they operate on, e.g. 3 + 4.
 * Prefix Notation: Operators are written before the operands, e.g + 3 4
 * Postfix Notation: Operators are written after operands.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class Expression {

    /**
     * converts given infix expression to postfix expression.
     * <p>
     * Shunting Yard Algorithm by Edgar Dijkstra
     *
     * @param str
     * @return
     */
    @SpaceComplexity("O(n^2)")
    @TimeComplexity("O(n)")
    public static String infixIntoPostfixExp(String str) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(')
                        result += stack.pop();
                    stack.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                        result += stack.pop();
                    stack.push(ch);
                    break;
                default:
                    result += ch;
            }
        }

        return result;
    }

    /**
     * A utility function to return precedence of a given operator
     * Higher returned value means higher precedence
     *
     * @param ch
     * @return
     */
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int postfixEvaluation(String str) {

        Stack<Integer> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '/':
                case '*':
                case '+':
                case '-':
                    int left = stack.pop();
                    int right = stack.pop();
                    stack.push(calculator(left, right, ch));
                    break;
                default:
                    stack.push(Character.getNumericValue(ch));
            }
        }
        return stack.pop();
    }

    public static int calculator(int leftValue, int rightValue, Character value) {
        switch (value) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            default:
                return leftValue / rightValue;
        }
    }


    /**
     * developed by  E. W. Dijkstra in the 1960s uses two stacks (one for operands and one for operators) to do this job.
     * An expression consists of parentheses, operators, and oper-ands (numbers).
     * Proceeding from left to right and taking these entities one at a time, we manipulate the stacks according to four possible cases, as follows:
     * Push operands onto the operand stack.
     * Push operators onto the operator stack.
     * Ignore left parentheses.
     * On encountering a right parenthesis, pop an operator, pop the requisite number of operands,
     * and push onto the operand stack the result of applying that opera-tor to those operands.
     *
     * @param expression
     * @return
     */
    @SpaceComplexity("O(n)")
    @TimeComplexity("O(n)")
    public static double infixEvaluation(String expression) {

        String[] tokens = expression.split(" ");

        // Stack for Operators: 'ops
        Stack<String> ops = new Stack<>();

        // Stack for numbers: 'values'
        Stack<Double> vals = new Stack<>();

        for (String token : tokens) {
            if (token.equals("(")) ;
            else if (token.equals("+")) ops.push(token);
            else if (token.equals("-")) ops.push(token);
            else if (token.equals("*")) ops.push(token);
            else if (token.equals("/")) ops.push(token);
            else if (token.equals("sqrt")) ops.push(token);
            else if (token.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } // Token not operator or paren: push double value.
            else vals.push(Double.parseDouble(token));
        }
        return vals.pop();
    }

}
