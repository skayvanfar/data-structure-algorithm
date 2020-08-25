package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 8/25/2020.
 */
public class ReplaceSpacesTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void replaceSpacesBruteForce() {
        char[] str = "Saeed Kayvanfar    ".toCharArray();
        System.out.println(ReplaceSpaces.replaceSpacesBruteForce(str));
    }

    @Test
    public void replaceSpaces() {
        char[] str = "Saeed Kayvanfar    ".toCharArray();

        str = ReplaceSpaces.replaceSpaces(str);

        for (int i = 0; i < str.length; i++)
            System.out.print(str[i]);
    }

}