package ir.sk.datastructure;

import ir.sk.datastructure.fundamental.linklist.Link;
import ir.sk.datastructure.fundamental.linklist.LinkList;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class ListIterator<T> {

    private Link<T> current;          // current link
    private Link<T> previous;         // previous link
    private LinkList<T> ourList;      // our linked list

    public ListIterator(LinkList list) {
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
    public Link getCurrent() {
        return current;
    }

    /**
     * insert after
     *
     * @param dd
     */
    public void insertAfter(long dd) {
        // current link
        Link newLink = new Link(dd);

        if (ourList.isEmpty())     // empty list
        {
            ourList.setHead(newLink);
            current = newLink;
        } else                        // not empty
        {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();              // point to new link
        }
    }

    /**
     * insert before
     * @param dd
     */
    public void insertBefore(long dd) {
        // current link
        Link newLink = new Link(dd);

        if (previous == null)        // beginning of list
        {                        // (or empty list)
            newLink.next = ourList.getHead();
            ourList.setHead(newLink);
            reset();
        } else                        // not beginning
        {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
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
