package ir.sk.algorithm.array;

import ir.sk.helper.Implementation;
import ir.sk.helper.ImplementationType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.RunnerPattern;
import ir.sk.helper.recursiontype.TailRecursion;
import ir.sk.helper.technique.BruteForce;
import ir.sk.helper.technique.DecreaseAndConquer;

import java.util.HashSet;

/**
 * Created by sad.kayvanfar on 1/20/2021.
 */
public class Mathematical {


    /**
     * Using loop
     *
     * @param n
     * @return
     */
    public static int triangleByLoop(int n) {
        int total = 0;
        while (n > 0) {
            total += n; // add n (column height) to total
            --n; // decrement column height
        }
        return total;
    }

    /**
     * Using Recursion
     *
     * @param n
     * @return
     */
    public static int triangleByRecursive(int n) {
        if (n == 1)
            return 1;
        else
            return (n + triangleByRecursive(n - 1));
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int div(int a, int b) {
        if (a < b)
            return 0;
        else
            return mod(a - b, b) + 1;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    @TimeComplexity("O(a/b)")
    @SpaceComplexity("O(1)")
    public static int div2(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    /**
     * computes a % b
     *
     * @param a
     * @param b
     * @return
     */
    public static int mod(int a, int b) {
        if (a < b)
            return a;
        else
            return mod(a - b, b);
    }

    /**
     * @param a
     * @param b
     * @return
     */
    @TimeComplexity("O(1)")
    @SpaceComplexity("O(1)")
    public static int mod2(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    /**
     * computes the [integer] square root of a number. If the number is not a
     * perfect square (there is no integer square root) , then it returns -1. It does this by successive
     * guessing. If n is 100, it first guesses SO. Too high? Try something lower - halfway between 1
     * and SO.
     *
     * @param n
     * @return
     */
    public static int sqrtByBinarySearch(int n) {
        return sqrt_helper(n, 1, n);
    }

    @TimeComplexity("O(log n)")
    private static int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1; // no square root
        int guess = (min + max) / 2;
        if (guess * guess == n) { // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }

    /**
     * computes the [integer] square root of a number. If the number is not
     * a perfect square (there is no integer square root), then it returns -1. It does this by trying
     * increasingly large numbers until it finds the right value (or is too high)
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(sqrt(n))")
    @SpaceComplexity("O(1)")
    public static int sqrtByIteration(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }

    /**
     * the Euclidean algorithm, or Euclid's algorithm, is an efficient method for
     * computing the greatest common divisor (GCD) of two numbers, the largest number
     * that divides both of them without leaving a remainder.
     * <p>
     * decrease-and-conquer (Divide-and-conquer algorithm) algorithm and recursive
     *
     * @param a
     * @param b
     * @return
     */
    @DecreaseAndConquer
    @Implementation(type = ImplementationType.Recursive)
    @TailRecursion
    public static int gcdByEuclidean(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcdByEuclidean(b, mod(a, b));
    }

    /**
     * @param n
     * @param m
     * @return
     */
    @TimeComplexity("O(m)")
    @SpaceComplexity("O(1)")
    public static int powerByRecursive(int n, int m) {
        if (m == 1)
            return n;
        else
            return (n * powerByRecursive(n, m - 1));
    }

    /**
     * Pascal
     *
     * @param n
     * @param m
     * @return
     */
    public static int combinationByRecursive(int n, int m) {
        if (n == m || m == 0)
            return 1;
        else
            return combinationByRecursive(n - 1, m) + combinationByRecursive(n - 1, m - 1);
    }


    /**
     * @param a
     * @param b
     * @return
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * the n-th harmonic number is the sum of the reciprocals of the first n natural numbers:
     *
     * @param N
     * @return
     */
    public static double harmonicNumber(int N) {
        double sum = 0.0;
        for (int i = 1; i <= N; i++)
            sum += 1.0 / i;
        return sum;
    }

    /**
     * absolute value of an int value
     *
     * @param x
     * @return
     */
    public static int abs(int x) {
        if (x < 0) return -x;
        else return x;
    }

    /**
     * absolute value of a double value
     *
     * @param x
     * @return
     */
    public static double abs(double x) {
        if (x < 0.0) return -x;
        else return x;
    }

    /**
     * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
     * All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.
     * <p>
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
            if (hashSet.contains(number))
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
     * <p>
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
        int slow = number, fast = number;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found cycle
        return slow == 1;
    }

    private static int findSquareSum(int number) {
        int sum = 0, digit;
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
