package org.training.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by kongyunlong on 2016/6/9.
 */
public class DogTest {
    public static void main(String[] args) {
        Class<Dog> c = Dog.class;
//        try {
//            c.newInstance();        //调用无参的构造方法
//        } catch (InstantiationException e) { //没有无参构造方法会报该异常
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {  //对无参构造方法没有访问权限报该异常
//            e.printStackTrace();
//        }
//
//        try {
//            Constructor constructor = c.getConstructor(String.class);
//            Dog d = (Dog)constructor.newInstance("旺财");
//            Method m = c.getDeclaredMethod("m1");
//            System.out.println(m.invoke(d));
//
//            Method m2 = c.getDeclaredMethod("m2", String.class);
//            System.out.println(m2.invoke(d, "test"));
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        try {
            Field f = c.getDeclaredField("name");
            Constructor constructor = c.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            Dog d = (Dog) constructor.newInstance("旺财");
            f.setAccessible(true);
            f.set(d, "小花");
            System.out.println(f.get(d));
            Field f2 = c.getDeclaredField("age");
            f2.setInt(d, 3);
            System.out.println("age:" + f2.getInt(d));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
