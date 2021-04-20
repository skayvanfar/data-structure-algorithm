package ir.sk.adt.nonCollections.date;

/**
 * Created by sad.kayvanfar on 4/20/2021.
 */
public class SoloDate implements Date {

    private final int value;

    public SoloDate(int m, int d, int y) {
        value = y * 512 + m * 32 + d;
    }

    @Override
    public int month() {
        return (value / 32) % 16;
    }

    @Override
    public int day() {
        return value % 32;
    }

    @Override
    public int year() {
        return value / 512;
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }
}
