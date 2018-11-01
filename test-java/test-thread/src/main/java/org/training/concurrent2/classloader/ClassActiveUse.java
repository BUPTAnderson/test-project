package org.training.concurrent2.classloader;

import java.util.Random;

public class ClassActiveUse {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. new直接使用
//        new Obj();
        // 2. 访问静态变量
//        System.out.println(I.a);
//        System.out.println(Obj.salary);
        // 3. 调用静态方法
//        Obj.printSalary();
        // 4. 反射某各类
//        Class.forName("org.training.concurrent2.classloader.Obj");
        // 5. 初始化子类的时候父类也会被初始化
        System.out.println(Child.age);
        // 6. 直接通过命令java className

        // 被动加载
        // 1. 调用父类的静态变量。子类不会初始化，父类会初始化
//        System.out.println(Child.salary);

        // 2. 创建数组，Obj不会初始化
//        Obj[] arrays = new Obj[10];
        // 3. 调用类的常量，该常量在编译期值是确定的。则该类不会初始化，因为常量会被放到常量池中。
        // 调用y，Obj不会初始化，调用x，Obj会初始化，因为y值在编译时就能确定下来，x值在编译时无法确定
//        System.out.println(Obj.y);
//        System.out.println(Obj.x);
    }
}

class Obj {
    public static long salary = 100000L;
    public static final long y = 100000L;
    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("Obj 被初始化");
    }

    public static void printSalary() {
        System.out.println("==========Obj=printSalary");
    }
}

class Child extends Obj {
    public static int age = 32;

    static {
        System.out.println("Child 被初始化。");
    }
}

interface I {
     int a = 10;
}