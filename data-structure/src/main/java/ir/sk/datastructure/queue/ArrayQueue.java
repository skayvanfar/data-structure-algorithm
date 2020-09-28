package ir.sk.datastructure.queue;

import java.util.Arrays;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class ArrayQueue<T> implements Queue<T> {

    private int maxSize;
    private Object[] queueArray;
    private int front;
    private int rear;

    public ArrayQueue(int s) {
        maxSize = s + 1;
        queueArray = new Object[maxSize];
        front = 0;
        rear = -1;
    }

    /**
     * @param j
     */
    @Override
    public void add(T j) {
        if (rear == maxSize - 1)
            rear = -1;
        queueArray[++rear] = j;
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T remove() {
        T temp = (T) queueArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }

    /**
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) queueArray[front];
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    public boolean isFull() {
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    public int size() { // (assumes queue not empty)
        if (rear >= front) // contiguous sequence
            return rear - front + 1;
        else // broken sequence
            return (maxSize - front) + (rear + 1);
    }

    public void display() {
        System.out.print("\nQueue = ");
        if (queueArray.length == 0) {
            System.out.print("Empty\n");
            return;
        }
        Arrays.stream(queueArray).forEach(o -> System.out.print(", " + o));
        System.out.println();
    }
}
