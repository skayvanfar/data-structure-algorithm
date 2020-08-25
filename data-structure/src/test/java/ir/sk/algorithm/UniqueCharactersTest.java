package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 8/25/2020.
 */
public class UniqueCharactersTest {

    private String txt;

    @Before
    public void setUp() throws Exception {
        txt = "abcdefab";
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void uniqueCharactersBruteForce() {
        boolean expectedValue = false;
        Assert.assertEquals(expectedValue, UniqueCharacters.uniqueCharactersBruteForce(txt.toCharArray()));
    }

    @Test
    public void uniqueCharactersBySorting() {
        boolean expectedValue = false;
        Assert.assertEquals(expectedValue, UniqueCharacters.uniqueCharactersBySorting(txt.toCharArray()));
    }

    @Test
    public void uniqueCharactersByHashing() {
        boolean expectedValue = false;
        Assert.assertEquals(expectedValue, UniqueCharacters.uniqueCharactersByHashing(txt.toCharArray()));
    }


}