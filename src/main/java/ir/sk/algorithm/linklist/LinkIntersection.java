package ir.sk.algorithm.linklist;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.HashSet;
import java.util.Set;

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
    @SpaceComplexity("O(1)")
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

    /**
     * Traverse the first linked list and store the addresses of visited nodes in a hash.
     * Now traverse the second linked list and if you see an address that already exists in the hash then return the intersecting node.
     *
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    @TimeComplexity("O(n+m)")
    @SpaceComplexity("O(n)")
    public static <T> SinglyLink<T> findIntersectionByCache(SinglyLink<T> first, SinglyLink<T> second) {
        Set<SinglyLink<T>> cache = new HashSet<>();

        SinglyLink<T> firstTmp = first;
        while (firstTmp != null) {
            cache.add(firstTmp);
            firstTmp = firstTmp.next;
        }

        SinglyLink<T> secondTmp = second;
        while (secondTmp != null) {
            if (cache.contains(secondTmp))
                return secondTmp;
            secondTmp = secondTmp.next;
        }
        return null;
    }


    /**
     * 1. Run through each linked list to get the lengths and the tails.
     * 2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
     * 3. Set two pointers to the start of each linked list.
     * 4. On the longer linked list, advance its pointer by the difference in lengths.
     * 5. Now, traverse on each linked list until the pointers are the same.
     *
     * @param listl
     * @param list2
     * @return
     */
    @TimeComplexity("O(n+m) where n and m are the lengths of the two linked lists")
    @SpaceComplexity("O(1)")
    public static <T> SinglyLink<T> findIntersectionByNodeCounts(SinglyLink<T> listl, SinglyLink<T> list2) {
        if (listl == null || list2 == null) return null;


        /* Get tail and sizes. */
        Result2 resultl = getTailAndSize(listl);
        Result2 result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection. */
        if (resultl.tail != result2.tail) {
            return null;
        }
        /* Set pointers to the start of each linked list. */
        SinglyLink<T> shorter = resultl.size < result2.size ? listl : list2;
        SinglyLink<T> longer = resultl.size < result2.size ? list2 : listl;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longer = getKthNode(longer, Math.abs(resultl.size - result2.size));

        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        /* Return either one. */
        return longer;
    }

    /**
     * a wrapper class
     */
    private static class Result2 {
        public SinglyLink tail;
        public int size;

        public Result2(SinglyLink tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    /**
     * @param list
     * @return
     */
    private static <T> Result2 getTailAndSize(SinglyLink<T> list) {
        if (list == null) return null;

        int size = 1;
        SinglyLink<T> current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result2(current, size);
    }

    /**
     * return kth node.
     *
     * @param head
     * @param k
     * @return
     */
    private static <T> SinglyLink<T> getKthNode(SinglyLink<T> head, int k) {
        SinglyLink<T> current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

}
