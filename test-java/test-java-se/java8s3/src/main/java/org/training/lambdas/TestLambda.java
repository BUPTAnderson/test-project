package org.training.lambdas;

/**
 * Created by anderson on 16-6-18.
 */
@FunctionalInterface
interface Divable {
    int div(int num1, int num2);
}

interface Divable1 {
    String div(String num1, String num2);
}

interface Divable2 {
    void div(String num1);
}

interface Divable3 {
    void div();
}

public class TestLambda {
    public static void main(String[] args) {
        Divable d = (int num1, int num2) -> { return num1 + num2; };
        //编译器会根据使用的环境推断出参数的类型
        //这里num1，num2省略了类型，但是不可以一个省略一个不省略，像 (int num1, num2)是错误的
        Divable dd = (num1, num2) -> { return num1 + num2; };
        Divable1 d1 = (num1, num2) -> { return num1 + num2; };
        //如果只有一个参数，不仅可以省略参数类型，同时也可省略小括号
        Divable2 d2 = msg -> { System.out.println(msg + "abc"); };
        //没有参数的话，要使用空的小括号
        Divable3 d3 = () -> { System.out.println(); };
        //带修饰符的参数，类型不能省,不能是(final  num1,  num2)
        Divable1 d11 = (final String num1, String num2) -> { return num1 + num2; };
        //实现体是表达式
        Divable1 d111 = (num1, num2) -> num1 + num2;
        //实现体是代码块
        Divable1 d1111 = (num1, num2) -> { return  num1 + num2; };
        //没有返回值，实现体是表达式
        Divable2 d22 = msg -> System.out.println(msg + "abc");
    }
}
