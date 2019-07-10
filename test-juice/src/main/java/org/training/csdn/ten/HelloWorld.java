package org.training.csdn.ten;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

/**
 * Created by Anderson on 2019/7/9
 */
@Singleton
public class HelloWorld implements HelloWorldMBean {
    private MBeanServer server;
    @Override
    public String sayHello() {
        return "Hello, guice";
    }

    @Override
    public void close() {
        if (server != null) {
            try {
                server.unregisterMBean(new ObjectName("org.training.csdn.ten:type=HelloWorld"));
            } catch (InstanceNotFoundException e) {
                e.printStackTrace();
            } catch (MBeanRegistrationException e) {
                e.printStackTrace();
            } catch (MalformedObjectNameException e) {
                e.printStackTrace();
            }

            System.out.println("-------------- close ------------");
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Inject
    public void register(MBeanServer server) {
        this.server = server;
        System.out.println("++++++++++++++++++++++");
        try {
            server.registerMBean(this, new ObjectName("org.training.csdn.ten:type=HelloWorld"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
