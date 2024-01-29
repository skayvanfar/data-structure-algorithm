package ir.sk.adt.datastructure.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 12/7/2017.
 */
public class ArrayTest {

    Array array;

    @Before
    public void setUp() throws Exception {
        int maxSize = 100;
        array = new Array(maxSize);

        // insert 10 items
        array.insert(1);
        array.insert(2);
        array.insert(3);
        array.insert(4);
        array.insert(5);
        array.insert(6);
        array.insert(7);
        array.insert(8);
        array.insert(9);
        array.insert(10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void find() throws Exception {
        int searchKey = 66; // search for item
        if (array.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
    }

    @Test
    public void insert() throws Exception {
        array.display();
        array.insert(39);
        array.display();
    }

    @Test
    public void delete() throws Exception {
        array.display();
        array.delete(00); // delete 3 items
        array.display();
    }

    @Test
    public void display() throws Exception {
        array.display();
    }

    @Test
    public void testInsert() {
        array.display();
        array.insert(2, 39);
        array.display();
    }

    @Test
    public void traverseIterative() {
        array.traverseIterative();
    }

    @Test
    public void traverseTailRecursive() {
        array.traverseTailRecursive(0);
    }

    @Test
    public void traverseHeadRecursive() {
        array.traverseHeadRecursive(0);
    }
}