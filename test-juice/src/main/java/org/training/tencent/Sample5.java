package org.training.tencent;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Names;

import javax.inject.Named;

/**
 * Created by Anderson on 2018/12/13
 */
interface IHelloPrinter5 {
    void print();
}

@Singleton
class SimpleHelloPrinter5 implements IHelloPrinter5 {
    @Override
    public void print() {
        System.out.println("Hello, Simple World");
    }
}

@Singleton
class ComplexHelloPrinter5 implements IHelloPrinter5 {
    @Override
    public void print() {
        System.out.println("Hello, Complex World");
    }
}

class SampleModule5 extends AbstractModule {
    @Override
    protected void configure() {
        bind(IHelloPrinter5.class).annotatedWith(Names.named("simple")).to(SimpleHelloPrinter5.class);
        bind(IHelloPrinter5.class).annotatedWith(Names.named("complex")).to(ComplexHelloPrinter5.class);
    }
}

@Singleton
public class Sample5 {
    @Inject
    @Named("simple")
    private IHelloPrinter5 simple;

    @Inject
    @Named("complex")
    private IHelloPrinter5 complex;

    public void hello() {
        simple.print();
        complex.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SampleModule5());
        Sample5 sample5 = injector.getInstance(Sample5.class);
        sample5.hello();
    }
}
