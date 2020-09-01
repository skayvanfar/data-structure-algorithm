package ir.sk.algorithm.linklist;

import ir.sk.datastructure.fundamental.linklist.Link;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.HashSet;

/**
 * Created by sad.kayvanfar on 9/1/2020.
 */
public class LinkListAlgorithms {

    /**
     * iterate with two pointers: current which iterates through the linked list,
     * and runner which checks all subsequent nodes for duplicates.
     * <p>
     * Using Runner Technique
     *
     * @param head
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    public static void deleteDuplicatesByRunner(Link head) {
        Link current = head;
        while (current != null) {
            Link runner = head;
            while (runner.next != null) {
                if (current.data.equals(runner.next.data)) {
                    runner.next = runner.next.next;
                } else
                    runner = runner.next;
            }
            current = current.next;
        }
    }

    /**
     * iterate through the linked list, adding each element to a hash table. When
     * we discover a duplicate element, we remove the element and continue iterating.
     *
     * @param head
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void deleteDuplicatesByHashing(Link<Integer> head) {
        HashSet<Integer> hashTable = new HashSet<>();
        Link<Integer> previous = null;

        while (head != null) {
            if (hashTable.contains(head.data))
                previous.next = head.next;
            else {
                hashTable.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    /**
     * wrap the counter value with simple class
     */
    static class Index {
        public int value = 0;
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public static Link<Integer> kthToLastRecursive(Link<Integer> head, int k) {
        Index idx = new Index();
        return kthToLastRecursive(head, k, idx);
    }

    /**
     * This algorithm recurses through the linked list. When it hits the end, the method passes back a counter set
     * to 0. Each parent call adds 1 to this counter. When the counter equals k, we know we have reached the kth
     * to last element of the linked list.
     *
     * @param head
     * @param k
     * @param idx
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    private static Link<Integer> kthToLastRecursive(Link<Integer> head, int k, Index idx) {
        if (head == null)
            return null;

        Link<Integer> node = kthToLastRecursive(head.next, k, idx);
        idx.value = idx.value + 1;
        if (idx.value == k)
            return head;

        return node;
    }

    /**
     * use two pointers,
     * pl and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and moving pl
     * k nodes into the list. Then, when we move them at the same pace, pl will hit the end of the linked list after
     * LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
     *
     * @param head
     * @param k
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    private static Link<Integer> nthToLastByRunner(Link<Integer> head, int k) {
        Link<Integer> pl = head;
        Link<Integer> p2 = head;

        /* Move pl k nodes into the list.*/
        for (int i = 0; i < k; i++) {
            if (pl == null)
                return null; // Out of bounds
            pl = pl.next;
        }

        /* Move them at the same pace. When pl hits the end, p2 will be at the right 12 * element. */
        while (pl != null) {
            pl = pl.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * delete a node in the middle (i.e., any node but
     * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
     * that node.
     *
     * You only have access to that node.
     * The solution is simply to copy the data from the next node over to the current node, and then to delete the
     * next node.
     *
     * @param n
     * @return
     */
    private static boolean deleteNode(Link<Integer> n) {
        if (n == null || n.next == null)
            return false; // Failure

        Link<Integer> next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
