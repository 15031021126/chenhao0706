package com.bawei.yk.test;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
 *@Auther:陈浩
 *@Date: 2019/7/27
 *@Time:15:24
 *@Description:${DESCRIPTION}
 * */public class Test {

    public static void main(String[] args) {
        Class<Book> c1 = Book.class;
        try {
            System.out.println("Test3: " +      c1.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
