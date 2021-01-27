package ir.sk.algorithm.array;

import ir.sk.helper.BruteForce;
import ir.sk.helper.RunnerPattern;
import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.HashSet;

/**
 * Created by sad.kayvanfar on 1/20/2021.
 */
public class Mathematical {

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
    @TimeComplexity("O(Log n)")
    @SpaceComplexity("O(Log n) ?")
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

    /**
     * The process, defined above, to find out if a number is a happy number or not,
     * always ends in a cycle. If the number is a happy number,
     * the process will be stuck in a cycle on number ‘1,’ and if the number is not a happy number then the process will be stuck in a cycle with a set of numbers.
     * As we saw in Example-2 while determining if ‘12’ is a happy number or not, our process will get stuck in a cycle with the following numbers: 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89
     *
     * We saw in the LinkedList Cycle problem that we can use the Fast & Slow pointers method to find a cycle among a set of elements.
     * As we have described above, each number will definitely have a cycle. Therefore, we will use the same fast & slow pointer strategy to find the cycle and once the cycle is found,
     * we will see if the cycle is stuck on number ‘1’ to find out if the number is happy or not.
     *
     * @param number
     * @return
     */
    @TimeComplexity("O(Log n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
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
