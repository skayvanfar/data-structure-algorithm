package ir.sk.datastructure.queue;

import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class Queue<T> {

    private int maxSize;
    private Object[] queArray;
    private int front;
    private int rear;

    public Queue(int s) {
        maxSize = s+1; // array is 1 cell larger
        queArray = new Object[maxSize]; // than requested
        front = 0;
        rear = -1;
    }

    public void insert(T j) { // put item at rear of queue
        if(rear == maxSize-1) // deal with wraparound
            rear = -1;
        queArray[++rear] = j; // increment rear and insert
    }

    public T remove() { // take item from front of queue
        T temp = (T) queArray[front++]; // get value and incr front
        if(front == maxSize) // deal with wraparound
            front = 0;
        return temp;
    }

    public T peekFront() { // peek at front of queue
        return (T) queArray[front];
    }

    public boolean isEmpty() { // true if queue is empty
        return ( rear+1==front || (front+maxSize-1==rear) );
    }

    public boolean isFull() { // true if queue is full

        return ( rear+2==front || (front+maxSize-2==rear) );
    }

    public int size() { // (assumes queue not empty)
        if(rear >= front) // contiguous sequence
            return rear-front+1;
        else // broken sequence
            return (maxSize-front) + (rear+1);
    }

    public void display() {
        System.out.print("\nQueue = ");
        if (queArray.length == 0) {
            System.out.print("Empty\n");
            return;
        }
        Arrays.stream(queArray).forEach(o -> System.out.print(", " + o));
        System.out.println();
    }
}
