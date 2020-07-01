package ir.sk.datastructure.stack;

import ir.sk.datastructure.fundamental.linklist.LinkList;

/**
 * Stack Implemented by a Linked List
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkStack<T> {

    private LinkList<T> theList;

    public LinkStack() {
        theList = new LinkList();
    }

    public void push(T j)     // put item on top of stack
    {
        theList.insertFirst(j);
    }

    public T pop()            // take item from top of stack
    {
        return theList.deleteFirst();
    }

    public boolean isEmpty()       // true if stack is empty
    {
        return ( theList.isEmpty() );
    }

    public void display()
    {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}
