package ir.sk.algorithm.linklist;

import ir.sk.adt.datastructure.linklist.SinglyLink;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 7/25/2021.
 */
public class LinkIntersectionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findIntersectionNaive() {
        SinglyLink<Integer> first = new SinglyLink<>(1, new SinglyLink(2, new SinglyLink(3, new SinglyLink(4, new SinglyLink(5)))));
        SinglyLink<Integer> second = new SinglyLink<>(10, first.next.next);
        LinkIntersection.findIntersectionNaive(first, second).displayLink();
    }

    @Test
    public void findIntersectionByCache() {
        SinglyLink<Integer> first = new SinglyLink<>(1, new SinglyLink(2, new SinglyLink(3, new SinglyLink(4, new SinglyLink(5)))));
        SinglyLink<Integer> second = new SinglyLink<>(10, first.next.next);
        LinkIntersection.findIntersectionByCache(first, second).displayLink();
    }

    @Test
    public void findIntersectionByNodeCounts() {
        SinglyLink<Integer> first = new SinglyLink<>(1, new SinglyLink(2, new SinglyLink(3, new SinglyLink(4, new SinglyLink(5)))));
        SinglyLink<Integer> second = new SinglyLink<>(10, first.next.next);
        LinkIntersection.findIntersectionByNodeCounts(first, second).displayLink();
    }
}