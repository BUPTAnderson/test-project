package org.training.csdn.six;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * 如果不想使用Module手动关联服务的话，可以使用@ProviderBy注解。
 * Created by Anderson on 2019/7/9
 */
public class ProviderServiceDemo2 {
    @Inject
    private Service service;

    public static void main(String[] args) {
        ProviderServiceDemo2 providerServiceDemo2 = Guice.createInjector().getInstance(ProviderServiceDemo2.class);
        providerServiceDemo2.service.execute();
    }
}
