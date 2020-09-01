package ir.sk.datastructure.fundamental.linklist;

import ir.sk.helper.TimeComplexity;

/**
 * In a sorted list, the items are arranged in sorted order by key value.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SortedLinkList<T extends Comparable> {

    private Link<T> head;

    public SortedLinkList() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * insert, in order
     *
     * @param key
     */
    @TimeComplexity("O(n)")
    public void insert(T key) {
        Link<T> newLink = new Link(key);    // make new link
        Link<T> previous = null;            // start at first
        Link<T> current = head;
        // until end of list,
        while (current != null && key.compareTo(current.data) > 0) {                             // or key > current,
            previous = current;
            current = current.next;       // go to next item
        }
        if (previous == null)               // at beginning of list
            head = newLink;              // first --> newLink
        else                             // not at beginning
            previous.next = newLink;      // old prev --> newLink
        newLink.next = current;          // newLink --> old currnt
    }  // end insert()

    /**
     * return & delete first link
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public Link<T> remove() {
        // (assumes non-empty list)
        Link<T> temp = head;               // save first
        head = head.next;              // delete first
        return temp;                     // return value
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = head;       // start at beginning of list
        while (current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
}
