package org.training.csdn.six;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;

/**
 * 使用Provider注入服务
 * 链接：https://blog.csdn.net/u010834071/article/details/46708025
 * Created by Anderson on 2019/7/9
 */
public class ProviderServiceDemo {
    @Inject
    private Service service;

    public static void main(String[] args) {
        ProviderServiceDemo instance = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).toProvider(OneServiceProvider.class);
            }
        }).getInstance(ProviderServiceDemo.class);
        instance.service.execute();
    }
}
