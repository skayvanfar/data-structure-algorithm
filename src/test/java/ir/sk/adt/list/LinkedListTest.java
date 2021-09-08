package ir.sk.adt.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 9/8/2021.
 */
public class LinkedListTest {

    List list;

    @Before
    public void setUp() throws Exception {
        list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        list.insert(0, 0);
        list.insert(2, 55);
        System.out.println();
    }

    @Test
    public void get() {
    }

    @Test
    public void removeAt() {
    }
}