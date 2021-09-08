package ir.sk.adt.stack;

import ir.sk.helper.Default;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic stack implementation with a fixed-size array.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
@Default
public class FixedArrayStack<T> implements Stack<T>, Iterable<T> {

    private T[] stackArray;
    private int top;             // number of items in stack

    @SuppressWarnings("unchecked")
    public FixedArrayStack(int s) {
        stackArray = (T[]) new Object[s]; // create array
        top = 0; // no items yet
    }

    /**
     * @param item
     */
    @Override
    public void push(T item) {
        if (top >= stackArray.length)
            throw new IndexOutOfBoundsException("Overflow Exception");
        stackArray[top++] = item;
    }

    /**
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[--top];
    }

    /**
     * @return
     */
    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[top - 1];
    }

    /**
     * true if stack is empty
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * true if stack is full
     *
     * @return
     */
    public boolean isFull() {
        return top == stackArray.length;
    }

    public int size() {
        return top;
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
