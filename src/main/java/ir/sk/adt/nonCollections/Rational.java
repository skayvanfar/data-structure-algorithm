package ir.sk.adt.nonCollections;

/**
 * Immutable ADT for Rational numbers.
 *
 * Created by sad.kayvanfar on 3/3/2021.
 */
public class Rational implements Comparable<Rational> {
    private static Rational zero = new Rational(0, 1);

    private long num;   // the numerator
    private long den;   // the denominator

    public Rational(long numerator, long denominator) {

        // deal with x/0
        if (denominator == 0) {
            throw new ArithmeticException("denominator is zero");
        }

        // reduce fraction
        long g = gcd(numerator, denominator);
        num = numerator   / g;
        den = denominator / g;

        // only needed for negative numbers
        if (den < 0) {
            den = -den;
            num = -num;
        }
    }

    /**
     * return the numerator of this rational number
     *
     * @return
     */
    public long numerator()   { return num; }

    /**
     * return the denominator of this rational number
     *
     * @return
     */
    public long denominator() { return den; }

    /**
     * return double precision representation of this rational number
     *
     * @return
     */
    public double toDouble() {
        return (double) num / den;
    }

    public String toString() {
        if (den == 1) return num + "";
        else          return num + "/" + den;
    }

    /**
     * return { -1, 0, +1 } if this < that, this = that, or this > that
     *
     * @param that
     * @return
     */
    public int compareTo(Rational that) {
        long lhs = this.num * that.den;
        long rhs = this.den * that.num;
        if (lhs < rhs) return -1;
        if (lhs > rhs) return +1;
        return 0;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Rational that = (Rational) other;
        return this.compareTo(that) == 0;
    }

    public int hashCode() {
        return this.toString().hashCode();
    }


    /**
     * create and return a new rational (r.num + s.num) / (r.den + s.den)
     *
     * @param r
     * @param s
     * @return
     */
    public static Rational mediant(Rational r, Rational s) {
        return new Rational(r.num + s.num, r.den + s.den);
    }

    private static long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (0 == n) return m;
        else return gcd(n, m % n);
    }

    private static long lcm(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        return m * (n / gcd(m, n));    // parentheses important to avoid overflow
    }

    /**
     * return this * that, staving off overflow as much as possible by cross-cancellation
     *
     * @param that
     * @return
     */
    public Rational times(Rational that) {
        // reduce p1/q2 and p2/q1, then multiply, where a = p1/q1 and b = p2/q2
        Rational c = new Rational(this.num, that.den);
        Rational d = new Rational(that.num, this.den);
        return new Rational(c.num * d.num, c.den * d.den);
    }


    /**
     * return this + that, staving off overflow
     *
     * @param that
     * @return
     */
    public Rational plus(Rational that) {

        // special cases
        if (this.compareTo(zero) == 0) return that;
        if (that.compareTo(zero) == 0) return this;

        // Find gcd of numerators and denominators
        long f = gcd(this.num, that.num);
        long g = gcd(this.den, that.den);

        // add cross-product terms for numerator
        Rational s = new Rational((this.num / f) * (that.den / g)
                + (that.num / f) * (this.den / g),
                this.den * (that.den / g));

        // multiply back in
        s.num *= f;
        return s;
    }

    public Rational negate() {
        return new Rational(-num, den);
    }

    public Rational abs() {
        if (num >= 0) return this;
        else return negate();
    }

    public Rational minus(Rational that) {
        return this.plus(that.negate());
    }


    public Rational reciprocal() { return new Rational(den, num);  }

    public Rational dividedBy(Rational that) {
        return this.times(that.reciprocal());
    }
}
