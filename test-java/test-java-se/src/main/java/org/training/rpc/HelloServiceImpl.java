package org.training.rpc;

/**
 * Created by anderson on 17-6-17.
 */
public class HelloServiceImpl implements HelloService
{
    @Override
    public String hello(String name)
    {
        return "Hello " + name;
    }
}
