package ir.sk.helper.pattern;

/**
 * Runner, Two Pointer
 * You can keep variables that point to different parts of an array.
 * Having multiple pointers helps to avoid O(n²) time complexity if for example you wanted to calculate a target sum from a pair of numbers in a sorted array.
 * You can have a pointer at the beginning of the array and at the end of the array and you would move the pointers on every iteration. This would reduce the time complexity to O(n).
 * <p>
 * The two pointer technique is a useful tool to utilize when searching for pairs in a sorted array. Although not it’s only use case, when used this technique can save both time and space complexity.
 * When iterating through data this usually implies a single starting point and movement through the data in one direction. However, as the two pointer technique implies,
 * there are two points of consideration and they both (usually) move towards the middle of the data being iterated over.
 * <p>
 * Created by sad.kayvanfar on 9/6/2020.
 */
public @interface TwoPointerPattern {
}
