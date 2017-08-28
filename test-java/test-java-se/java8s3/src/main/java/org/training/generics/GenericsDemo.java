package org.training.generics;

/**
 * Created by kongyunlong on 2016/5/29.
 */
class GenericDemo2<S, T> extends Generics {
}

public class GenericsDemo<T> extends Generics<T> {
    public GenericsDemo(T t) {
        this.t = t;
    }

    public GenericsDemo() {
    }

    public T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        GenericsDemo<Integer> demo = new GenericsDemo<Integer>();
        demo.setT(100);
        System.out.println(demo.getT());
    }
}
