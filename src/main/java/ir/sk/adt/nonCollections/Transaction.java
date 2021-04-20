package ir.sk.adt.nonCollections;

import ir.sk.adt.nonCollections.date.Date;

/**
 * Created by sad.kayvanfar on 4/20/2021.
 */
public class Transaction {

    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    public String toString() {
        return who() + ", " + when() + ", " + amount();
    }
}
