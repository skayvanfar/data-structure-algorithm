package ir.sk.datastructure.buffer;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Stack;

/**
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

    @TimeComplexity("O(1)")
    public void insert(char c) {
        right.push(c);
    }

    @TimeComplexity("O(1)")
    public char delete() {
        if (right.isEmpty()) return ' ';
        return right.pop();
    }

    @TimeComplexity("O(n)")
    public void left(int k) {
        for (int i = 0; i < k; i++) {
            if (left.isEmpty()) return;
            right.push(left.pop());
        }
    }

    @TimeComplexity("O(n)")
    public void right(int k) {
        for (int i = 0; i < k; i++) {
            if (right.isEmpty()) return;
            left.push(right.pop());
        }
    }

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
