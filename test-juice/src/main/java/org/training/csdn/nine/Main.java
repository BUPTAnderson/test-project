package org.training.csdn.nine;

import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;

import java.util.EnumSet;

/**
 * guice guic-servlet
 * 链接：http://www.blogjava.net/xylz/archive/2009/12/27/307464.html
 * Created by Anderson on 2019/7/9
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server(8080);
        ServletContextHandler root = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

        root.addEventListener(new MyGuiceServletContextListener());
        root.addFilter(GuiceFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
        root.addServlet(HelloWorldServlet.class, "/*");

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
