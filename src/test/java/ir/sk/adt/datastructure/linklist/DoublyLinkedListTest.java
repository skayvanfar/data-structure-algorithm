package ir.sk.adt.datastructure.linklist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class DoublyLinkedListTest {

    DoublyLinkedList<Integer> theList;

    @Before
    public void setUp() throws Exception {
        theList = new DoublyLinkedList<>(); // make new list
        theList.insertFirst(22); // insert four items
        theList.insertFirst(11);
        theList.insertFirst(66);
        theList.insertFirst(88);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void insertFirst() {
        theList.displayForward();
        theList.insertFirst(45);
        theList.displayForward();
    }

    @Test
    public void insertLast() {
        theList.displayBackward();
        theList.insertLast(11);       // insert at rear
        theList.displayBackward();
    }

    @Test
    public void deleteFirst() {
    }

    @Test
    public void deleteLast() {
    }

    @Test
    public void insertAfter() {
        theList.displayBackward();
        theList.insertAfter(22, 77);  // insert 77 after 22
        theList.displayBackward();
    }

    @Test
    public void deleteKey() {
        theList.deleteKey(11);        // delete item with key 11
    }

    @Test
    public void displayForward() {
    }

    @Test
    public void displayBackward() {
    }

}