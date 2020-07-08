package ir.sk.datastructure.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class Stack {

    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s; // set array size
        stackArray = new int[maxSize]; // create array
        top = -1; // no items yet
    }

    /**
     * put item on top of stack
     *
     * @param j
     */
    public void push(int j) {
        if(top >= stackArray.length)
            throw new IndexOutOfBoundsException("Overflow Exception");

        stackArray[++top] = j; // increment top, insert item
    }

    /**
     * take item from top of stack
     *
     * @return
     */
    public int pop() {
        if(isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[top--]; // access item, decrement top
    }

    /**
     * peek at top of stack
     *
     * @return
     */
    public int peek() {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[top];
    }

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
