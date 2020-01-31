package ir.sk.datastructure.linklist;

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
 * such situation is implementing a queue; we’ll see how this technique works in the
 * next section.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class FirstLastList<T> {

    private Link<T> first;               // ref to first link
    private Link<T> last;                // ref to last link

    public FirstLastList() {
        first = null;                  // no links on list yet
        last = null;
    }

    public boolean isEmpty()          // true if no links
    {
        return first == null;
    }

    public void insertFirst(T dd)  // insert at front of list
    {
        Link<T> newLink = new Link<T>(dd);   // make new link

        if (isEmpty())                // if empty list,
            last = newLink;             // newLink <-- last
        newLink.next = first;          // newLink --> old first
        first = newLink;               // first --> newLink
    }

    public void insertLast(T dd)   // insert at end of list
    {
        Link<T> newLink = new Link<T>(dd);   // make new link
        if (isEmpty())                // if empty list,
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // old last --> newLink
        last = newLink;                // newLink <-- last
    }

    public T deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        T temp = first.data;
        if (first.next == null)         // if only one item
            last = null;                // null <-- last
        first = first.next;            // first --> old next
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;          // start at beginning
        while (current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
}
