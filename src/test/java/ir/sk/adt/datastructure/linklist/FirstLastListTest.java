package ir.sk.adt.datastructure.linklist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class FirstLastListTest {

    FirstLastList<Integer> theList;

    @Before
    public void setUp() throws Exception {
        theList = new FirstLastList<>(); // make new list
        theList.insertFirst(22); // insert four items
        theList.insertFirst(44);
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
        theList.displayList();
        theList.insertFirst(22);
        theList.displayList();
    }

    @Test
    public void insertLast() {
        theList.displayList();
        theList.insertLast(22);
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