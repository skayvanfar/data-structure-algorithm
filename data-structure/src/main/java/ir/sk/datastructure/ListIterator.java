package ir.sk.datastructure;

import ir.sk.datastructure.fundamental.linklist.SinglyLink;
import ir.sk.datastructure.fundamental.linklist.SinglyLinkList;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class ListIterator<T> {

    private SinglyLink<T> current;          // current link
    private SinglyLink<T> previous;         // previous link
    private SinglyLinkList<T> ourList;      // our linked list

    public ListIterator(SinglyLinkList list) {
        ourList = list;
        reset();
    }

    /**
     * start at 'first'
     */
    public void reset() {
        current = ourList.getHead();
        previous = null;
    }

    /**
     * true if last link
     *
     * @return
     */
    public boolean atEnd() {
        return (current.next == null);
    }

    /**
     * go to next link
     */
    public void nextLink()
    {
        previous = current;
        current = current.next;
    }

    /**
     * get current link
     *
     * @return
     */
    public SinglyLink getCurrent() {
        return current;
    }

    /**
     * insert after
     *
     * @param dd
     */
    public void insertAfter(long dd) {
        // current link
        SinglyLink newSinglyLink = new SinglyLink(dd);

        if (ourList.isEmpty())     // empty list
        {
            ourList.setHead(newSinglyLink);
            current = newSinglyLink;
        } else                        // not empty
        {
            newSinglyLink.next = current.next;
            current.next = newSinglyLink;
            nextLink();              // point to new link
        }
    }

    /**
     * insert before
     * @param dd
     */
    public void insertBefore(long dd) {
        // current link
        SinglyLink newSinglyLink = new SinglyLink(dd);

        if (previous == null)        // beginning of list
        {                        // (or empty list)
            newSinglyLink.next = ourList.getHead();
            ourList.setHead(newSinglyLink);
            reset();
        } else                        // not beginning
        {
            newSinglyLink.next = previous.next;
            previous.next = newSinglyLink;
            current = newSinglyLink;
        }
    }

    /**
     * delete item at current
     *
     * @return
     */
    public T deleteCurrent() {
        T value = current.data;
        if (previous == null)        // beginning of list
        {
            ourList.setHead(current.next);
            reset();
        } else                        // not beginning
        {
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }
}
