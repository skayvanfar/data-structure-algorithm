package ir.sk.algorithm.linklist;

import ir.sk.datastructure.fundamental.linklist.SinglyLink;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by sad.kayvanfar on 9/16/2020.
 */
public class LinkListAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteDuplicatesByRunner() {
    }

    @Test
    public void deleteDuplicatesByHashing() {
    }

    @Test
    public void kthToLastRecursive() {
    }

    @Test
    public void sumRevertedLists() {
    }

    @Test
    public void isPalindrome() {
    }

    @Test
    public void reverseAndClone() {
    }

    @Test
    public void isPalindromeByStack() {

    }

    @Test
    public void isPalindromeByRecurse() {
    }

    @Test
    public void findIntersection() {
    }

    @Test
    public void reverseIterative() {
        SinglyLink head = getLinkList();
        head = LinkListAlgorithms.reverseIterative(head);
    }

    @Test
    public void reverseRecursive() {
        SinglyLink head = getLinkList();
        head = LinkListAlgorithms.reverseRecursive(head);
    }

    @Test
    public void reverseRecursive2() {
        SinglyLink head = getLinkList();
       // head = LinkListAlgorithms.reverseRecursive2(head); // TODO: 12/29/2020
    }

    private static SinglyLink getLinkList() {
        SinglyLink previousNode = new SinglyLink(4, null);

        for (int i = 3; i > 0; i--) {
            SinglyLink node = new SinglyLink(i, previousNode);
            previousNode = node;
        }
        return previousNode;
    }

    @Test
    public void hasCycleByHashing() {
        SinglyLink<Integer> head = new SinglyLink<>(1);
        head.next = new SinglyLink(2);
        head.next.next = new SinglyLink(3);
        head.next.next.next = new SinglyLink(3);
        head.next.next.next.next = new SinglyLink(5);
        head.next.next.next.next.next = new SinglyLink(6);

        System.out.println(LinkListAlgorithms.hasCycleByHashing(head));

        head.next.next.next.next.next = head.next.next;

        System.out.println(LinkListAlgorithms.hasCycleByHashing(head));
    }

    @Test
    public void hasCycleByRunner() {
        SinglyLink<Integer> head = new SinglyLink<>(1);
        head.next = new SinglyLink(2);
        head.next.next = new SinglyLink(3);
        head.next.next.next = new SinglyLink(3);
        head.next.next.next.next = new SinglyLink(5);
        head.next.next.next.next.next = new SinglyLink(6);

        System.out.println(LinkListAlgorithms.hasCycleByRunner(head));

        head.next.next.next.next.next = head.next.next;

        System.out.println(LinkListAlgorithms.hasCycleByHashing(head));
    }

    @Test
    public void findCycleLength() {
        SinglyLink<Integer> head = new SinglyLink<>(1);
        head.next = new SinglyLink(2);
        head.next.next = new SinglyLink(3);
        head.next.next.next = new SinglyLink(3);
        head.next.next.next.next = new SinglyLink(5);
        head.next.next.next.next.next = new SinglyLink(6);

        System.out.println(LinkListAlgorithms.findCycleLength(head));

        head.next.next.next.next.next = head.next.next;

        System.out.println(LinkListAlgorithms.findCycleLength(head));
    }

    @Test
    public void findCycleStart() {
        SinglyLink<Integer> head = new SinglyLink<>(1);
        head.next = new SinglyLink(2);
        head.next.next = new SinglyLink(3);
        head.next.next.next = new SinglyLink(3);
        head.next.next.next.next = new SinglyLink(5);
        head.next.next.next.next.next = new SinglyLink(6);

        head.next.next.next.next.next = head.next.next;

        System.out.println(LinkListAlgorithms.findCycleStart(head));
    }
}