package ir.sk.adt.list;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Iterator;

/**
 * Created by sad.kayvanfar on 9/8/2021.
 */
public class LinkedList<T> implements List<T> {

    // ref to first link on list
    private SinglyLink<T> head;

    public LinkedList() {
        head = null;
    }

    /**
     * exactly like @Link {@link ir.sk.adt.datastructure.linklist.SinglyLinkList}
     *
     * @param value
     */
    @TimeComplexity("O(n)")
    @Override
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

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @TimeComplexity("O(n)")
    @Override
    public void insert(int index, T value) {
        SinglyLink<T> current = head;
        SinglyLink<T> previous = head;
        SinglyLink<T> newSinglyLink = new SinglyLink<>(value);

        if (current == null) {
            //if head is null and position is zero then exit.
            if (index != 0) {
                return;
            } else { //node set to the head.
                this.head = newSinglyLink;
                return;
            }
        }

        if (head != null && index == 0) {
            newSinglyLink.next = this.head;
            this.head = newSinglyLink;
            return;
        }

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;

            if (current == null) {
                break;
            }
        }

        newSinglyLink.next = current;
        previous.next = newSinglyLink;
    }

    @TimeComplexity("O(n)")
    @Override
    public T get(int index) {
        // index must be 1 or higher
        if (index < 0)
            return null;
        SinglyLink<T> crunchifyCurrent = null;
        if (head != null) {
            crunchifyCurrent = head.next;
            for (int i = 0; i < index; i++) {
                if (crunchifyCurrent.next == null)
                    return null;

                crunchifyCurrent = crunchifyCurrent.next;
            }
            return crunchifyCurrent.data;
        }
        return crunchifyCurrent.data;
    }

    @TimeComplexity("O(n)")
    @Override
    public T removeAt(int index) {
        // If linked list is empty
        if (head == null)
            return null;

        // Store head node
        SinglyLink temp = head;

        // If head needs to be removed
        if (index == 0) {
            head = temp.next;   // Change head
            return null;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return null;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        SinglyLink next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
