package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/3/2021.
 */
public class LongestCommonPrefixTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findLongestCommonPrefixCharByChar() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("tutorialcup", "tutorial", "tussle", "tumble"));
        StringBuffer ans = LongestCommonPrefix.longestCommonPrefixCharByChar(arr.toArray(new String[4]));

        if (ans.length() != 0)
            System.out.println("Longest common prefix = " + ans);
        else
            System.out.print("No common prefix found");
    }

    @Test
    public void findLongestCommonPrefixBySorting() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("tutorialcup", "tutorial", "tussle", "tumble"));
        StringBuffer ans = LongestCommonPrefix.findLongestCommonPrefixBySorting(arr.toArray(new String[4]));

        if (ans.length() != 0)
            System.out.println("Longest common prefix = " + ans);
        else
            System.out.print("No common prefix found");
    }
}