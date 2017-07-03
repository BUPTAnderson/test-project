package org.training.annotations;

/**
 * Created by kongyunlong on 2016/6/11.
 */
@FunctionalInterface
public interface InterfaceDemo {
    static String out() {
        return "Hello world!";
    }
    void tell();
}
