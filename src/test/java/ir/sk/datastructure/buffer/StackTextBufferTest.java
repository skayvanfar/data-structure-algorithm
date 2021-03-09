package ir.sk.datastructure.buffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.nio.Buffer;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 3/9/2021.
 */
public class StackTextBufferTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        // Create buffer
        TextBuffer buffer = new StackTextBuffer();

        buffer.insert('a');
        buffer.insert('b');
        buffer.insert('c');
        buffer.insert('d');
        buffer.left(2);
        buffer.insert('d');
        System.out.println(buffer.toString());
    }

    @Test
    public void delete() {
    }
}