package ir.sk.adt.datastructure.linklist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 1/31/2020.
 */
public class DoubleEndedListTest {

    DoubleEndedList<Integer> theList;

    @Before
    public void setUp() throws Exception {
        theList = new DoubleEndedList<>(); // make new list
        theList.insertLast(1); // insert four items
        theList.insertLast(2);
        theList.insertLast(3);
        theList.insertLast(4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void insertFirst() {
        theList.displayList();
        theList.insertFirst(0);
        theList.displayList();
    }

    @Test
    public void insertLast() {
        theList.displayList();
        theList.insertLast(5);
        theList.displayList();
    }

    @Test
    public void deleteFirst() {
        theList.displayList();
        theList.deleteFirst();
        theList.displayList();
    }

    @Test
    public void displayList() {
        theList.displayList();
        theList.displayList();
        theList.displayList();
    }
}