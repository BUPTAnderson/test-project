package org.training.imooc.demo;

import com.google.inject.AbstractModule;
import org.training.imooc.demo.helloworlddemo.HelloWorldModule;

/**
 * Created by Anderson on 2019/7/10
 */
public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new HelloWorldModule());
    }

//    @Provides
//    private String getString() {
//        return "Hello world";
//    }
}
