package ir.sk.datastructure.fundamental.linklist;

import ir.sk.datastructure.ListIterator;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.recursiontype.HeadRecursion;
import ir.sk.helper.recursiontype.TailRecursion;

/**
 * A linked list is a linear data structure,
 * in which the elements are not stored at contiguous memory locations.
 * The elements in a linked list are linked using pointers
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SinglyLinkList<T> implements Iterable<T> {

    // ref to first link on list
    private SinglyLink<T> head;

    public SinglyLinkList() {
        head = null;
    }

    /**
     * @param id
     */
    @TimeComplexity("O(1)")
    public void insertFirst(T id) {
        SinglyLink<T> newSinglyLink = new SinglyLink<>(id);
        newSinglyLink.next = head;
        head = newSinglyLink;
    }

    /**
     * @param value
     */
    @TimeComplexity("O(n)")
    public void add(T value) {
        SinglyLink<T> current = head;
        SinglyLink<T> newSinglyLink = new SinglyLink<>(value);

        if (current == null) {
            this.head = newSinglyLink;
            return;
        }

        while (current.next != null) {
            current = current.next;
        }
        current.next = newSinglyLink;
    }

    /**
     * find link with given key
     * (assumes non-empty list)
     *
     * @param key
     * @return
     */
    @TimeComplexity("O(n)")
    public SinglyLink find(int key) {
        SinglyLink<T> current = head;
        while (!current.data.equals(key)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    /**
     * @param nodeNum
     * @return
     */
    @TimeComplexity("O(n)")
    public T get(int nodeNum) {
        if (nodeNum <= 0) {
            return null;
        }
        SinglyLink<T> current = head;
        for (int i = 1; i < nodeNum; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * delete link with given key
     * (assumes non-empty list)
     *
     * @param key
     * @return
     */
    @TimeComplexity("O(n)")
    public SinglyLink delete(int key) {
        SinglyLink current = head;
        SinglyLink previous = head;
        while (!current.data.equals(key)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;
        return current;
    }

    /**
     * delete first item
     * (assumes list not empty)
     *
     * @return
     */
    @TimeComplexity("O(1)")
    public T deleteFirst() {
        SinglyLink<T> temp = head;
        head = head.next;
        return temp.data;
    }

    @TimeComplexity("O(1)")
    public T peakFirst() {
        return head.data;
    }

    @TimeComplexity("O(1)")
    public boolean isEmpty() {
        return head == null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        SinglyLink<T> current = head;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    /**
     * get value of first
     *
     * @return
     */
    public SinglyLink<T> getHead() {
        return head;
    }

    /**
     * set first to new link
     *
     * @param f
     */
    public void setHead(SinglyLink<T> f) {
        head = f;
    }

    /**
     * another implementation O(1), we keep
     * track of the number of items in an instance variable N , incrementing N when we push
     * and decrementing N when we pop.
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(n)")
    public int size(SinglyLink<T> n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    /**
     * return iterator
     *
     * @return
     */
    @Override
    public ListIterator<T> iterator() {
        return new ListIterator(this);
    }

    //////////////////////////////////// traverse

    /**
     * 1, 2, 3, 4
     */
    @TimeComplexity("O(n)")
    public void traverseIterative() {
        SinglyLink<T> link = head;
        visit(link);
        while (link.next != null) {
            visit(link);
            link = link.next;
        }
    }

    /**
     * 1, 2, 3, 4
     *
     * @param link
     */
    @TimeComplexity("O(n)")
    @TailRecursion
    public void traverseTailRecursive(SinglyLink<T> link) {
        visit(link);
        if (link.next != null)
            traverseTailRecursive(link.next);
    }

    /**
     * 4, 3, 2, 1
     *
     * @param link
     */
    @TimeComplexity("O(n)")
    @HeadRecursion
    public void traverseHeadRecursive(SinglyLink<T> link) {
        if (link.next != null)
            traverseHeadRecursive(link.next);
        visit(link);
    }

    public void visit(SinglyLink<T> link) {
        System.out.println(link.data);
    }
}
