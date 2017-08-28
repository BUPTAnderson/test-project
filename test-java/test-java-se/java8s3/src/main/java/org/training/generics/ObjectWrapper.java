package org.training.generics;

/**
 * Created by kongyunlong on 2016/5/26.
 */
public class ObjectWrapper<T> {
    private T data;
    public ObjectWrapper(T data) {
        this.data = data;
    }
    public T get() {
        return data;
    }
    public void set(T t) {
        this.data = t;
    }
}
