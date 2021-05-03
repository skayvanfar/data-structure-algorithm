package ir.sk.adt.queue.priorityqueue;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Implement Priority Queue using Linked Lists.
 *
 * Created by sad.kayvanfar on 5/3/2021.
 */
public class OrderedLinkedListMaxPriorityQueue<T extends Comparable> implements MaxPriorityQueue<T> {

    private SinglyLink<T> head;

    @TimeComplexity("O(n)")
    @Override
    public void insert(T value) {
        SinglyLink<T> link = new SinglyLink<>(value);
        SinglyLink<T> tmp = head;

        if (head.data.compareTo(value) > 0) {
            // Insert New Node before head
            link.next = head;
            head = link;
        } else {
            // Traverse the list and find a
            // position to insert new node
            while (tmp.next != null && tmp.next.data.compareTo(value) < 0) {
                tmp = tmp.next;
            }

            // Either at the ends of the list
            // or at required position
            link.next = tmp.next;
            tmp.next = link;
        }
    }

    @TimeComplexity("O(1)")
    @Override
    public T max() {
       T value = head.data;
       head = head.next;
       return value;
    }

    @TimeComplexity("O(1)")
    @Override
    public T extractMax() {
        return head.data;
    }
}
