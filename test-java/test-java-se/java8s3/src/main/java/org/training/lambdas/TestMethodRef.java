package org.training.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by kongyunlong on 2016/6/18.
 */
@FunctionalInterface
interface ToInt<T> {
    int convert(T t);
}

@FunctionalInterface
interface Interface3 {
    <T> T m(T t);
}

class MyClass3 {
    static <T> T n(T t) {
        return t;
    }
}

public class TestMethodRef {
    public static void main(String[] args) {
        //TypeName::staticMethod
        ToInt<String> t1 = Integer::parseInt;
        System.out.println(t1.convert("100"));
        //objectRef::instanceMethod
        Supplier<Integer> s1 = "Jack"::length;
        System.out.println(s1.get());

        Consumer<String> s2 = System.out::println;

        //ClassName::instanceMethod
        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("Rose and Jack"));
        //TypeName.super::instanceMethod
        Son son = new Son();
        son.m();
        //ClassName::new ；类的构造方法
        Supplier<Son> son1 = Son::new;
        Son s = son1.get();
        //调用有参数的构造方法
        Function<String, Son> fun1 = Son::new;
        Son son2 = fun1.apply("王五");
        //ArrayTypeName::new
        Function<Integer, int[]> fun2 = int[]::new;
        int[] nums = fun2.apply(5);  //大小为5的数组
        //直接使用Lambda表达式创建数组
        Function<Integer, int[]> fun3 = size -> new int[size];

        //非泛型接口，不能使用Lambda表达式，但是可以使用方法引用
        Interface3 i3 = MyClass3::n;
        System.out.println(i3.m("泛型方法"));
    }
}

class Parent {
    private String name = "张三";
    String getName() {
        return name;
    }
}

class Son extends Parent{
    public Son() {
    }
    public Son(String name) {
        this.name = name;
    }
    private String name = "张四";
    String getName() {
        return name;
    }

    void m() {
       Supplier<String> s1 = this::getName;
       Supplier<String> s2 = Son.super::getName;
        System.out.println(s1.get());
        System.out.println(s2.get());
    }
}