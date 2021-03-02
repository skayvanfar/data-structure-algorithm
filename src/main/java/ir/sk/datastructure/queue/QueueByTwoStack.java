package ir.sk.datastructure.queue;

import java.util.Stack;

/**
 * A class which implements a queue using two stacks.
 * <p>
 * Created by sad.kayvanfar on 10/4/2020.
 */
public class QueueByTwoStack<T> implements Queue<T> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> buffer = new Stack<>();


    public void enqueue(T value) {
        stack.push(value);
    }

    public T dequeue() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return buffer.pop(); // pop the oldest item.

    }

    public T peek() {
        shiftStacks(); // Ensure stackOldest has the current elements
        return buffer.peek(); // retrieve the oldest item.
    }

    private void shiftStacks() {
        if (buffer.isEmpty()) {
            while (!stack.isEmpty()) {
                buffer.push(stack.pop());
            }
        }
    }

    @Override
    public void add(T item) {
        enqueue(item);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
