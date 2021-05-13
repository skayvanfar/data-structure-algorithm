package ir.sk.adt.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code ResizingArrayStack} class represents a last-in-first-out (LIFO) stack
 * of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 * for peeking at the top item, testing if the stack is empty, and iterating through
 * the items in LIFO order.
 * <p>
 * This implementation uses a resizing array, which double the underlying array
 * when it is full and halves the underlying array when it is one-quarter full.
 * The <em>push</em> and <em>pop</em> operations take constant amortized time.
 * The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 * constant time in the worst case.
 * <p>
 */
public class ResizingArrayStack<T> implements Stack<T>, Iterable<T> {

    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private T[] stackArray;
    private int top;                 // number of elements on stack

    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        stackArray = (T[]) new Object[INIT_CAPACITY];
        top = 0;
    }

    /**
     * Adds the item to this stack.
     * @param item the item to add
     */
    @Override
    public void push(T item) {
        if (top == stackArray.length)
            resize(2 * stackArray.length); // double size of array if necessary
        stackArray[top++] = item; // increment size, add item
    }

    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = stackArray[top -1];
        stackArray[top -1] = null;                   // to avoid loitering
        top--;
        // shrink size of array if necessary
        if (top > 0 && top == stackArray.length / 4)
            resize(stackArray.length / 2);
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[top - 1];
    }

    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack
     */
    public int size() {
        return top;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {  // Move stack to a new array of size max.
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < top; i++)
            temp[i] = stackArray[i];
        stackArray = temp;
        // alternative implementation
        // a = java.util.Arrays.copyOf(a, capacity);
    }

    public void display() {
        System.out.print("\nStack = ");
        if (stackArray.length == 0) {
            System.out.print("Empty\n");
            return;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(stackArray[i] + " ");
        System.out.println();
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * Support LIFO iteration.
     */
    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<T> {
        private int i;

        public ReverseArrayIterator() {
            i = top - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return stackArray[i--];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
