package ir.sk.algorithm.basic;

import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;

import java.util.Arrays;
import java.util.Random;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 7/2/2020.
 */
public class Utils {


    /**
     * @param a
     * @param b
     */
    public static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
    }

    /**
     * swap all primitive data
     * b = swap(a, a=b);
     * usage: z = swap(a, a=b, b=c, ... y=z);
     *
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T gSwap(T... args) {
        return args[0];
    }

    /**
     * @param elements
     * @param index1
     * @param index2
     */
    @TimeComplexity("O(1)")
    public static void swapInArray(int[] elements, int index1, int index2) {
        int tmp = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = tmp;
    }

    /**
     * checks if a number is prime by checking for divisibility on numbers less than it. It only
     * needs to go up to the square root of n because if n is divisible by a number greater than its square root then
     * it's divisible by something smaller than it.
     *
     * @param n
     * @return
     */
    @TimeComplexity("O(sqrt(n))=O(n)")
    @SpaceComplexity("O(1)")
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) { // i * i <= n ==> sqrt
            if (n % i == 0)
                return false;
        }
        return true;
    }

    /**
     * The Sieve of Eratosthenes is a highly efficient way to generate a list of primes. It works by recognizing that
     * all non-prime numbers are divisible by a prime number.
     * <p>
     * We start with a list of all the numbers up through some value max. First, we cross off all numbers divisible by
     * 2. Then, we look for the next prime (the next non-crossed off number) and cross off all numbers divisible by
     * it. By crossing off all numbers divisible by 2, 3, 5, 7, 11, and so on, we wind up with a list of prime numbers
     * from 2 through max.
     *
     * @param max
     * @return
     */
    public static boolean[] sieveOfEratosthenesFindPrimes(int max) {
        boolean[] flags = new boolean[max + 1];

        init(flags); // Set all flags to true other than 0 and 1
        int prime = 2;
        while (prime <= Math.sqrt(max)) {

            /* Cross off remaining multiples of prime */
            crossOff(flags, prime);

            /* Find next value which is true */
            prime = getNextPrime(flags, prime);
        }

        return flags;
    }

    /**
     * Set all flags to true other than 0 and 1
     *
     * @param flags
     */
    private static void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++)
            flags[i] = true;
    }

    /**
     * @param flags
     * @param prime
     */
    private static void crossOff(boolean[] flags, int prime) {
        /* Cross off remaining multiples of prime. We can start with (prime*prime),
         * because if we have a k * prime, where k < prime, this value would have
         * already been crossed off in a prior iteration. */
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    /**
     * @param flags
     * @param prime
     * @return
     */
    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }


    /**
     * randomPermutationGenerator
     *
     * The idea is to start from the last element, swap it with a randomly selected element from the whole array (including last).
     * Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int[] shuffleByFisherYates(int[] arr) {
        // Creating a object for Random class
        Random r = new Random();

        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = arr.length - 1; i > 0; i--) {

            // Pick a random index from 0 to i
            // o(1)
            int j = r.nextInt(i + 1);

            // Swap arr[i] with the element at random index
            Utils.swapInArray(arr, i, j);
        }
        return arr;
    }

}
