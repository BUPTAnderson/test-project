package org.training.csdn.one;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Guice的hello world
 * 链接：https://blog.csdn.net/u010834071/article/details/46698811
 * Created by Anderson on 2019/7/9
 */
public class TestGuice {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        HelloGuice helloGuice = injector.getInstance(HelloGuice.class);
        helloGuice.sayHello();
    }
}
