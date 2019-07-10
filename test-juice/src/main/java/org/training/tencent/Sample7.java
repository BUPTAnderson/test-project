package org.training.tencent;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;

import java.util.Set;

/**
 * 注入Set
 * Created by Anderson on 2018/12/13
 */
interface IHelloPrinter7 {
    void print();
}

@Singleton
class SimpleHelloPrinter7 implements IHelloPrinter7 {
    public void print() {
        System.out.println("Hello, Simple World");
    }
}

@Singleton
class ComplexHelloPrinter7 implements IHelloPrinter7 {
    public void print() {
        System.out.println("Hello, Complex World");
    }
}

class SampleMoudle7 extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<IHelloPrinter7> multibinder = Multibinder.newSetBinder(binder(), IHelloPrinter7.class);
        multibinder.addBinding().to(SimpleHelloPrinter7.class);
        multibinder.addBinding().to(ComplexHelloPrinter7.class);
    }
}

@Singleton
public class Sample7 {
    @Inject
    private Set<IHelloPrinter7> printer7s;

    public void hello() {
        for (IHelloPrinter7 printer7 : printer7s) {
            printer7.print();
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SampleMoudle7());
        Sample7 sample7 = injector.getInstance(Sample7.class);
        sample7.hello();
    }
}
