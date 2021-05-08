package ir.sk.adt.queue;

import ir.sk.helper.complexity.AmortizedTimeComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;
import java.util.Stack;

/**
 * A class which implements a queue using two stacks.
 *
 * Method 1 (By making enQueue operation costly) This method makes sure that oldest entered element is always at the top of stack 1,
 * so that deQueue operation just pops from stack1.
 * To put the element at top of stack1, stack2 is used.
 *
 * Method 2 (By making deQueue operation costly)In this method, in en-queue operation, the new element is entered at the top of stack1.
 * In de-queue operation, if stack2 is empty then all the elements are moved to stack2 and finally top of stack2 is returned.
 *
 * Method 2 is definitely better than method 1.
 * Method 1 moves all the elements twice in enQueue operation, while method 2 (in deQueue operation) moves the elements once and moves elements only if stack2 empty.
 * So, the amortized complexity of the dequeue operation becomes O(1) .
 *
 * @see ir.sk.adt.stack.StackByTwoQueue
 *
 * <p>
 * Created by sad.kayvanfar on 10/4/2020.
 */
public class QueueByTwoStack<T> implements Queue<T> {

    private Stack<T> stack = new Stack<>();
    private Stack<T> buffer = new Stack<>();

    @TimeComplexity("O(1)")
    public void enqueue(T value) {
        stack.push(value);
    }

    @AmortizedTimeComplexity("O(1)")
    @TimeComplexity("O(n)")
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

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
