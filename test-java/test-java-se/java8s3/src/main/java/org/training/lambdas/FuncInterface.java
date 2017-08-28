package org.training.lambdas;

/**
 * Created by kongyunlong on 2016/6/18.
 */
@FunctionalInterface
public interface FuncInterface<T> {
    T m(T t);
    //重新定义Object中的toString方法
    String toString();
}

@FunctionalInterface
interface FuncInterface1 {
    <T> T m(T t);
    //重新定义Object中的toString方法
    String toString();
}

interface MarkerInterface {
}

class TestFunInterface {
    void test() {
        FuncInterface<String> f1 = s -> s + "abc";
        FuncInterface f2 = s -> s + "abc";
//        FuncInterface1 f3 = s -> s + "abc";

        MarkerInterface mi = (MarkerInterface & FuncInterface) s -> s + "abc";
    }
}
