package org.training;

/**
 * Created by anderson on 18-1-12.
 * 多态
 */
class Person
{                                //定义父类Person
    int i = 5;
    static final int staticInt = 10;

    public void tell()
    {
        System.out.println("父类Person的实例方法tell()");
    }

    public static void staticTell()
    {
        System.out.println("父类Person的静态方法staticTell()");
    }
}

class Student
        extends Person
{                //定义Student类是Person类的子类
    int i = 50;
    static int staticInt = 100;

    public void tell()
    {
        System.out.println("子类Student的实例方法tell()");
    }

    public static void staticTell()
    {
        System.out.println("子类Student的静态方法staticTell()");
    }
}

public class CastTest02
{
    public static void main(String[] args)
    {
        Person per = new Student();
        System.out.println("实例成员i=" + per.i + "，静态成员staticInt=" + per.staticInt);
        per.tell();
        per.staticTell();
        Student stu = (Student) per;
        System.out.println("实例成员i=" + stu.i + "，静态成员staticInt=" + stu.staticInt);
        stu.tell();
        stu.staticTell();
    }
}
