package org.training.csdn.nine;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Date;

/**
 * 注意在我们的服务中需要request和response对象，并且我们的服务假定是与request绑定的，采用@RequestScoped标签来标识。
 * Created by Anderson on 2019/7/9
 */
@RequestScoped
public class HelloWorldImpl implements HelloWorld {
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Inject
    public HelloWorldImpl(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
    }

    public void execute() throws IOException {
        String name = request.getParameter("user");
        if (name == null || name.length() < 1) {
            name = "Guest";
        }
        response.getWriter().append(String.format("Hello, %s. %s -> sessionId=%s,hashCode=%d \n", name, new Date(), request.getSession().getId(), hashCode()));
    }
}
