package ir.sk.adt.nonCollections;

/**
 * defines an abstract data type that provides to clients the ability to maintain a running average of data values.
 *
 * The implementation is straightforward: it maintains a int instance
 * variable counts the number of data values seen so far and a double instance variable
 * that keeps track of the sum of the values seen so far; to compute the average it divides
 * the sum by the count.
 *
 * Created by sad.kayvanfar on 4/20/2021.
 */
public class Accumulator {

    private double total;
    private int N;

    public void addDataValue(double val) {
        N++;
        total += val;
    }

    public double mean() {
        return total / N;
    }

    public String toString() {
        return "Mean (" + N + " values): " + String.format("%7.5f", mean());
    }
}
