package org.training.csdn.nine;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Anderson on 2019/7/9
 */

@Singleton
public class HelloWorldServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static AtomicInteger count = new AtomicInteger(1);
    @Inject
    private Injector inj;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        System.out.println(req.getSession().getId());
        System.out.println(count.getAndIncrement());
//        resp.getWriter().append("Hello, guice! " + new Date());
        inj.getInstance(HelloWorld.class).execute();
        inj.getInstance(HelloWorld.class).execute();
    }
}
