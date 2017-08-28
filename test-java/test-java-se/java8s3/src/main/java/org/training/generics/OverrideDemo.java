package org.training.generics;

/**
 * Created by kongyunlong on 2016/5/26.
 */
class Parent<T> {
    public void test(T t){
    }
}

class Son extends Parent<String> {
    @Override
    public void test(String t) {
        super.test(t);
    }
//    public void test(Object t){
//        super.test(t);
//    }
    public void test(Integer t) {
        String str  = t.toString();
        this.test(t);
    }
}

public class OverrideDemo {
}
