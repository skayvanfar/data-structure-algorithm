package ir.sk.algorithm.array;

import ir.sk.helper.*;
import ir.sk.helper.complexity.InPlace;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.*;
import ir.sk.helper.paradigm.*;

import java.util.*;

/**
 * Created by sad.kayvanfar on 1/10/2021.
 */
public class ArrayAlgorithms {

    /**
     * We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index. Now,
     * if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
     * You should assume that the array is circular which means two things:
     * <p>
     * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
     * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
     * Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static boolean loopExistsInCircularArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isForward = array[i] >= 0;
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we ca't find cycle for this number
            do {
                slow = findNextIndex(array, isForward, slow); // move one step for slow pointer
                fast = findNextIndex(array, isForward, fast); // move one step for fast pointer
                if (fast != -1)
                    fast = findNextIndex(array, isForward, fast); // move another step for fast pointer
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    private static int findNextIndex(int[] array, boolean isForward, int currentIndex) {
        boolean direction = array[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + array[currentIndex]) % array.length;
        if (isForward != direction)
            return -1; // change in direction, return -1

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    /**
     * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
     * <p>
     * use two pointers starting at both the ends of the input array. At any step,
     * whichever pointer gives us the bigger square we add it to the result array and move to the next/previous number according to the pointer.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    @TwoPointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static int[] makeSquaresSortedArray(int[] array) {
        int[] squares = new int[array.length];
        int highestSquareIds = array.length - 1;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int leftSquare = array[left] * array[left];
            int rightSquare = array[right] * array[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIds--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIds--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Magic Index (Fixed Point): A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
     * i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
     * array A.
     * <p>
     * Linearly search for an index i such that arr[i] == i. Return the first such index found.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static int magicIndexNaive(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i)
                return i;
        }
        return -1;
    }

    /**
     * See {@link #magicIndexNaive(int[])}
     *
     * @param array
     * @return
     */
    public static int magicIndexBinarySearch(int[] array) {
        return magicIndexBinarySearch(array, 0, array.length - 1);
    }


    /**
     * First check whether middle element is Fixed Point or not. If it is, then return it;
     * otherwise check whether index of middle element is greater than value at the index.
     * If index is greater, then Fixed Point(s) lies on the right side of the middle point
     * (obviously only if there is a Fixed Point). Else the Fixed Point(s) lies on left side.
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(Log n)")
    @SpaceComplexity("O(1)")
    @ModifiedBinarySearchPattern
    @DecreaseAndConquer
    private static int magicIndexBinarySearch(int arr[], int low, int high) {
        if (high >= low) {
            /* low + (high - low)/2; */
            int mid = (low + high) / 2;
            if (mid == arr[mid])
                return mid;
            if (mid > arr[mid])
                return magicIndexBinarySearch(arr, (mid + 1), high);
            else
                return magicIndexBinarySearch(arr, low, (mid - 1));
        }

        return -1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given an array arr[] of positive integers, the task is to find whether it is possible to make this array strictly decreasing by modifying at most one element.
     * <p>
     * For every element arr[i], if it is greater than both arr[i – 1] and arr[i + 1] or it is smaller than both arr[i – 1] and arr[i + 1] then arr[i] needs to be modified.
     * i.e arr[i] = (arr[i – 1] + arr[i + 1]) / 2. If after modification, arr[i] = arr[i – 1] or arr[i + 1] then the array cannot be made strictly decreasing without affecting at most one element else count all such modifications, if the count of modifications in the end is less than or equal to 1 then print Yes else print No.
     *
     * @return
     */
    @TimeComplexity("O(n)")
    public static boolean checkPossibility(int[] arr) {
        int n = arr.length;

        // To store the number of modifications
        // required to make the array
        // strictly decreasing
        int modify = 0;

        // Check whether the last element needs
        // to be modify or not
        if (arr[n - 1] >= arr[n - 2]) {
            arr[n - 1] = arr[n - 2] - 1;
            modify++;
        }

        // Check whether the first element needs
        // to be modify or not
        if (arr[0] <= arr[1]) {
            arr[0] = arr[1] + 1;
            modify++;
        }

        // Loop from 2nd element to the 2nd last element
        for (int i = n - 2; i > 0; i--) {

            // Check whether arr[i] needs to be modified
            if ((arr[i - 1] <= arr[i] && arr[i + 1] <= arr[i])
                    || (arr[i - 1] >= arr[i] && arr[i + 1] >= arr[i])) {

                // Modifying arr[i]
                arr[i] = (arr[i - 1] + arr[i + 1]) / 2;
                modify++;

                // Check if arr[i] is equal to any of
                // arr[i-1] or arr[i+1]
                if (arr[i] == arr[i - 1] || arr[i] == arr[i + 1])
                    return false;
            }
        }

        // If more than 1 modification is required
        if (modify > 1)
            return false;

        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given a list of numbers, where every number shows up twice except for one number, find that one number.
     * <p>
     * Input: [4, 3, 2, 4, 1, 3, 2]
     * Output: 1
     * <p>
     * One solution is to check every element if it appears once or not. Once an element with a single occurrence is found, return it. Time complexity of this solution is O(n2).
     * <p>
     * A better solution is to use hashing.
     * 1) Traverse all elements and put them in a hash table. Element is used as key and the count of occurrences is used as the value in the hash table.
     * 2) Traverse the array again and print the element with count 1 in the hash table.
     * This solution works in O(n) time but requires extra space.
     * The best solution is to use XOR. XOR of all array elements gives us the number with a single occurrence. The idea is based on the following two facts.
     * a) XOR of a number with itself is 0.
     * b) XOR of a number with 0 is number itself.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @BitwiseXORPattern
    public static int findSingleNumber(int array[]) {
        // Do XOR of all elements and return
        int res = array[0];
        for (int i = 1; i < array.length; i++)
            res = res ^ array[i];

        return res;
    }

    /**
     * There are n people lined up, and each have a height represented as an integer.
     * A murder has happened right in front of them,
     * and only people who are taller than everyone in front of them are able to see what has happened.
     * How many witnesses are there?
     * <p>
     * Example:
     * Input: [3, 6, 3, 4, 1]
     * Output: 3
     * Explanation: Only [6, 4, 1] were able to see in front of them.
     * #
     * #
     * # #
     * ####
     * ####
     * #####
     * 36341                                 x (murder scene)
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.EASY)
    public static int witnesses(int[] array) {
        int count = 1;
        int max = array[array.length - 1];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > max) {
                count++;
                max = array[i];
            }
        }
        return count;
    }

    /**
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     *
     * @param array
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @InPlace
    @Difficulty(type = DifficultyType.EASY)
    public static void pushZerosToEnd(int[] array) {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < array.length; i++)
            if (array[i] != 0)
                array[count++] = array[i]; // here count is
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < array.length)
            array[count++] = 0;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    // Kth Largest Element in an Array

    /**
     * Given a list, find the k-th largest element in the list.
     * <p>
     * A brute-force solution is to simply sort the array and find out the element at the Kth place.
     * <p>
     * Input: list = [3, 5, 2, 4, 6, 8], k = 3
     * Output: 5
     *
     * @param arr
     * @param k
     * @return
     */
    @TimeComplexity("O(nlogn)")
    @Difficulty(type = DifficultyType.MEDIUM)
    @BruteForce
    public static int findKthLargestBySorting(int[] arr, int k) {
        Arrays.sort(arr); // or using optimization by QuickSelect
        return arr[arr.length - k];
    }

    /**
     * the algorithm process will be like:
     * <p>
     * Traverse the array elements and put them into a K size min heap. If the heap size is larger than K, pop out the root element.
     * Repeat this process until the end of the array.
     * <p>
     * Return the root element of the min heap as it is the Kth largest element of the whole array.
     *
     * @param nums
     * @param k
     * @return
     */
    @TimeComplexity("O(NlogK)")
    @TopKElementsPattern
    public static int findKthLargest(int[] nums, int k) {
        // Create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));

        // Insert the array elements into the min heap.
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            // Pop out the root element if the min heap size is larger than k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * You are given an array of integers. Return the largest product that can be made by multiplying any 3 integers in the array.
     * <p>
     * A simple solution is to check for every triplet using three nested loops.
     *
     * @param arr
     * @param n
     * @return
     */
    @TimeComplexity("O(n^3)")
    @SpaceComplexity("O(1)")
    public static int maxProductThreeNaive(int[] arr, int n) {
        // if size is less than
        // 3, no triplet exists
        if (n < 3)
            return -1;

        // will contain max product
        int max_product = Integer.MIN_VALUE;

        for (int i = 0; i < n - 2; i++)
            for (int j = i + 1; j < n - 1; j++)
                for (int k = j + 1; k < n; k++)
                    max_product = Math.max(max_product,
                            arr[i] * arr[j] * arr[k]);

        return max_product;
    }

    /**
     * Sort the array using some efficient in-place sorting algorithm in ascending order.
     * Return the maximum of product of last three elements of the array and product of first two elements and last element.
     *
     * @param arr
     * @param n
     * @return
     */
    @TimeComplexity("nlogn")
    @SpaceComplexity("O(1)")
    public static int maxProductThreeBySorting(int arr[], int n) {
        // if size is less than 3, no triplet exists
        if (n < 3) {
            return -1;
        }

        // Sort the array in ascending order
        Arrays.sort(arr);

        // Return the maximum of product of last three
        // elements and product of first two elements
        // and last element
        return Math.max(arr[0] * arr[1] * arr[n - 1],
                arr[n - 1] * arr[n - 2] * arr[n - 3]);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * You are given an array. Each element represents the price of a stock on that particular day. Calculate and return the maximum profit you can make from buying and selling that stock only once.
     * <p>
     * For example: [9, 11, 8, 5, 7, 10]
     * <p>
     * Here, the optimal trade is to buy when the price is 5, and sell when it is 10, so the return value should be 5 (profit = 10 - 5 = 5).
     * <p>
     * (or )Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
     * See also {@link #maximumDifference(int[])} )}
     *
     * @param stock
     * @return
     */
    @TimeComplexity("O(nlogn)")
    @SpaceComplexity("O(n)")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static int buySellStock(int[] stock) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int max = Integer.MIN_VALUE;
        for (int price : stock) {
            priorityQueue.add(price);
        }

        for (int price : stock) {
            max = Math.max(max, priorityQueue.peek() - price);
            priorityQueue.remove(price);
        }
        return max;
    }

    /**
     * Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.
     * <p>
     * See also {@link #buySellStock(int[])}
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.MEDIUM)
    public static int maximumDifference(int arr[]) {
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];
        int i;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] - minElement > maxDiff)
                maxDiff = arr[i] - minElement;
            if (arr[i] < minElement)
                minElement = arr[i];
        }
        return maxDiff;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////


    /**
     * Given string str, the task is to find the minimum count of characters that need to be deleted from the string such that the frequency of each character of the string is unique.
     * <p>
     * Input: str = “ceabaacb”
     * Output: 2
     * Explanation:
     * The frequencies of each distinct character are as follows:
     * c —> 2
     * e —> 1
     * a —> 3
     * b —> 2
     * Possible ways to make frequency of each character unique by minimum number of moves are:
     * <p>
     * Removing both occurrences of ‘c’ modifies str to “eabaab”
     * Removing an occurrence of ‘c’ and ‘e’ modifies str to “abaacb”
     *
     * @param str
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(256)=O(1)")
    public static int minCntCharDeletionsfrequency(char[] str) {
        // Stores frequency of each
        // distinct character of str
        Map<Character, Integer> mp = new HashMap<>();

        // Store frequency of each distinct
        // character such that the largest
        // frequency is present at the top
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        // Stores minimum count of characters
        // required to be deleted to make
        // frequency of each character unique
        int cntChar = 0;

        // Traverse the String
        for (int i = 0; i < str.length; i++) {
            // Update frequency of str[i]
            if (mp.containsKey(str[i])) {
                mp.put(str[i], mp.get(str[i]) + 1);
            } else {
                mp.put(str[i], 1);
            }
        }

        // Traverse the map
        for (Map.Entry<Character, Integer> it : mp.entrySet()) {
            // Insert current
            // frequency into pq
            pq.add(it.getValue());
        }

        // Traverse the priority_queue
        while (!pq.isEmpty()) {
            // Stores topmost
            // element of pq
            int frequent = pq.peek();

            // Pop the topmost element
            pq.remove();

            // If pq is empty
            if (pq.isEmpty()) {

                // Return cntChar
                return cntChar;
            }

            // If frequent and topmost
            // element of pq are equal
            if (frequent == pq.peek()) {
                // If frequency of the topmost
                // element is greater than 1
                if (frequent > 1) {
                    // Insert the decremented
                    // value of frequent
                    pq.add(frequent - 1);
                }

                // Update cntChar
                cntChar++;
            }
        }

        return cntChar;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Write a program which takes as input two strings s and t of bits encoding
     * binary numbers Bs and B,, respectively, and returns a new string of bits representing
     * the number Bs + Bt.
     *
     * @param array1
     * @param array2
     * @return
     */
    public static int[] addTwoArrayNumber(int[] array1, int[] array2) {
        int extra = 0;

        int size = Math.max(array1.length, array2.length);
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            int sum = array1[i] + array2[i] + extra;
            if (sum > 9) {
                result[i] = sum % 10;
                extra = sum / 10;
            } else {
                result[i] = sum;
                extra = 0;
            }
        }
        return result;
    }

    /**
     * @param inputArray
     */
    public static void sortArrayElementsByFrequency(int[] inputArray) {

        Map<Integer, Integer> elementCountMap = new LinkedHashMap<>();


        for (int i = 0; i < inputArray.length; i++) {
            elementCountMap.put(inputArray[i], elementCountMap.getOrDefault(inputArray[i], 0) + 1);
        }

        //Create an ArrayList to hold sorted elements
        ArrayList<Integer> sortedElements = new ArrayList<>();

        //Java 8 code to sort elementCountMap by values in reverse order
        //and put keys into sortedElements list

        elementCountMap.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(entry -> {
                    for (int i = 1; i <= entry.getValue(); i++)
                        sortedElements.add(entry.getKey());
                });

        //Printing sorted array elements in descending order of their frequency

        System.out.println("Input Array :" + Arrays.toString(inputArray));

        System.out.println("Sorted Array Elements In Descending Order Of their Frequency :");

        System.out.println(sortedElements);
    }
    /*

    *   A = [1, 4, 2, 3]
        B = [2, 5, 1, 6]

    * */

    ////////////////////////////////////////////////////////////////////////////////

    /**
     * Given two integers arrays A and B of size N each.
     * Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.
     * <p>
     * A = [1, 4, 2, 3]
     * B = [2, 5, 1, 6]
     * result = [10, 9, 9, 8]
     */
    @TimeComplexity("O(n^2)")
    public static int[] kMaxCombinations(int[] first, int[] second) {
        int n = first.length;
        int[] result = new int[n];
        PriorityQueue<Integer> prioriyQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                prioriyQueue.add(first[i] + second[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = prioriyQueue.poll();
        }

        return result;
    }

    private static class Pair {

        public Pair(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }

        int i1;
        int i2;

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair obj = (Pair) o;
            return (i1 == obj.i1 && i2 == obj.i2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2);
        }
    }

    private static class PairSum implements Comparable<PairSum> {

        public PairSum(int sum, int i1, int i2) {
            this.sum = sum;
            this.i1 = i1;
            this.i2 = i2;
        }

        int sum;
        int i1;
        int i2;

        @Override
        public int compareTo(PairSum o) {
            return Integer.compare(o.sum, sum);
        }
    }

    @TimeComplexity("O(nlogn)")
    @Difficulty(type = DifficultyType.HARD)
    public static List<Integer> kMaxCombinationsBetter(List<Integer> A, List<Integer> B) {

        List<Integer> result = new ArrayList<>();

        Collections.sort(A);
        Collections.sort(B);

        PriorityQueue<PairSum> sums = new PriorityQueue<>();
        HashSet<Pair> pairs = new HashSet<>();

        int i1 = A.size() - 1;
        int i2 = B.size() - 1;
        pairs.add(new Pair(i1, i2));
        sums.add(new PairSum(A.get(i1) + B.get(i2), i1, i2));

        for (int i = 0; i < A.size(); i++) {
            PairSum max = sums.poll();
            result.add(max.sum);

            i1 = max.i1 - 1;
            i2 = max.i2;

            if (i1 >= 0 && i2 >= 0 && !pairs.contains(new Pair(i1, i2))) {
                sums.add(new PairSum(A.get(i1) + B.get(i2), i1, i2));
                pairs.add(new Pair(i1, i2));
            }

            i1 = max.i1;
            i2 = max.i2 - 1;

            if (i1 >= 0 && i2 >= 0 && !pairs.contains(new Pair(i1, i2))) {
                sums.add(new PairSum(A.get(i1) + B.get(i2), i1, i2));
                pairs.add(new Pair(i1, i2));
            }

        }

        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////

    /**
     * Design a data structure to efficiently handle Q queries.
     * 1 S K: Insert a string S with key K.
     * <p>
     * 2 S K: find the count of strings having S as prefix and key greater than or equal to K.
     * <p>
     * A = [1, 1, 2, 1, 2]
     * B = ["abc", "bac", "ab", "abc", "ab"]
     * C = [5, 1, 4, 4, 4]
     * result: [1, 2]
     *
     * @param A is an integer array A of size Q denoting type of query.
     * @param B is a string array B of size Q denoting string S for each query.
     * @param C is an integer array C of size Q denoting key K for each query.
     * @return an integer array containing all the answer to query 2 in the same order they were asked.
     */
    @TimeComplexity("O(1) for search")
    @SpaceComplexity("O(n * length of string)")
    @Point("Using hashtable instead of trie")
    public static List<Integer> prefixWithKeyGreaterThanX(List<Integer> A, List<String> B, List<Integer> C) {
        int n = A.size();
        List<Integer> result = new ArrayList();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (A.get(i) == 1) {
                String pref = "";
                for (char ch : B.get(i).toCharArray()) {
                    pref += ch;
                    List<Integer> list = map.getOrDefault(pref, new ArrayList<>());
                    list.add(C.get(i));
                    map.put(pref, list);
                }
            } else if (A.get(i) == 2) {
                List<Integer> counters = map.get(B.get(i));
                if (counters == null)
                    counters = new ArrayList<>();
                int counter = 0;
                for (Integer count : counters) {
                    if (count >= C.get(i)) {
                        counter++;
                    }
                }
                result.add(counter);
            }

        }
        return result;
    }

    private static class Trie {

        private TrieNode root = new TrieNode();

        public void insert(String str, Integer value) {
            insert(root, str.toCharArray(), value, 0);
        }

        private void insert(TrieNode curNode, char[] strArray, Integer value, int index) {
            if (index == strArray.length - 1)
                return;
            char ch = strArray[index];
            TrieNode trieNode = curNode.getTrieNode(ch);
            if (trieNode == null) {
                trieNode = new TrieNode();
            }
            trieNode.add(value);
            curNode.setTrieNode(ch, trieNode);
            insert(trieNode, strArray, value, ++index);
        }

        public Long count(String prefix, int value) {
            return count(root, prefix.toCharArray(), value, 0);
        }

        private Long count(TrieNode curTrieNode, char[] prefixArray, int value, int index) {
            if (curTrieNode == null)
                return 0L;
            char ch = prefixArray[index];
            if (index == prefixArray.length - 1) {
                return curTrieNode.getCounts().stream().filter(integer -> integer >= value).count();
            }

            TrieNode trieNode = curTrieNode.getTrieNode(ch);
            return count(trieNode, prefixArray, value, ++index);
        }
    }

    private static class TrieNode {
        private TrieNode[] trieNodes = new TrieNode[26];
        private List<Integer> counts = new ArrayList<>();

        public TrieNode getTrieNode(char ch) {
            return trieNodes[ch - 'a'];
        }

        public void setTrieNode(char ch, TrieNode trieNode) {
            trieNodes[ch - 'a'] = trieNode;
        }

        public void add(Integer num) {
            counts.add(num);
        }

        public List<Integer> getCounts() {
            return counts;
        }
    }

    /**
     *
     */
    public static List<Integer> prefixWithKeyGreaterThanXByTrie(List<Integer> A, List<String> B, List<Integer> C) {
        Trie trie = new Trie();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 1) {
                trie.insert(B.get(i), C.get(i));
            } else if (A.get(i) == 2) {
                result.add(trie.count(B.get(i), C.get(i)).intValue());
            }
        }
        return result;
    }

    /**
     * Given an integer array A of size N.
     * <p>
     * You can pick B elements from either left or right end of the array A to get maximum sum.
     * <p>
     * Find and return this maximum possible sum.
     * A = [5, -2, 3 , 1, 2]
     * B = 3
     * Output 1:
     * <p>
     * 8
     *
     * @param A
     * @param B
     * @return
     */
    public static int pickFromBothSides(List<Integer> A, int B) {
        int max;
        int maxSoFar = 0;
        int start = 0;
        int end = A.size() - 1;
        for (; start < B; start++) {
            maxSoFar += A.get(start);
        }
        max = maxSoFar;
        start--;
        for (int i = 0; i < B; i++) {
            maxSoFar += A.get(end - i);
            maxSoFar -= A.get(start - i);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }

    /**
     * You are in an infinite 2D grid where you can move in any of the 8 directions
     * <p>
     * (x,y) to
     * (x-1, y-1),
     * (x-1, y)  ,
     * (x-1, y+1),
     * (x  , y-1),
     * (x  , y+1),
     * (x+1, y-1),
     * (x+1, y)  ,
     * (x+1, y+1)
     * You are given a sequence of points and the order in which you need to cover the points.. Give the minimum number of steps in which you can achieve it. You start from the first point.
     * Input 1:
     * <p>
     * A = [0, 1, 1]
     * B = [0, 1, 2]
     * Output 1:
     * <p>
     * 2
     *
     * @param A
     * @param B
     * @return
     */
    public static int coverPoints(List<Integer> A, List<Integer> B) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i + 1 >= A.size()) {
                return sum;
            }

            int xDis = Math.abs(A.get(i) - A.get(i + 1));
            int yDis = Math.abs(B.get(i) - B.get(i + 1));
            sum += Math.max(xDis, yDis);
        }
        return sum;
    }

    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * Given [100, 4, 200, 1, 3, 2]
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     *
     * @param array
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(n)")
    public static int longestConsecutive(final int[] array) {
        int n = array.length;
        HashSet<Integer> cache = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            cache.add(array[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!cache.contains(array[i] - 1)) {
                // Then check for next elements
                // in the sequence
                int j = array[i];
                while (cache.contains(j))
                    j++;

                // update  optimal length if this
                // length is more
                if (ans < j - array[i])
                    ans = j - array[i];
            }
        }
        return ans;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @TimeComplexity("O(n^2)")
    @SpaceComplexity("O(1)")
    @BruteForce
    public static int countInversions(int[] arr) {
        int n = arr.length;
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j])
                    inv_count++;

        return inv_count;
    }

    /**
     * Given an array A, count the number of inversions in the array.
     * <p>
     * Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j
     * <p>
     * Example:
     * <p>
     * A : [2, 4, 1, 3, 5]
     * Output : 3
     * as the 3 inversions are (2, 1), (4, 1), (4, 3).
     */
    @TimeComplexity("O(n log n)")
    @SpaceComplexity("O(n)")
    @MergeSortPattern
    public static int countInversionsByMergeSort(int[] arr, int l, int r) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += countInversionsByMergeSort(arr, l, m);

            // Right subarray count
            count += countInversionsByMergeSort(arr, m + 1, r);

            // Merge count
            count += mergeSortAndCount(arr, l, m, r);
        }

        return count;
    }



    private static int mergeSortAndCount(int[] arr, int l, int m, int r) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
