package org.training.tencent;

import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * Created by Anderson on 2018/12/12
 */
@ImplementedBy(SimpleHelloPrinter.class)
interface IHelloPrinter {
    void print();
}

@Singleton
class SimpleHelloPrinter implements IHelloPrinter {
    public void print() {
        System.out.println("Hello, Simple World");
    }
}

@Singleton
class ComplexHelloPrinter implements IHelloPrinter {
    public void print() {
        System.out.println("Hello, Complex World");
    }
}

@Singleton
public class Sample2 {
    @Inject
    private IHelloPrinter printer;

    public void hello() {
        printer.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Sample2 sample2 = injector.getInstance(Sample2.class);
        sample2.hello();
    }
}
