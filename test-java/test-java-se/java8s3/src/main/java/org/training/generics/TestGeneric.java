package org.training.generics;

/**
 * Created by anderson on 16-8-29.
 */
public interface TestGeneric<T> {
}

class TestGenericDemo1<T, S> implements TestGeneric<String> {
}

class TestGenericDemo02 implements TestGeneric<String> {
}