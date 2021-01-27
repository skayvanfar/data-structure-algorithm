package ir.sk.algorithm.linklist;

import ir.sk.datastructure.fundamental.linklist.SinglyLink;
import ir.sk.helper.*;
import ir.sk.helper.complexity.InPlace;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.FrequencyCountingPattern;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.pattern.RunnerPattern;

import java.util.HashSet;
import java.util.Set;
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
     * 1) Get the middle of the linked list.
     * 2) Reverse the second half of the linked list.
     * 3) Check if the first half and second half are identical.
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static boolean isPalindromeByRunner(SinglyLink<Integer> head) {
        SinglyLink<Integer> middleLink = findMiddleLink(head);
        SinglyLink<Integer> reversed = reverseIterative(middleLink);
        return isEqual(head, reversed);
    }

    /**
     * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes
     * from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
     * So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
     *
     * This problem shares similarities with Palindrome LinkedList. To rearrange the given LinkedList we will follow the following steps:
     *
     * We can use the Fast & Slow pointers method similar to Middle of the LinkedList to find the middle node of the LinkedList.
     * Once we have the middle of the LinkedList, we will reverse the second half of the LinkedList.
     * Finally, we’ll iterate through the first half and the reversed second half to produce a LinkedList in the required order.
     *
     * @param head
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static void reOrder(SinglyLink<Integer> head) {
        SinglyLink<Integer> middleLink = findMiddleLink(head);
        SinglyLink<Integer> reversed = reverseIterative(middleLink);
        while (reversed != null) {
            SinglyLink<Integer> tmp = head.next;
            head.next = reversed;
            head = tmp;

            tmp = reversed.next;
            reversed.next = head;
            reversed = tmp;
        }
        if (head != null)
            head.next = null;
    }

    /**
     * Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.
     * 1->2->3->4->null
     * 4->3->2->1->null
     *
     * @param node
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @InPlace
    public static SinglyLink<Integer> reverseIterative(SinglyLink<Integer> node) {
        SinglyLink<Integer> prev = null;
        SinglyLink<Integer> current = node;
        SinglyLink<Integer> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    /**
     * 1->2->3->4->null
     * 4->3->2->1->null
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static SinglyLink reverseRecursive(SinglyLink head) {
        if (head == null || head.next == null)
            return head;

        /* reverse the rest list and put
        the first element at the end */
        SinglyLink rest = reverseRecursive(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
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
    @TimeComplexity("O(n/2) = O(n)")
    @SpaceComplexity("O(n/2) = O(n)")
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


    /**
     * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
     * Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point,
     * if NULL is reached then return false and if next of current node points to any of the previously
     * stored nodes in Hash then return true
     *
     * 1->2->3->4->5->6->3
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @FrequencyCountingPattern
    public static boolean hasCycleByHashing(SinglyLink<Integer> head) {
        SinglyLink<Integer> current  = head;
        Set<SinglyLink<Integer>> hashtable = new HashSet<>();
        while (current != null) {
            if (hashtable.contains(current))
                return true;
            else {
                hashtable.add(current);
                current = current.next;
            }
        }
        return false;
    }

    /**
     * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
     *
     * Imagine two racers running in a circular racing track. If one racer is faster than the other, the faster racer is bound to catch up and cross the slower racer from behind. We can use this fact to devise an algorithm to determine if a LinkedList has a cycle in it or not.
     *
     * Imagine we have a slow and a fast pointer to traverse the LinkedList. In each iteration, the slow pointer moves one step and the fast pointer moves two steps. This gives us two conclusions:
     *
     * If the LinkedList doesn’t have a cycle in it, the fast pointer will reach the end of the LinkedList before the slow pointer to reveal that there is no cycle in the LinkedList.
     * The slow pointer will never be able to catch up to the fast pointer if there is no cycle in the LinkedList.
     * If the LinkedList has a cycle, the fast pointer enters the cycle first, followed by the slow pointer. After this, both pointers will keep moving in the cycle infinitely. If at any stage both of these pointers meet, we can conclude that the LinkedList has a cycle in it. Let’s analyze if it is possible for the two pointers to meet. When the fast pointer is approaching the slow pointer from behind we have two possibilities:
     *
     * The fast pointer is one step behind the slow pointer.
     * The fast pointer is two steps behind the slow pointer.
     * All other distances between the fast and slow pointers will reduce to one of these two possibilities. Let’s analyze these scenarios, considering the fast pointer always moves first:
     *
     * If the fast pointer is one step behind the slow pointer: The fast pointer moves two steps and the slow pointer moves one step, and they both meet.
     * If the fast pointer is two steps behind the slow pointer: The fast pointer moves two steps and the slow pointer moves one step. After the moves, the fast pointer will be one step behind the slow pointer, which reduces this scenario to the first scenario. This means that the two pointers will meet in the next iteration.
     * This concludes that the two pointers will definitely meet if the LinkedList has a cycle.
     *
     * 1->2->3->4->5->6->3
     *
     * floyds way
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static boolean hasCycleByRunner(SinglyLink<Integer> head) {
        SinglyLink<Integer> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * Given the head of a LinkedList with a cycle, find the length of the cycle.
     *
     * Once the fast and slow pointers meet, we can save the slow pointer and iterate the whole cycle with another pointer until we see the slow pointer again to find the length of the cycle.
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static int findCycleLength(SinglyLink<Integer> head) {
        SinglyLink<Integer> slow = head;
        SinglyLink<Integer> fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return calculateLength(slow);
        }
        return 0;
    }

    private static int calculateLength(SinglyLink<Integer> slow) {
        SinglyLink<Integer> current = slow;
        int cycleLength = 0;
        do {
            current = current.next;
            cycleLength++;
        } while (current != slow);
        return cycleLength;
    }

    /**
     * If we know the length of the LinkedList cycle, we can find the start of the cycle through the following steps:
     *
     * Take two pointers. Let’s call them pointer1 and pointer2.
     * Initialize both pointers to point to the start of the LinkedList.
     * We can find the length of the LinkedList cycle using the approach discussed in LinkedList Cycle. Let’s assume that the length of the cycle is ‘K’ nodes.
     * Move pointer2 ahead by ‘K’ nodes.
     * Now, keep incrementing pointer1 and pointer2 until they both meet.
     * As pointer2 is ‘K’ nodes ahead of pointer1, which means, pointer2 must have completed one loop in the cycle when both pointers meet. Their meeting point will be the start of the cycle.
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static SinglyLink<Integer> findCycleStart(SinglyLink<Integer>  head) {
        int cycleLength = findCycleLength(head);
        return findStart(head, cycleLength);
    }

    private static SinglyLink<Integer> findStart(SinglyLink<Integer> head, int cycleLength) {
        SinglyLink<Integer> pointer1 = head, pointer2 = head;

        // move pointer1 ahead 'cycLength' nodes
        while (cycleLength > 0) {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }

    /**
     * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.
     *
     * One brute force strategy could be to first count the number of nodes in the LinkedList and then find the middle node in the second iteration.
     *
     * We can use the Fast & Slow pointers method such that the fast pointer is always twice the nodes ahead of the slow pointer.
     * This way, when the fast pointer reaches the end of the LinkedList,
     * the slow pointer will be pointing at the middle node.
     *
     * @param head
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static SinglyLink<Integer> findMiddleLink(SinglyLink<Integer> head) {
        SinglyLink<Integer> slow = head;
        SinglyLink<Integer> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
