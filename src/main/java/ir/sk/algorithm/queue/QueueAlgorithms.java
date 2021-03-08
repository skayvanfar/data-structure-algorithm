package ir.sk.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAlgorithms {

    /**
     * In the Josephus problem from antiquity, N people are in dire straits and agree to the following
     * strategy to reduce the population. They arrange themselves in a circle (at positions numbered
     * from 0 to N–1) and proceed around the circle, eliminating every Mth person until only one person
     * is left. Legend has it that Josephus ﬁgured out where to sit to avoid being eliminated. Write a
     * Queue client Josephus that takes N and M from the command line and prints out the order in which
     * people are eliminated (and thus would show Josephus where to sit in the circle).
     *
     * @param n
     * @param m
     * @return
     */
    public static String josephus(int n, int m) {
        // Create queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // enqueue
            q.add(i);
        }
        // Determine order of dequeue
        String result = "";
        for (int i = 1; !q.isEmpty(); i++) {
            // dequeue
            int j = q.poll();
            if (i % m > 0) q.add(j);
            else           result += j + " ";
        }
        return result;
    }
}
