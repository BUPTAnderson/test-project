package org.training.csdn.five;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * 静态绑定，绑定到静态属性
 * Created by Anderson on 2019/7/9
 */
public class StaticMultiInterfaceServiceDemo {
    @Inject
    @One
    private static Service oneService;

    @Inject
    @Two
    private static Service twoService;

    public static void main(String[] args) {
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(One.class).to(OneService.class);
                binder.bind(Service.class).annotatedWith(Two.class).to(TwoService.class);
                binder.requestStaticInjection(StaticMultiInterfaceServiceDemo.class);
            }
        });
        StaticMultiInterfaceServiceDemo.oneService.execute();
        StaticMultiInterfaceServiceDemo.twoService.execute();
    }
}
