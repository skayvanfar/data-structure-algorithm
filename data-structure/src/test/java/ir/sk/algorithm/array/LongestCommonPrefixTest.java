package ir.sk.algorithm.array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/2/2021.
 */
public class LongestCommonPrefixTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestCommonPrefix() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("tutorialcup", "tutorial", "tussle", "tumble"));
        StringBuffer ans = LongestCommonPrefix.longestCommonPrefix(arr);

        if (ans.length() != 0)
            System.out.print("Longest common prefix = " + ans);
        else
            System.out.print("No common prefix found");
    }
}