package org.training.generics;

/**
 * Created by kongyunlong on 2016/5/29.
 */
public class Generics<T> {
    private T obj;

    public Generics() {
    }

    public Generics(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
