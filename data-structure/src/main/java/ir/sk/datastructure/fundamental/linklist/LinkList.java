package ir.sk.datastructure.fundamental.linklist;

import ir.sk.datastructure.ListIterator;

/**
 * A linked list is a linear data structure,
 * in which the elements are not stored at contiguous memory locations.
 * The elements in a linked list are linked using pointers
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkList<T> {

    // ref to first link on list
    private Link<T> first;

    public LinkList() {
        first = null;
    }

    /**
     * Time Complexity: O(1)
     *
     * @param id
     */
    public void insertFirst(T id) {
        Link<T> newLink = new Link<>(id);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }

    /**
     * find link with given key
     *
     * Time Complexity: O(n)
     *
     * @param key
     * @return
     */
    public Link find(int key) {
        // (assumes non-empty list)
        Link<T> current = first;              // start at 'first'
        while(!current.data.equals(key)) {
            if(current.next == null)        // if end of list,
                return null;                 // didn't find it
            else                            // not end of list,
                current = current.next;      // go to next link
        }
        return current;                    // found it
    }

    /**
     * @param key
     * @return
     */
    public Link delete(int key)    // delete link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // search for link
        Link previous = first;
        while(!current.data.equals(key)) {
            if(current.next == null)
                return null;                 // didn't find it
            else {
                previous = current;          // go to next link
                current = current.next;
            }
        }                               // found it
        if(current == first)               // if first link,
            first = first.next;             //    change first
        else                               // otherwise,
            previous.next = current.next;   //    bypass it
        return current;
    }

    /**
     * delete first item
     *
     * @return
     */
    public T deleteFirst() {
        // (assumes list not empty)
        Link<T> temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp.data;                // return deleted link
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link<T> current = first;       // start at beginning of list
        // until end of list
        while(current != null) {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }

    /**
     * get value of first
     *
     * @return
     */
    public Link getFirst() {
        return first;
    }

    /**
     * set first to new link
     *
     * @param f
     */
    public void setFirst(Link f) {
        first = f;
    }

    /**
     * return iterator
     * @return
     */
    public ListIterator<T> getIterator() {
        return new ListIterator(this);  // initialized with
    }
}
