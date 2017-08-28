package org.training.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by anderson on 16-6-10.
 */
interface Flying
{
    void m1();

    int m2(int num);
}

class Swan
        implements Flying
{
    @Override
    public void m1()
    {
        System.out.println("m1");
    }

    @Override
    public int m2(int num)
    {
        System.out.println("m2");
        return 20;
    }
}

class LogInvocationHandler
        implements InvocationHandler
{
    private Object target;

    public LogInvocationHandler(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable
    {
        System.out.println("Method before...");
        Object result = method.invoke(target, args);
        System.out.println("Method after...");
        return result;
    }
}

public class TestProxy
{
    public static void main(String[] args)
    {
        Swan swan = new Swan();
        //获取代理
        Flying b = (Flying) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), swan.getClass().getInterfaces(), new LogInvocationHandler(swan));
        b.m1();
        System.out.println("---------------");
        int r = b.m2(10);
        System.out.println(r);
    }
}
