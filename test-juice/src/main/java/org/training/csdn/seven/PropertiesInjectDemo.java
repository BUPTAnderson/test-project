package org.training.csdn.seven;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Properties;

/**
 * Created by Anderson on 2018/12/11
 */
public class PropertiesInjectDemo {
    @Inject
    @Named("csdn")
    private String csdn;

    public static void main(String[] args) {
        PropertiesInjectDemo instance = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                Properties prooperties = new Properties();
                prooperties.setProperty("csdn", "www.csdn.com");
                Names.bindProperties(binder, prooperties);
            }
        }).getInstance(PropertiesInjectDemo.class);

        System.out.println(instance.csdn);
    }
}
