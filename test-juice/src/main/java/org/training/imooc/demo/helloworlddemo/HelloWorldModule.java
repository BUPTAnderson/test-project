package org.training.imooc.demo.helloworlddemo;

import com.google.inject.AbstractModule;
import org.training.imooc.demo.MyApplet;

import java.io.PrintStream;

/**
 * Created by Anderson on 2019/7/10
 */
public class HelloWorldModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWriteingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("Hello world");
    }
}
