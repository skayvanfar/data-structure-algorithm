package ir.sk.adt.set;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import ir.sk.helper.complexity.TimeComplexity;

public class LinkSet<T> implements Set<T> {

    private SinglyLink<T> head;

    /**
     * insertFirst
     * @param item
     */
    @TimeComplexity("O(1)")
    @Override
    public void add(T item) {
        SinglyLink<T> link = new SinglyLink<>(item);
        if (head == null)
            head = link;
        else {
            link.next = head;
            head = link;
        }
    }

    @TimeComplexity("O(1)")
    @Override
    public void remove(T item) {
        SinglyLink<T> prev = head;
        SinglyLink<T> tmp = head;
        while (head != null) {
            if (head.data.equals(item)) {
                prev.next = tmp.next;
            }
            prev = tmp;
            tmp = tmp.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @TimeComplexity("O(n)")
    @Override
    public boolean contains(T item) {
        SinglyLink<T> tmp = head;
        while (head != null) {
            if (head.data.equals(item))
                return true;
            tmp = tmp.next;
        }
        return false;
    }
}
