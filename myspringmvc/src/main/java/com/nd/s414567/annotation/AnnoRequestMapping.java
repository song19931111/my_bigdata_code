package com.nd.s414567.annotation;

import java.lang.annotation.*;

/**
 * describe:
 *
 * @author nd.414567
 * @date 2018/07/10
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnoRequestMapping {
    String value() default "";
}
