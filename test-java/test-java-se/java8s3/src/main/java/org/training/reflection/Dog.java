package org.training.reflection;

/**
 * Created by kongyunlong on 2016/6/9.
 */
public class Dog {
    public int age;
    private String name;
    public Dog() {
        System.out.println("Dog 构造方法");
    }
    private Dog(String name) {
        System.out.println("Dog 构造方法 " + name);
    }
    public void m1() {
        System.out.println("m1");
    }
    public int m2(String s) {
        System.out.println("m2");
        return 1;
    }
}
