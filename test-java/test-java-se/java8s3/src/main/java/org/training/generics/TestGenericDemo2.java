package org.training.generics;

/**
 * Created by anderson on 16-8-29.
 */
public class TestGenericDemo2<T> implements TestGeneric<String> {
    public T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        TestGenericDemo2<Integer> demo2 = new TestGenericDemo2<>();
        demo2.setT(100);
        System.out.println(demo2.getT());
    }
}
