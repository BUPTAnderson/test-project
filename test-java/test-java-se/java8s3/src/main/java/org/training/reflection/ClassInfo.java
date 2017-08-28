package org.training.reflection;

import java.io.Serializable;
import java.lang.reflect.Modifier;

/**
 * Created by kongyunlong on 2016/5/29.
 */
abstract class Person<T> extends Thread implements Serializable {
}

public class ClassInfo {
    public static void main(String[] args) {
        Class<Person> c = Person.class;
        System.out.println(c.getName());        //com.jd.reflection.Person
        System.out.println(c.getSimpleName());  //Person
        System.out.println(c.getPackage());     //package com.jd.reflection
        System.out.println(c.isPrimitive());    //false //是不是基本类型
        System.out.println(c.isInterface());    //false //是不是接口
        Class<?> sc = c.getSuperclass();        //获取父类
        System.out.println(sc.getName());       //java.lang.Thread
        Class<?>[] si = c.getInterfaces();
        for (Class class1 : si) {
            System.out.println(class1.getName());  //java.io.Serializable
        }
        int mod = Serializable.class.getModifiers(); //获取修饰符
        System.out.println(Modifier.toString(mod));  //public abstract interface

        System.out.println(c.toGenericString());     //abstract class com.jd.reflection.Person<T>
    }
}
