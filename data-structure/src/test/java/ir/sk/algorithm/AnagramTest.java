package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/6/2020.
 */
public class AnagramTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doAnagram() {
        String text = "cats";
        Anagram.count = 0;
        Anagram.size = text.length();
        for(int j = 0; j < text.length(); j++) // put it in array
            Anagram.arrChar[j] = text.charAt(j);

        Anagram.doAnagram(text.length());
    }

    @Test
    public void rotate() {
    }

    @Test
    public void displayWord() {
    }
}