package ir.sk.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * Created by sad.keyvanfar on 8/23/2020.
 */
@Inherited
public @interface Point {
    String description() default "";
}
