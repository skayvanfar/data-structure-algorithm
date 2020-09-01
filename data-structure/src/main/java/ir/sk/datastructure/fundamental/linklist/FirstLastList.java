package ir.sk.datastructure.fundamental.linklist;

import ir.sk.helper.TimeComplexity;

/**
 * Double-Ended List
 * A double-ended list is similar to an ordinary linked list, but it has one additional
 * feature: a reference to the last link as well as to the first.
 * <p>
 * The reference to the last link permits you to insert a new link directly at the end of
 * the list as well as at the beginning. Of course, you can insert a new link at the end of
 * an ordinary single-ended list by iterating through the entire list until you reach the
 * end, but this approach is inefficient.
 * <p>
 * Access to the end of the list as well as the beginning makes the double-ended list
 * suitable for certain situations that a single-ended list can’t handle efficiently. One
 * such situation is implementing a queue;
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class FirstLastList<T> {

    private Link<T> head;
    private Link<T> tail;

    public FirstLastList() {
        head = null;
        tail = null;
    }

    @TimeComplexity("O(1)")
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * insert at front of list
     *
     * @param dd
     */
    @TimeComplexity("O(1)")
    public void insertFirst(T dd) {
        Link<T> newLink = new Link<T>(dd);   // make new link

        if (isEmpty())                // if empty list,
            tail = newLink;             // newLink <-- last
        newLink.next = head;          // newLink --> old first
        head = newLink;               // first --> newLink
    }

    /**
     * insert at end of list
     *
     * @param dd
     */
    @TimeComplexity("O(1)")
    public void insertLast(T dd) {
        Link<T> newLink = new Link<T>(dd);   // make new link
        if (isEmpty())                // if empty list,
            head = newLink;            // first --> newLink
        else
            tail.next = newLink;        // old last --> newLink
        tail = newLink;                // newLink <-- last
    }

    /**
     * delete first link
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteFirst() {
        // (assumes non-empty list)
        T temp = head.data;
        if (head.next == null)         // if only one item
            tail = null;                // null <-- last
        head = head.next;            // first --> old next
        return temp;
    }

    @TimeComplexity("O(1)")
    public T peakFirst() {
        return head.data;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = head;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
}
