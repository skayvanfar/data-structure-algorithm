package ir.sk.algorithm.linklist;

import ir.sk.datastructure.fundamental.linklist.Link;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.HashSet;

/**
 * check if the linked list has loop or not
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 8/31/2020.
 */
public class CycleDetection {

    /**
     *
     * Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point,
     * if NULL is reached then return false and if next of current node points to any of the previously
     * stored nodes in Hash then return true
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static boolean detectCycleByHashing(Link head) {
        HashSet<Link> s = new HashSet<Link>();
        while (head != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(head))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(head);

            head = head.next;
        }

        return false;
    }

    /**
     * Using the Runner Technique:
     * The runner technique
     * means that you iterate through the linked list with two pointers simultaneously, with one ahead of the
     * other. The "fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for each
     * one node that the "slow" node iterates through.
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static boolean floydsCycleFinding(Link head) {
        Link slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
