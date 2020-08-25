package ir.sk.datastructure.list;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.keyvanfar on 8/25/2020.
 */
public class ArrayListTest {

    List<Integer> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        list.add(10);
        list.add(6);
        list.add(14);
        list.add(10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void get() {
        int expectedValue = 14;
        Assert.assertEquals(14, list.get(2).intValue());
    }

    @Test
    public void remove() {
    }
}