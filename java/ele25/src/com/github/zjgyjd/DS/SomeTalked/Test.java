package com.github.zjgyjd.DS.SomeTalked;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
 @interface Test {
    boolean enabled()default true;
}
