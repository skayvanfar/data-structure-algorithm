package ir.sk.algorithm;

/**
 *  string-searching algorithms, sometimes called string-matching algorithms, are an important class of string algorithms
 *  that try to find a place where one or several strings (also called patterns) are found within a larger string or text.
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/6/2020.
 */
public class StringMatching {

    /**
     * Simple: Using TwoLoops
     * Naive pattern searching is the simplest method among other pattern searching algorithms. It checks for all character of the main string to the pattern.
     * Naive algorithm is exact string matching(means finding one or all exact occurrences of a pattern in a text) algorithm.
     * This algorithm is helpful for smaller texts. It does not need any pre-processing phases. We can find substring by checking once for the string. It also does not occupy extra space to perform the operation
     *
     * Time Complexity: O(m*(n-m+1)) (n: text length, m: pattern length) = O(n*m)
     *
     * @param text
     * @param pattern
     */
    public static boolean naiveStringSearch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= (textLength - patternLength); i++) {
            int counter = 0;
            for (int j = 0; j < patternLength; j++) {
                int pos = i + j;
                if (text.charAt(pos) != pattern.charAt(j))
                    break;
                else
                    counter++;

                if (counter == patternLength) {
                    return true;
                }

            }
        }
        return false;
    }
}
