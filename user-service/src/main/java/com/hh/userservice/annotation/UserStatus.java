package com.hh.userservice.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Inherited
public @interface UserStatus {
    String value() default "update";
}
