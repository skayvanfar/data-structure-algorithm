package ir.sk.algorithm.array;

import ir.sk.helper.BruteForce;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.HashSet;

/**
 * Created by sad.kayvanfar on 1/20/2021.
 */
public class Math {

    /**
     * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
     * All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
     *
     * 2^2 + 3^2 = 4 + 9 = 13
     * 1^2 + 3^2 = 1 + 9 = 10
     * 2^2 + 0^2 = 1 + 0 = 1
     *
     * @param number
     * @return
     */
    @BruteForce
    public static boolean isHappyNumberNaive(int number) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            number = findSquareSum(number);
            if (number == 1)
                return true;
            if(hashSet.contains(number))
                return false;
            else
                hashSet.add(number);
        }
    }

    @TimeComplexity("O(Log n)")
    @SpaceComplexity("O(1)")
    public static boolean isHappyNumberByRunner(int number) {
        int slow  = number, fast = number;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found cycle
        return slow == 1;
    }

    private static int findSquareSum(int number) {
        int sum  = 0, digit;
        while (number > 0) {
            digit = number % 10;
            sum += digit * digit;
            number /= 10;
        }
        return sum;
    }

    /**
     * Number of Digits in an Integer
     *
     * @param number
     * @return
     */
    public static int digitNumberStringBased(int number) {
        return String.valueOf(number).length();
    }

    /**
     * Number of Digits in an Integer
     *
     * @param number
     * @return
     */
    public static int digitNumberByLog(int number) {
        return (int) (java.lang.Math.log10(number) + 1);
    }

    /**
     * Number of Digits in an Integer
     *
     * @param number
     * @return
     */
    public static int digitNumberByRepeatedMultiplication(int number) {
        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
        }
        return length;
    }
}
