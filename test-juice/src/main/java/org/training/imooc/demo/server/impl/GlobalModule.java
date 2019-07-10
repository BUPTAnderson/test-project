package org.training.imooc.demo.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/**
 * Created by Anderson on 2019/7/10
 */
public class GlobalModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<String> currencyBinder = Multibinder.newSetBinder(binder(), String.class);
        currencyBinder.addBinding().toInstance("EUR");
        currencyBinder.addBinding().toInstance("USD");
    }
}
