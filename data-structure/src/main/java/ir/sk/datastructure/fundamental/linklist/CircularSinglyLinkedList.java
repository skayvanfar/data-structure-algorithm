package ir.sk.datastructure.fundamental.linklist;

import ir.sk.helper.TimeComplexity;

/**
 * A circular linked list is a variation of a linked list in which the last node points to the first node, completing a full circle of node
 * Any node in the circular linked list can be a starting point
 * Consequently, the whole list can be traversed starting from any node
 * Since the last node of the circular linked list has the pointer to the first node, it's easy to perform enqueue and dequeue operations like (FirstLastList)
 * <p>
 * Created by sad.kayvanfar on 9/1/2020.
 */
public class CircularSinglyLinkedList<T> {

    private SinglyLink<T> head = null;
    private SinglyLink<T> tail = null;

    /**
     * @param value
     */
    @TimeComplexity("O(1)")
    public void add(T value) {

        SinglyLink<T> newNode = new SinglyLink<T>(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        tail.next = head;
    }

    /**
     * @param searchValue
     * @return
     */
    @TimeComplexity("O(n)")
    public SinglyLink<T> find(T searchValue) {

        SinglyLink<T> currentNode = head;

        if (head == null)
            return null;
        else {
            do {
                if (currentNode.data == searchValue)
                    return currentNode;
                currentNode = currentNode.next;
            } while (currentNode != head);
            return null;
        }
    }

    @TimeComplexity("O(1)")
    public void delete(T valueToDelete) {
        SinglyLink<T> currentNode = head;

        if (head != null) {
            if (currentNode.data == valueToDelete) {
                head = head.next;
                tail.next = head;
            } else {
                do {
                    SinglyLink<T> nextNode = currentNode.next;
                    if (nextNode.data == valueToDelete) {
                        currentNode.next = nextNode.next;
                        break;
                    }
                    currentNode = currentNode.next;
                } while (currentNode != head);
            }
        }
    }

    public void traverseList() {
        SinglyLink<T> currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.data + " ");
                currentNode = currentNode.next;
            } while (currentNode != head);
        }
    }
}
