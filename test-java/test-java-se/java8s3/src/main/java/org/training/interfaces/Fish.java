package org.training.interfaces;

/**
 * Created by anderson on 16-6-6.
 */
public interface Fish {
    default void swim() {
        System.out.println("");
    }
    default void voice() {
        System.out.println("嘟嘟");
    }
}
