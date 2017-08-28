package org.training.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by kongyunlong on 2016/6/9.
 */
abstract class Class2{
    public void m1(){
    }
    public void m1(int num){
    }
    private void m2(){
    }
    static void m3(){
    }
    abstract void m4();
}

public class MethodInfo {
    public MethodInfo(String str) {
        System.out.println(str);
    }
    private MethodInfo(int num) {
        System.out.println(num);
    }
    public static void main(String[] args) {
        Class<Class2> c = Class2.class;
        Method[] m1 = c.getMethods();   //获取所有public方法，包括继承来的方法
        for (Method method : m1) {
            System.out.println(method.getName());
        }
        System.out.println("----------------");
        //获取当前类声明的所有方法(包括静态、抽象方法)，不包括继承来的方法
        Method[] m2 = c.getDeclaredMethods();
        for (Method method : m2) {
            System.out.println(method.getName());
        }
        System.out.println("-------------------");
        try {
            Method m3 = c.getDeclaredMethod("m1", int.class);
            System.out.println(m3.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");
        Constructor[] cs =   MethodInfo.class.getDeclaredConstructors();
        for (Constructor c1 : cs) {
            System.out.println(c1.getName());
        }
    }
}
