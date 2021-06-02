package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 6/2/2021.
 */
public class PalindromeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPalindromeByTwoPointer() {
        System.out.println(Palindrome.isPalindromeByTwoPointer("hosisoh".toCharArray()));
        System.out.println(Palindrome.isPalindromeByTwoPointer("hossoh".toCharArray()));
    }

    @Test
    public void isPalindromeByStack() {
        System.out.println(Palindrome.isPalindromeByStack("hosisoh".toCharArray()));
        System.out.println(Palindrome.isPalindromeByStack("hossoh".toCharArray()));
    }
}