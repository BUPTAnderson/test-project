package org.training.tencent;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 链接：https://cloud.tencent.com/developer/article/1186480
 * Created by Anderson on 2018/12/12
 */
//@Singleton
class HelloPrinter {
    public void print() {
        System.out.println("Hello, world");
    }
}

@Singleton
public class Sample {
    @Inject
    private HelloPrinter printer;

    public void hello() {
        printer.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Sample sample = injector.getInstance(Sample.class);
        sample.hello();

        Sample sample1 = injector.getInstance(Sample.class);
        System.out.println(sample == sample1);
        System.out.println(sample.hashCode());
        System.out.println(sample1.hashCode());
        System.out.println(sample.printer == sample1.printer);
        System.out.println(sample.printer.hashCode());
        System.out.println(sample1.printer.hashCode());
    }
}
