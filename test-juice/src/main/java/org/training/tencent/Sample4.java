package org.training.tencent;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * Created by Anderson on 2018/12/13
 */
interface IHelloPrinter4 {
    void print();
}

@Singleton
class SimpleHelloPrinter4 implements IHelloPrinter4 {
    public void print() {
        System.out.println("Hello, Simple World.");
    }
}

@Singleton
class ComplexHelloPrinter4 implements IHelloPrinter4 {
    public void print() {
        System.out.println("Hello, Complex World.");
    }
}

class SampleMoudle extends AbstractModule {
    @Override
    protected void configure() {
        bind(IHelloPrinter4.class).to(SimpleHelloPrinter4.class);
    }
}

@Singleton
public class Sample4 {
    @Inject
    private IHelloPrinter4 printer4;

    public void hello() {
        printer4.print();
    }
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SampleMoudle());
        Sample4 sample4 = injector.getInstance(Sample4.class);
        sample4.hello();
    }
}
