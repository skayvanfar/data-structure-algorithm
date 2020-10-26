package ir.sk.algorithm.linklist;

import ir.sk.datastructure.fundamental.linklist.SinglyLink;
import ir.sk.helper.*;

import java.util.HashSet;
import java.util.Stack;

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
    @Point("Using two Loop")
    public static void deleteDuplicatesByRunner(SinglyLink head) {
        SinglyLink current = head;
        while (current != null) {
            SinglyLink runner = head;
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
    @FrequencyCountingPattern
    public static void deleteDuplicatesByHashing(SinglyLink<Integer> head) {
        HashSet<Integer> hashTable = new HashSet<>();
        SinglyLink<Integer> previous = null;

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
    public static SinglyLink<Integer> kthToLastRecursive(SinglyLink<Integer> head, int k) {
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
    private static SinglyLink<Integer> kthToLastRecursive(SinglyLink<Integer> head, int k, Index idx) {
        if (head == null)
            return null;

        SinglyLink<Integer> node = kthToLastRecursive(head.next, k, idx);
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
    @MultiplePointerPattern
    private static SinglyLink<Integer> nthToLastByRunner(SinglyLink<Integer> head, int k) {
        SinglyLink<Integer> pl = head;
        SinglyLink<Integer> p2 = head;

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
     * <p>
     * You only have access to that node.
     * The solution is simply to copy the data from the next node over to the current node, and then to delete the
     * next node.
     *
     * @param n
     * @return
     */
    private static boolean deleteNode(SinglyLink<Integer> n) {
        if (n == null || n.next == null)
            return false; // Failure

        SinglyLink<Integer> next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    /**
     * You have two numbers represented by a linked list, where each node contains a single
     * digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. this
     * function adds the two numbers and returns the sum as a linked list.
     */
    @TimeComplexity("O(m+n)")
    @SpaceComplexity("O(m+n)")
    public static SinglyLink<Integer> sumRevertedLists(SinglyLink<Integer> list1, SinglyLink<Integer> list2, int carry) {
        if (list1 == null && list2 == null && carry == 0)
            return null;

        SinglyLink<Integer> result = new SinglyLink<>();

        int value = carry;
        if (list1 != null)
            value += list1.data;

        if (list2 != null)
            value += list1.data;

        result.data = value % 10; /* Second digit of number */

        if (list1 != null || list2 != null) {
            SinglyLink<Integer> more = sumRevertedLists(list1 == null ? null : list1.next,
                    list2 == null ? null : list2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    /**
     * first solution is to reverse the linked list and compare the reversed list to the original list. If they're the
     * same, the lists are identical.
     * <p>
     * when we compare the linked list to the reversed list, we only actually need to compare the first
     * half of the list. If the first half of the normal list matches the first half of the reversed list, then the second half
     * of the normal list must match the second half of the reversed list.
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(SinglyLink<Integer> head) {
        SinglyLink reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    /**
     * @param node
     * @return
     */
    public static SinglyLink reverseAndClone(SinglyLink<Integer> node) {
        SinglyLink<Integer> head = null;
        while (node != null) {
            SinglyLink<Integer> n = new SinglyLink<>(node.data); // Clone
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    private static boolean isEqual(SinglyLink<Integer> one, SinglyLink<Integer> two) {
        while (one != null && two != null) {
            if (one.data != two.data)
                return false;

            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    /**
     * We need to push the first half of the elements onto a stack
     * If we don't know the size of the linked list, we can iterate through the linked list, using the fast runner/ slow
     * runner technique
     * At each step in the loop, we push the data from
     * the slow runner onto a stack. When the fast runner hits the end of the list, the slow runner will have reached
     * the middle of the linked list. By this point, the stack will have all the elements from the front of the linked
     * list, but in reverse order.
     *
     * @param head
     * @return
     */
    @MultiplePointerPattern
    public static boolean isPalindromeByStack(SinglyLink<Integer> head) {
        SinglyLink<Integer> fast = head;
        SinglyLink<Integer> slow = head;

        Stack<Integer> stack = new Stack<>();

        /* Push elements from first half of linked list onto stack. When fast runner
         * (which is moving at 2x speed) reaches the end of the linked list, then we
         * know we're at the middle*/
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* Has odd number of elements, so skip the middle element*/
        if (fast != null)
            slow = slow.next;

        while (slow != null) {
            int top = stack.pop().intValue();

            /* If values are different, then it's not a palindrome*/
            if (top != slow.data)
                return false;

            slow = slow.next;
        }
        return true;
    }

    static class Result {
        public SinglyLink<Integer> node;
        public boolean result;

        public Result(SinglyLink<Integer> node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    /**
     * we first need to know when we've reached the middle element, as this will
     * form our base case. We can do this by passing in length - 2 for the length each time. When the length
     * equals 0 or 1, we're at the center of the linked list. This is because the length is reduced by 2 each time. Once
     * we've recursed Yi times, length will be down to 0
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByRecurse(SinglyLink<Integer> head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    private static Result isPalindromeRecurse(SinglyLink<Integer> head, int length) {
        if (head == null || length <= 0) {
            // Even number of nodes
            return new Result(head, true);
        } else if (length == 1) {
            // Odd number of nodes
            return new Result(head.next, true);
        }

        // Recurse on sublist.
        Result res = isPalindromeRecurse(head.next, length - 2);

        // If child calls are not a palindrome, pass back up a failure.
        if (!res.result || res.node == null) {
            return res;
        }

        // Check if matches corresponding node on other side.
        res.result = (head.data == res.node.data);

        // Return corresponding node.
        res.node = res.node.next;

        return res;
    }

    private static int lengthOfList(SinglyLink<Integer> n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
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
    @TimeComplexity("O(A+B) where A and Bare the lengths of the two linked lists")
    @SpaceComplexity("O(1)")
    public static SinglyLink<Integer> findIntersection(SinglyLink<Integer> listl, SinglyLink<Integer> list2) {
        if (listl == null || list2 == null) return null;


        /* Get tail and sizes. */
        Result2 resultl = getTailAndSize(listl);
        Result2 result2 = getTailAndSize(list2);

        /* If different tail nodes, then there's no intersection. */
        if (resultl.tail != result2.tail) {
            return null;
        }
        /* Set pointers to the start of each linked list. */
        SinglyLink<Integer> shorter = resultl.size < result2.size ? listl : list2;
        SinglyLink<Integer> longer = resultl.size < result2.size ? list2 : listl;

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
    private static Result2 getTailAndSize(SinglyLink<Integer> list) {
        if (list == null) return null;

        int size = 1;
        SinglyLink<Integer> current = list;
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
    private static SinglyLink<Integer> getKthNode(SinglyLink<Integer> head, int k) {
        SinglyLink<Integer> current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

}
