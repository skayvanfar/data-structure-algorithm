package ir.sk.algorithm.linklist;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * You are given two singly linked lists. The lists intersect at some node. Find, and return the node. Note: the lists are non-cyclical.
 *
 * Example:
 *
 * A = 1 -> 2 -> 3 -> 4
 * B = 6 -> 3 -> 4
 *
 * This should return 3 (you may assume that any nodes with the same value are the same node).
 *
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class LinkIntersection {

    /**
     * Use 2 nested for loops. The outer loop will be for each node of the 1st list and inner loop will be for 2nd list.
     * In the inner loop, check if any of nodes of the 2nd list is same as the current node of the first linked list.
     *
     * @param list1
     * @param list2
     * @param <T>
     * @return
     */
    @TimeComplexity("O(n*m)")
    public static <T> SinglyLink<T> findIntersectionNaive(SinglyLink<T> list1, SinglyLink<T> list2) {
        SinglyLink<T> first= list1;
        while (first != null) {
            SinglyLink<T> second = list2;
            while (second != null) {
                if (second.data == first.data)
                    return second;
                second = second.next;
            }
            first = first.next;
        }
        return null;
    }
}
