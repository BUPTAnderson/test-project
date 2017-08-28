package org.training.lambdas;

import java.util.function.Consumer;

/**
 * Created by kongyunlong on 2016/6/19.
 */
public class ScopeDemo {
//    static int num = 10;
    public static void main(String[] args) {
        int num = 20;
        Consumer<Integer> c1 = n -> System.out.println(num + n); //可以使用已经声明的变量
//        num = 30;
        c1.accept(20);
    }
}
