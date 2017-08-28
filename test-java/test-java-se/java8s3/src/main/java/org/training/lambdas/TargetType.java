package org.training.lambdas;

/**
 * Created by kongyunlong on 2016/6/18.
 */
@FunctionalInterface
interface Interface1 {
    void m(int num1, int num2);
}

@FunctionalInterface
interface Interface2 {
    void m(String num1, String num2);
}

public class TargetType {
    static void test1(Interface1 i) {
    }

    static void test1(Interface2 i) {
    }

    public static void main(String[] args) {
        Interface1 i1 = (num1, num2) -> System.out.println(num1 + num2);
        //test1方法重载，下面这句会报错
//        test1((num1, num2) -> System.out.println(num1 + num2));
        //解决方法1：明确Lambda表达式的参数类型
        test1((String num1, String num2) -> System.out.println(num1 + num2));
        //解决方法:3：不要直接传Lambda表达式，而是先赋值给接口类型的变量，再将变量传入方法
        test1(i1);
        Interface2 i2 = (num1, num2) -> System.out.println(num1 + num2);
        test1(i2);
        //解决方法2：使用强制类型转换
        test1((Interface1) (num1, num2) -> System.out.println(num1 + num2));
    }
}
