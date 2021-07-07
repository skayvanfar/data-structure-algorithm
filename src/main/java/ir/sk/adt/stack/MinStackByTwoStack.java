package ir.sk.adt.stack;

import java.util.Iterator;

/**
 * Use two stacks: one to store actual stack elements and the other as an auxiliary stack to store minimum values.
 * The idea is to do push() and pop() operations in such a way that the top of the auxiliary stack is always the minimum.
 *
 * Created by sad.kayvanfar on 7/7/2021.
 */
public class MinStackByTwoStack implements MinStack<Integer> {

    // Actual Stack
    Stack<Integer> stack = new FixedArrayStack<>(20);
    // Auxiliary Stack
    Stack<Integer> minStack = new FixedArrayStack<>(20);

    @Override
    public Integer min() {
        int x = minStack.pop();
        minStack.push(x);
        return x;
    }

    @Override
    public void push(Integer item) {
        if (isEmpty() == true) {
            stack.push(item);
            minStack.push(item);
        }
        else {
            stack.push(item);
            Integer y = minStack.pop();
            minStack.push(y);
            if (item < y)
                minStack.push(item);
            else
                minStack.push(y);
        }
    }

    @Override
    public Integer pop() {
        int x = stack.pop();
        minStack.pop();
        return x;
    }

    @Override
    public Integer peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
