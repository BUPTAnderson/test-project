package org.training.tencent;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by Anderson on 2018/12/12
 */
class HelloPrinter2 {
    private static int counter;
    private int myCounter;

    public HelloPrinter2() {
        myCounter = counter++;
    }

    public void print() {
        System.out.printf("Hello, world %d\n", myCounter);
    }
}
public class Sample3 {
    @Inject
    private HelloPrinter2 printer2;

    public void hello() {
        printer2.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Sample3 sample3 = injector.getInstance(Sample3.class);
        System.out.println(sample3.hashCode());
        sample3.hello();
        sample3 = injector.getInstance(Sample3.class);
        System.out.println(sample3.hashCode());
        sample3.hello();
        sample3 = injector.getInstance(Sample3.class);
        System.out.println(sample3.hashCode());
        sample3.hello();
    }
}
