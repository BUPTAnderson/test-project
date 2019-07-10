package org.training.csdn.nine;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * Created by Anderson on 2019/7/9
 */
public class MyGuiceServletContextListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            protected void configureServlets() {
                serve("/helloworld").with(HelloWorldServlet.class);
            }
        });
    }
}
