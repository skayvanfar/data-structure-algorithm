package ir.sk.adt.datastructure.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="sad.keyvanfar@gmail.com">Saeid Keyvanfar</a> on 12/7/2017.
 */
public class SortedArrayTest {

    SortedArray array;

    @Before
    public void setUp() throws Exception {
        int maxSize = 100;
        array = new SortedArray(maxSize);

        // insert 10 items
        array.insert(77);
        array.insert(99);
        array.insert(44);
        array.insert(55);
        array.insert(22);
        array.insert(88);
        array.insert(11);
        array.insert(00);
        array.insert(66);
        array.insert(33);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void find() throws Exception {
        int searchKey = 55; // search for item
        if (array.find(searchKey) != array.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can’t find " + searchKey);
    }

    @Test
    public void insert() throws Exception {
        array.display(); // display items
        array.insert(33);
        array.display(); // display items
    }

    @Test
    public void delete() throws Exception {
        array.display();
        array.delete(00); // delete 3 items
        array.display();
    }

    @Test
    public void display() throws Exception {
        array.display(); // display items
    }

}