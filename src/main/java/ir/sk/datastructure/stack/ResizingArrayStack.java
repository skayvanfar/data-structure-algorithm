package ir.sk.datastructure.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Stack<T>, Iterable<T> {
    private T[] stackArray;
    private int top;

    public ResizingArrayStack(int s) {
        stackArray = (T[]) new Object[s]; // create array
        top = 0; // no items yet
    }

    /**
     * @param item
     */
    @Override
    public void push(T item) {
        // Add item to top of stack.
        if (top == stackArray.length)
            resize(2 * stackArray.length);

        stackArray[++top] = item; // increment top, insert item
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {

        //Remove item from top of stack.
        T item = stackArray[--top];
        stackArray[top] = null;  // Avoid loitering (see text).
        if (top > 0 && top == stackArray.length / 4)
            resize(stackArray.length / 2);
        return item;
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[top];
    }

    /**
     * true if stack is empty
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * true if stack is full
     *
     * @return
     */
    public boolean isFull() {
        return (top == stackArray.length - 1);
    }

    public int size() {
        return top + 1;
    }

    private void resize(int max) {  // Move stack to a new array of size max.
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < top; i++)
            temp[i] = stackArray[i];
        stackArray = temp;
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

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayStack.ReverseArrayIterator();
    }

    /**
     * Support LIFO iteration.
     */
    private class ReverseArrayIterator implements Iterator<T> {
        private int i = top + 1;

        public boolean hasNext() {
            return i > 0;
        }

        public T next() {
            return stackArray[--i];
        }

        public void remove() {
        }
    }
}
