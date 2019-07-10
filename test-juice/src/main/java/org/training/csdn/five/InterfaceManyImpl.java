package org.training.csdn.five;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * 接口的多实现：
 * 此类的结构是注入了两个service服务，注解One和OneService关联，第二个和它一样
 *
 * 链接：https://blog.csdn.net/u010834071/article/details/46707721
 * Created by Anderson on 2019/7/9
 */
public class InterfaceManyImpl {
    @Inject
    @One
    private Service oneService;

    @Inject
    @Two
    private Service twoService;

    public static void main(String[] args) {
        InterfaceManyImpl interfaceMany = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).annotatedWith(One.class).to(OneService.class);
                binder.bind(Service.class).annotatedWith(Two.class).to(TwoService.class);
            }
        }).getInstance(InterfaceManyImpl.class);

        interfaceMany.oneService.execute();
        interfaceMany.twoService.execute();
    }
}
