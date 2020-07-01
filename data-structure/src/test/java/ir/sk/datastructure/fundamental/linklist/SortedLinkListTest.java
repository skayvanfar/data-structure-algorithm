package ir.sk.datastructure.fundamental.linklist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SortedLinkListTest {

    SortedLinkList<Integer> theList;

    @Before
    public void setUp() throws Exception {
        theList = new SortedLinkList<>(); // make new list
        theList.insert(22); // insert four items
        theList.insert(44);
        theList.insert(66);
        theList.insert(88);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void insert() {
        theList.displayList();
        theList.insert(45);
        theList.displayList();
    }

    @Test
    public void remove() {
        theList.displayList();
        theList.remove();
        theList.displayList();
    }

    @Test
    public void displayList() {
    }
}