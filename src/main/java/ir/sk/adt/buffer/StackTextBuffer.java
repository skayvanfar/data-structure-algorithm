package ir.sk.adt.buffer;

import ir.sk.helper.complexity.TimeComplexity;

import java.util.Stack;

/**
 * a data type for a buffer in a text editor
 *
 * Use two stacks: insertion gives O(1)
 *
 * Declare two stacks of type character.
 * First stack contains data on the left of cursor.
 * Second stack contains data rest of data towards right of cursor till end of buffer.
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
     *
     * push the given character at end of left stack.
     */
    @TimeComplexity("O(1)")
    public void insert(char c) {
        left.push(c);
    }

    /**
     * delete and return the character at the cursor
     *
     * If the right stack is empty, return null character.
     * Otherwise, pop out a character from right stack and return it.
     */
    @TimeComplexity("O(1)")
    public char delete() {
        if (right.isEmpty()) return ' ';
        return right.pop();
    }

    /**
     * move the cursor k positions to the left
     *
     * Repeat the below statements k times or till left stack is empty.
     * Pop out a character from left stack and push it to right stack.
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
     *
     * Repeat the below statements k times or till right stack is empty.
     * Pop out a character from right stack and push it to left stack.
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
     * return the sum of sizes on both stacks.
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
        for (char c : left)
            s += c;

        s += "|";
        for(int i = right.size() - 1; i>=0; --i)
            s += right.get(i);

        return s;
    }
}
