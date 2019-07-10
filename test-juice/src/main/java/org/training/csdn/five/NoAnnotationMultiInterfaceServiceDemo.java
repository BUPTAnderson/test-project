package org.training.csdn.five;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * Created by Anderson on 2019/7/9
 */
public class NoAnnotationMultiInterfaceServiceDemo {
    @Inject
    @Named("One")
//    private static Service oneService;
    private Service oneService;

    @Inject
    @Named("Two")
//    private static Service twoService;
    private Service twoService;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(Names.named("One")).to(OneService.class);
                binder.bind(Service.class).annotatedWith(Names.named("Two")).to(TwoService.class);
//                binder.requestStaticInjection(NoAnnotationMultiInterfaceServiceDemo.class);
            }
        });

//        NoAnnotationMultiInterfaceServiceDemo.oneService.execute();
//        NoAnnotationMultiInterfaceServiceDemo.twoService.execute();

        NoAnnotationMultiInterfaceServiceDemo noAnnotationMultiInterfaceServiceDemo = injector.getInstance(NoAnnotationMultiInterfaceServiceDemo.class);
        noAnnotationMultiInterfaceServiceDemo.oneService.execute();
        noAnnotationMultiInterfaceServiceDemo.twoService.execute();
    }
}
