package ir.sk.datastructure.linklist;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkList<T> {

    private Link<T> first;            // ref to first link on list

    public LinkList() {
        first = null;               // no links on list yet
    }

    public void insertFirst(T id) {
        // make new link
        Link<T> newLink = new Link<>(id);
        newLink.next = first;       // it points to old first link
        first = newLink;            // now first points to this
    }

    /**
     * find link with given key
     * @param key
     * @return
     */
    public Link find(int key) {
        // (assumes non-empty list)
        Link<T> current = first;              // start at 'first'
        while(!current.data.equals(key))        // while no match,
        {
            if(current.next == null)        // if end of list,
                return null;                 // didn't find it
            else                            // not end of list,
                current = current.next;      // go to next link
        }
        return current;                    // found it
    }

    public Link delete(int key)    // delete link with given key
    {                           // (assumes non-empty list)
        Link current = first;              // search for link
        Link previous = first;
        while(!current.data.equals(key)) {
            if(current.next == null)
                return null;                 // didn't find it
            else
            {
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

    public void displayList()      // display the list
    {
        System.out.print("List (first-->last): ");
        Link<T> current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
}
