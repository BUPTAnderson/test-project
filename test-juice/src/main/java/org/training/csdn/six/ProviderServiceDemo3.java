package org.training.csdn.six;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provider;

/**
 * 可以注入Provider而不是注入服务
 * 由于我们OneServiceProvider每次都是构造一个新的服务出来，
 * 因此在类ProviderServiceDemo3中的provider每次获取的服务也是不一样的。
 * Created by Anderson on 2019/7/9
 */
public class ProviderServiceDemo3 {
    @Inject
    private Provider<Service> provider;

    public static void main(String[] args) {
        ProviderServiceDemo3 instance = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(Service.class).toProvider(OneServiceProvider.class);
            }
        }).getInstance(ProviderServiceDemo3.class);

        instance.provider.get().execute(); // Hello! I'M Service 1!
    }
}
