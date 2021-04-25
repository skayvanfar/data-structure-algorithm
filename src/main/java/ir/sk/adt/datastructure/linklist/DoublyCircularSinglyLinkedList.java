package ir.sk.adt.datastructure.linklist;

import ir.sk.helper.complexity.TimeComplexity;

/**
 * A circular linked list is a variation of a linked list in which the last node points to the first node, completing a full circle of node
 * Any node in the circular linked list can be a starting point
 * Consequently, the whole list can be traversed starting from any node
 * Since the last node of the circular linked list has the pointer to the first node, it's easy to perform enqueue and dequeue operations like (FirstLastList)
 * <p>
 * <p>
 * A circular linked list can be either singly linked or doubly linked.
 * for singly linked list, next pointer of last item points to the first item
 * In the doubly linked list, prev pointer of the first item points to the last item as well.
 * <p>
 * <p>
 * First-Last Pointer
 * Doubled
 * <p>
 * Created by sad.kayvanfar on 9/1/2020.
 */
public class DoublyCircularSinglyLinkedList<T> {

    private SinglyLink<T> head = null;
    private SinglyLink<T> tail = null;

    /**
     * @param value
     */
    @TimeComplexity("O(1)")
    public void insert(T value) {
        SinglyLink<T> newNode = new SinglyLink<T>(value);

        if (head == null)
            head = newNode;
        else
            tail.next = newNode;

        tail = newNode;
        tail.next = head;
    }

    /**
     * @param key
     * @return
     */
    @TimeComplexity("O(n)")
    public SinglyLink<T> find(T key) {

        SinglyLink<T> currentNode = head;

        if (head == null)
            return null;
        else {
            do {
                if (currentNode.data == key)
                    return currentNode;
                currentNode = currentNode.next;
            } while (currentNode != head);
            return null;
        }
    }

    @TimeComplexity("O(1)")
    public void delete(T key) {
        SinglyLink<T> currentNode = head;

        if (head != null) {
            if (currentNode.data == key) {
                head = head.next;
                tail.next = head;
            } else {
                do {
                    SinglyLink<T> nextNode = currentNode.next;
                    if (nextNode.data == key) {
                        currentNode.next = nextNode.next;
                        break;
                    }
                    currentNode = currentNode.next;
                } while (currentNode != head);
            }
        }
    }

    public void traverse() {
        SinglyLink<T> currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.data + " ");
                currentNode = currentNode.next;
            } while (currentNode != head);
        }
    }
}
