package ir.sk.helper.complexity;

/**
 * Best Conceivable Runtime (BCR)
 * <p>
 * Created by sad.keyvanfar on 8/24/2020.
 */
public @interface BCR {
    String bigOTime() default "";

    String bigOSpace() default "";
}
