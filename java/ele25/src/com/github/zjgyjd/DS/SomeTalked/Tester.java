package com.github.zjgyjd.DS.SomeTalked;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//用给谁
@Retention(RetentionPolicy.RUNTIME)//策略决定可以看到的程度
public @interface Tester {
    String author();
    String date();
}
