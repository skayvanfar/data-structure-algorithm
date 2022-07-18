package ir.sk.algorithm.array.string.datacompression;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

/**
 * Run–length encoding (RLE) is a simple form of lossless data compression
 * that runs on sequences with the same value occurring many consecutive times.
 * It encodes the sequence to store only a single value and its count.
 * 
 * that run-length encoding is
 * widely used for bitmaps is that its effectiveness increases dramatically as resolution increases.
 */
public class RunLengthEncoding {

    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static void expand(String src) {
        StringBuffer dest = new StringBuffer();
		
		for (int i = 0; i < src.length() - 1; i = i + 2) {
			char charAt = src.charAt(i);
			int cnt = src.charAt(i + 1) - '0';
			for (int j = 0; j < cnt; j++) {
				dest.append(charAt);
			}
		}
		System.out.println(dest.toString());
    }

    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static String compress(String text) {
        String encodedString = "";

    for (int i = 0, count = 1; i < text.length(); i++) {
        if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1))
            count++;
        else {
            encodedString = encodedString.concat(Integer.toString(count))
                    .concat(Character.toString(text.charAt(i)));
            count = 1;
        }
    }
    return encodedString;
    }
}
