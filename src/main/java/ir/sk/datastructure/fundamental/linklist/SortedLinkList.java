package ir.sk.datastructure.fundamental.linklist;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * In a sorted list, the items are arranged in sorted order by key value.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SortedLinkList<T extends Comparable> {

    private SinglyLink<T> head;

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
        SinglyLink<T> newSinglyLink = new SinglyLink(key);    // make new link
        SinglyLink<T> previous = null;            // start at first
        SinglyLink<T> current = head;
        // until end of list,
        while (current != null && key.compareTo(current.data) > 0) {                             // or key > current,
            previous = current;
            current = current.next;       // go to next item
        }
        if (previous == null)               // at beginning of list
            head = newSinglyLink;              // first --> newLink
        else                             // not at beginning
            previous.next = newSinglyLink;      // old prev --> newLink
        newSinglyLink.next = current;          // newLink --> old currnt
    }  // end insert()

    /**
     * return & delete first link
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public SinglyLink<T> remove() {
        // (assumes non-empty list)
        SinglyLink<T> temp = head;               // save first
        head = head.next;              // delete first
        return temp;                     // return value
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        SinglyLink current = head;       // start at beginning of list
        while (current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
}
