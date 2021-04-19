package ir.sk.adt.stack;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A stack can be implemented using two queues.
 *
 * Method 1 (By making push operation costly)
 *
 * Method 2 (By making pop operation costly)
 *
 * @see ir.sk.adt.queue.QueueByTwoStack
 *
 * Created by sad.kayvanfar on 3/10/2021.
 */
public class StackByTwoQueue<T> implements Stack<T> {

    private Queue<T> queue = new LinkedList<>();
    private Queue<T> buffer = new LinkedList<>();

    /**
     * Add an item to the top of the stack.
     *
     * @param item
     */
    @Override
    public void push(T item) {
        // enqueue
        queue.add(item);
    }

    /**
     * Return true if and only if the stack is empty.
     *
     * @return
     */
    @Override
    public T pop() {
        if (queue.isEmpty())
            throw new NoSuchElementException("Underflow Exception");

        // Leave one element in queue and
        // push others in buffer.
        while (queue.size() != 1) {
            buffer.add(queue.peek());
            queue.remove();
        }

        // last pushed element
        T temp = queue.peek();

        // Pop the only left element
        // from queue
        queue.remove();

        // push last element to buffer
        buffer.add(temp);

        // swap the names of two queues
        Queue<T> q = queue;
        queue = buffer;
        buffer = q;
        return temp;
    }

    /**
     * Return the top of the stack.
     *
     * @return
     */
    @Override
    public T peek() {
        return null;
    }

    /**
     * Return true if and only if the stack is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }
}
