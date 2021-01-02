package ir.sk.algorithm.stack.parsingarithmeticexpression;


import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Stack;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class Expression {

    /**
     * converts given infix expression to postfix expression.
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
}
