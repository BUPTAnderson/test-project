package service.demo;

import com.thrift.demo.HelloWorldService;
import org.apache.thrift.TException;

/**
 * Created by anderson on 17-6-9.
 */
public class HelloWorldImpl implements HelloWorldService.Iface
{
    @Override
    public String sayHello(String username)
            throws TException
    {
        return "Hi, " + username + " welcome to learn apache thrift!";
    }
}
