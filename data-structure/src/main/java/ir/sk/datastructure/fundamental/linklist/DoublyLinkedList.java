package ir.sk.datastructure.fundamental.linklist;

/**
 * he doubly linked list (not to be
 * confused with the double-ended list)
 * It allows you to traverse backward as
 * well as forward through the list. The secret is that each link has two references to
 * other links instead of one. The first is to the next link, as in ordinary lists.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class DoublyLinkedList<T> {

    private DoubledLink<T> first;
    private DoubledLink<T> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * insert at front of list
     *
     * @param dd
     */
    public void insertFirst(T dd) {
        DoubledLink<T> newLink = new DoubledLink<>(dd);   // make new link

        if (isEmpty())                // if empty list,
            last = newLink;             // newLink <-- last
        else
            first.previous = newLink;   // newLink <-- old first
        newLink.next = first;          // newLink --> old first
        first = newLink;               // first --> newLink
    }

    /**
     * insert at end of list
     *
     * @param dd
     */
    public void insertLast(T dd) {
        DoubledLink newLink = new DoubledLink(dd);   // make new link
        if (isEmpty())                // if empty list,
            first = newLink;            // first --> newLink
        else {
            last.next = newLink;        // old last --> newLink
            newLink.previous = last;    // old last <-- newLink
        }
        last = newLink;                // newLink <-- last
    }

    /**
     * delete first link
     *
     * @return
     */
    public DoubledLink<T> deleteFirst() {
        // (assumes non-empty list)
        DoubledLink<T> temp = first;
        if (first.next == null)         // if only one item
            last = null;                // null <-- last
        else
            first.next.previous = null; // null <-- old next
        first = first.next;            // first --> old next
        return temp;
    }

    /**
     * delete last link
     *
     * @return
     */
    public DoubledLink<T> deleteLast() {
        // (assumes non-empty list)
        DoubledLink<T> temp = last;
        if (first.next == null)         // if only one item
            first = null;               // first --> null
        else
            last.previous.next = null;  // old previous --> null
        last = last.previous;          // old previous <-- last
        return temp;
    }

    /**
     * insert dd just after key
     *
     * @param key
     * @param dd
     * @return
     */
    public boolean insertAfter(T key, T dd) {
        // (assumes non-empty list)
        DoubledLink<T> current = first;          // start at beginning
        while (current.data != key) {  // until match is found,

            current = current.next;     // move to next link
            if (current == null)
                return false;            // didn't find it
        }
        DoubledLink<T> newLink = new DoubledLink<>(dd);   // make new link

        if (current == last) {             // if last link,

            newLink.next = null;        // newLink --> null
            last = newLink;             // newLink <-- last
        } else { // not last link,
            newLink.next = current.next; // newLink --> old next
            // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current;    // old current <-- newLink
        current.next = newLink;        // old current --> newLink
        return true;                   // found it, did insertion
    }

    /**
     * delete item w/ given key
     *
     * @param key
     * @return
     */
    public DoubledLink<T> deleteKey(T key) {
        // (assumes non-empty list)
        DoubledLink current = first;          // start at beginning
        while (current.data != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if (current == null)
                return null;             // didn't find it
        }
        if (current == first)             // found it; first item?
            first = current.next;       // first --> old next
        else                           // not first
            // old previous --> old next
            current.previous.next = current.next;

        if (current == last)              // last item?
            last = current.previous;    // old previous <-- last
        else                           // not last
            // old previous <-- old next
            current.next.previous = current.previous;
        return current;                // return value
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        DoubledLink current = first;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // display data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        DoubledLink current = last;           // start at end
        while (current != null)         // until start of list,
        {
            current.displayLink();      // display data
            current = current.previous; // move to previous link
        }
        System.out.println("");
    }
}
