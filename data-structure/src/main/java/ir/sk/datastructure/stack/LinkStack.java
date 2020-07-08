package ir.sk.datastructure.stack;

import ir.sk.datastructure.fundamental.linklist.LinkList;

/**
 * Stack Implemented by a Linked List
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkStack<T> {

    private LinkList<T> theList;

    public LinkStack() {
        theList = new LinkList();
    }

    /**
     * put item on top of stack
     *
     * @param j
     */
    public void push(T j) {
        theList.insertFirst(j);
    }

    /**
     * take item from top of stack
     *
     * @return
     */
    public T pop() {
        return theList.deleteFirst();
    }

    public boolean isEmpty() {
        return ( theList.isEmpty() );
    }

    public void display() {
        System.out.print("Stack (top-->bottom): ");
        theList.displayList();
    }
}
