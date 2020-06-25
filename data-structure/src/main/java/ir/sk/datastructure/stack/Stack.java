package ir.sk.datastructure.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class Stack {

    private int maxSize; // size of stack array
    private int[] stackArray;
    private int top; // top of stack

    public Stack(int s) {
        maxSize = s; // set array size
        stackArray = new int[maxSize]; // create array
        top = -1; // no items yet
    }

    public void push(int j) { // put item on top of stack
        if(top >= stackArray.length)
            throw new IndexOutOfBoundsException("Overflow Exception");

        stackArray[++top] = j; // increment top, insert item
    }

    public int pop() { // take item from top of stack
        if(isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return stackArray[top--]; // access item, decrement top
    }

    public int peek() { // peek at top of stack
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
