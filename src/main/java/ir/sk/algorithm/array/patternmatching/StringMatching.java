package ir.sk.algorithm.array.patternmatching;

import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.technique.BruteForce;

/**
 * string-searching algorithms, sometimes called string-matching algorithms, are an important class of string algorithms
 * that try to find a place where one or several strings (also called patterns) are found within a larger string or text.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/6/2020.
 */
public class StringMatching {

    // d is the number of characters in the input alphabet
    public final static int d = 256;

    /**
     * Simple: Using TwoLoops
     * Naive pattern searching is the simplest method among other pattern searching algorithms. It checks for all character of the main string to the pattern.
     * Naive algorithm is exact string matching(means finding one or all exact occurrences of a pattern in a text) algorithm.
     * This algorithm is helpful for smaller texts. It does not need any pre-processing phases. We can find substring by checking once for the string. It also does not occupy extra space to perform the operation
     *
     * @param text
     * @param pattern
     */
    @BruteForce
    @MultipleLoopsPattern
    @TimeComplexity("O(m*(n-m+1)) (n: text length, m: pattern length) = O(n*m)")
    public static int naiveStringSearch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();

        for (int i = 0; i <= (n - m); i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;

                if (j == m)
                    return i; // found
            }
        }
        return n; // not found
    }




    /**
     * Rabin-Karp is another pattern searching algorithm to find the pattern in a more efficient way.
     * It also checks the pattern by moving window one by one, but without checking all characters for all cases,
     * it finds the hash value. When the hash value is matched, then only it tries to check each character.
     * This procedure makes the algorithm more efficient
     *
     * @param pattern pattern
     * @param text    text
     * @param q       A prime number
     */
    @TimeComplexity("O(m(n-m+1)) = O(n+m)")
    public static boolean rabinKarp(String text, String pattern, int q) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int i, j;
        int patternHash = 0; // hash value for pattern
        int textHash = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, patternLength-1)%q"
        for (i = 0; i < patternLength - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < patternLength; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            textHash = (d * textHash + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= textLength - patternLength; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (patternHash == textHash) {
                /* Check for characters one by one */
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                // if patternHash == textHash and pattern[0...patternLength-1] = text[i, i+1, ...i+patternLength-1]
                if (j == patternLength)
                    return true;
            }

            // rolling hash
            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < textLength - patternLength) {
                textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + patternLength)) % q;

                // We might get negative value of textHash, converting it
                // to positive
                if (textHash < 0)
                    textHash = (textHash + q);
            }
        }
        return false;
    }
}
