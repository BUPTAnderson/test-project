package org.training.generics;

import java.io.IOException;
import java.io.SyncFailedException;

/**
 * Created by kongyunlong on 2016/5/26.
 */
public class TestWrapperUtil {
    public static void main(String[] args) {
//        ObjectWrapper<Object> w1 = new ObjectWrapper<>("hello");
//        WrapperUtil.print(w1);
//        ObjectWrapper<Integer> w2 = new ObjectWrapper<>(100);
//        WrapperUtil.print(w2);
        ObjectWrapper<?> w3 = new ObjectWrapper<>(12);
//        w3.set(12);

        ObjectWrapper<Integer> w5 = new ObjectWrapper<>(100);
        ObjectWrapper<Object> w6 = new ObjectWrapper<>("abc");
        System.out.println(w6.get());
        WrapperUtil.copy(w5, w6);
        System.out.println(w6.get());

//        ObjectWrapper<?> wrapper = new ObjectWrapper<>(12);
//        wrapper.set(15); //报错
//        ObjectWrapper<? extends Exception> extendWrapper = new ObjectWrapper<>(new IOException());
//        extendWrapper.set(new Exception()); //报错,改成new IOException()仍然报错
        ObjectWrapper<? super IOException> superWrapper = new ObjectWrapper<>(new Exception());
        superWrapper.set(new IOException()); //正确，只能是IOException
        superWrapper.set(new SyncFailedException(""));
    }
}
