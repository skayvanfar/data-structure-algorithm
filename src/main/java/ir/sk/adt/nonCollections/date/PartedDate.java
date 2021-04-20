package ir.sk.adt.nonCollections.date;

/**
 * Created by sad.kayvanfar on 4/20/2021.
 */
public class PartedDate implements Date {

    private final int month;
    private final int day;
    private final int year;

    public PartedDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    @Override
    public int month() {
        return month;
    }

    @Override
    public int day() {
        return day;
    }

    @Override
    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
}
