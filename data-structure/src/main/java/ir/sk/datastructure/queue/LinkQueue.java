package ir.sk.datastructure.queue;

import ir.sk.datastructure.linklist.FirstLastList;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkQueue<T> {

    private FirstLastList<T> theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }  // make a 2-ended list

    public boolean isEmpty()          // true if queue is empty
    { return theList.isEmpty(); }

    public void insert(T j)        // insert, rear of queue
    { theList.insertLast(j); }

    public T remove()              // remove, front of queue
    {  return theList.deleteFirst();  }

    public void display() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
