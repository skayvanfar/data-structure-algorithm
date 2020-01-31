package ir.sk.datastructure.linklist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkListTest {

    LinkList<Integer> theList;

    @Before
    public void setUp() throws Exception {
        theList = new LinkList<>(); // make new list
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
        theList.insertFirst(45);
        theList.displayList();
    }

    @Test
    public void displayList() {
        theList.displayList(); // display list
    }

    @Test
    public void delete() {
        theList.displayList();
        theList.delete(66); // display list
        theList.displayList();
    }

    @Test
    public void find() {
        Link link = theList.find(44);
        if( link != null)
            System.out.println("Found link with key " + link.data);
        else
            System.out.println("Can't find link");
    }
}