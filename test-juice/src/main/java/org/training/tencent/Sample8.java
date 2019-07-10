package org.training.tencent;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

/**
 * 注入Map
 * Created by Anderson on 2018/12/13
 */
interface IHelloPrinter8 {
    void print();
}

@Singleton
class SimpleHelloPrinter8 implements IHelloPrinter8 {
    public void print() {
        System.out.println("Hello, Simple World");
    }
}

@Singleton
class ComplexHelloPrinter8 implements IHelloPrinter8 {
    public void print() {
        System.out.println("Hello, Complex World");
    }
}

class SampleModule8 extends AbstractModule {
    @Override
    protected void configure() {
        MapBinder<String, IHelloPrinter8> mapBinder = MapBinder.newMapBinder(binder(), String.class, IHelloPrinter8.class);
        mapBinder.addBinding("simple").to(SimpleHelloPrinter8.class);
        mapBinder.addBinding("complex").to(ComplexHelloPrinter8.class);
    }
}

@Singleton
public class Sample8 {
    @Inject
    private Map<String, IHelloPrinter8> printer8Map;

    public void hello() {
        for (String key : printer8Map.keySet()) {
            printer8Map.get(key).print();
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SampleModule8());
        Sample8 sample8 = injector.getInstance(Sample8.class);
        sample8.hello();
    }
}
