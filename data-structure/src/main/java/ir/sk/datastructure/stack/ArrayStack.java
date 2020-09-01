package ir.sk.datastructure.stack;

import java.util.NoSuchElementException;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class ArrayStack<T> implements Stack<T> {

    private int maxSize;
    private Object[] stackArray;
    private int top;

    public ArrayStack(int s) {
        maxSize = s; // set array size
        stackArray = new Object[maxSize]; // create array
        top = -1; // no items yet
    }

    /**
     * @param item
     */
    @Override
    public void push(T item) {
        if(top >= stackArray.length)
            throw new IndexOutOfBoundsException("Overflow Exception");

        stackArray[++top] = item; // increment top, insert item
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if(isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return (T) stackArray[top--]; // access item, decrement top
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return (T) stackArray[top];
    }

    @Override
    public boolean isEmpty() { // true if stack is empty
        return (top == -1);
    }

    public boolean isFull() {// true if stack is full
        return (top == maxSize-1);
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
}
