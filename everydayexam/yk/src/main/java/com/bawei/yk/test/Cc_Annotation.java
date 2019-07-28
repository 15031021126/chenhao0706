package com.bawei.yk.test;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:20:42
 *@Description:${自定义注解}
 *
 * */
public @interface Cc_Annotation {

    //注解中的两个属性 id 与 mes
    int id();

    String msg() default "i am cc";

    //注解的使用对主街道额属性进行呢赋值
    @Cc_Annotation(id = 1, msg = "c")
    public class A {

    }
}
