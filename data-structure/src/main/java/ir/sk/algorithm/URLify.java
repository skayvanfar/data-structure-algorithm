package ir.sk.algorithm;

import ir.sk.helper.BruteForce;
import ir.sk.helper.InPlace;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 8/25/2020.
 */
public class URLify {

    private final static int MAX = 1000;

    /**
     * @param str
     * @return
     */
    @BruteForce
    public static String replaceSpacesBruteForce(char[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * replace all spaces in a string with '%20'.You may assume that the string
     * has sufficient space at the end to hold the additional characters
     *
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @InPlace
    public static char[] replaceSpaces(char[] str) {

        // count spaces and find current length
        int space_count = 0, i = 0;
        for (i = 0; i < str.length; i++)
            if (str[i] == ' ')
                space_count++;

        // count spaces and find current length
        while (str[i - 1] == ' ')
        {
            space_count--;
            i--;
        }

        // Find new length.
        int new_length = i + space_count * 2;

        // New length must be smaller than length
        // of string provided.
        if (new_length > MAX)
            return str;

        // Start filling character from end
        int index = new_length - 1;

        char[] new_str = str;
        str = new char[new_length];

        // Fill rest of the string from end
        for (int j = i - 1; j >= 0; j--)
        {

            // inserts %20 in place of space
            if (new_str[j] == ' ')
            {
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index = index - 3;
            }

            else
            {
                str[index] = new_str[j];
                index--;
            }
        }
        return str;
    }
}
