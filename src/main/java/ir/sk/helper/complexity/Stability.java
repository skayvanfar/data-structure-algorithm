package ir.sk.helper.complexity;

/**
 * Stable sort algorithms sort repeated elements in the same order that they appear in the input.
 * <p>
 * Created by sad.kayvanfar on 9/21/2020.
 */
public @interface Stability {
    boolean value() default true;
}
