package org.training.generics;

/**
 * Created by kongyunlong on 2016/5/26.
 */
public class GenericMethodDemo<T> {
    public <V> GenericMethodDemo(V v) {
    }
    public <V> GenericMethodDemo() {
    }

    public <V>  void m(V v, T t) {
        //T t = new T();//错误
        System.out.println("m()");
    }

    public void provide(T t){
    }

    //错误，不能将类的泛型应用在静态方法中
//    public static <V> V m1(V v, T t) {
//    }
    public static <V> V m1(V v) {
        return null;
    }
    public static void main(String[] args) {
        GenericMethodDemo<String> demo1 = new<Integer> GenericMethodDemo<String>(100);
        GenericMethodDemo<Integer> demo2 = new<String> GenericMethodDemo<Integer>("abc");
        GenericMethodDemo<String> demo3 = new<String> GenericMethodDemo<String>("def");
        GenericMethodDemo<String> demo4 = new GenericMethodDemo<String>("def");
        GenericMethodDemo demo = new GenericMethodDemo();
        demo.m("abc", "cde");
        demo.<String>m("1", "c");
        demo.<Integer>m(20, "def");
//        demo.<String>m(1);   //报错
        GenericMethodDemo.m1("One");
        GenericMethodDemo.<String>m1("One");
        GenericMethodDemo.<Integer>m1(200);
    }
}
