package ir.sk.algorithm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void isAnagramSort() {
        String str1 = "silent";
        String str2 = "listen";
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = Anagram.isAnagramSort(str1, str2);
        long endTime = System.nanoTime();
        System.out.println("time duration for isAnagramSort for str.length: " + str1.length() + " length = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);

    }

    @Test
    public void isAnagramCounting() {
        String str1 = "silent";
        String str2 = "listen";
        boolean expectedValue = true;
        long startTime = System.nanoTime();
        boolean result = Anagram.isAnagramCounting(str1, str2);
        long endTime = System.nanoTime();
        System.out.println("time duration for isAnagramCounting for str.length: " + str1.length() + " length = " + (endTime - startTime) + " nano");
        Assert.assertEquals(expectedValue, result);
    }

    @Test
    public void searchAnagrams() {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
        Anagram.searchAnagramsInTextByHashing(pat, txt);
    }
}