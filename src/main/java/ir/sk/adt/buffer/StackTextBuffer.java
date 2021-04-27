package ir.sk.adt.buffer;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Stack;

/**
 * a data type for a buffer in a text editor
 *
 * Use two stacks: insertion gives O(1)
 *
 * Created by sad.kayvanfar on 3/9/2021.
 */
public class StackTextBuffer implements TextBuffer {

    Stack<Character> left;
    Stack<Character> right;

    public StackTextBuffer() {
        left = new Stack<>();
        right = new Stack<>();
    }

    /**
     * insert c at the cursor position
     */
    @TimeComplexity("O(1)")
    public void insert(char c) {
        right.push(c);
    }

    /**
     * delete and return the character at the cursor
     */
    @TimeComplexity("O(1)")
    public char delete() {
        if (right.isEmpty()) return ' ';
        return right.pop();
    }

    /**
     * move the cursor k positions to the left
     */
    @TimeComplexity("O(n)")
    public void left(int k) {
        for (int i = 0; i < k; i++) {
            if (left.isEmpty()) return;
            right.push(left.pop());
        }
    }

    /**
     * move the cursor k positions to the right
     */
    @TimeComplexity("O(n)")
    public void right(int k) {
        for (int i = 0; i < k; i++) {
            if (right.isEmpty()) return;
            left.push(right.pop());
        }
    }

    /**
     * number of characters in the buffer
     */
    public int size() {
        return left.size() + right.size();
    }

    /**
     * String method with cursor position indicated by a | character
     *
     * @return
     */
    public String toString() {
        String s = "";
        for (char c : left) {
            s += c;
        }
        s += "|";
        for (char c : right) {
            s += c;
        }
        return s;
    }
}
