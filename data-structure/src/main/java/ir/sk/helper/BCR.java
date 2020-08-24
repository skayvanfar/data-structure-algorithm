package ir.sk.helper;

/**
 * Best Conceivable Runtime (BCR)
 *
 * Created by sad.keyvanfar on 8/24/2020.
 */
public @interface BCR {
    String bigOTime() default "";
    String bigOSpace() default "";
}
