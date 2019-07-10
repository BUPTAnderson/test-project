package org.training.csdn.ten;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * Created by Anderson on 2019/7/9
 */
public class JMXClientDemo {
    public static void main(String[] args) throws Exception {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:4321/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
        //
        ObjectName mbeanName = new ObjectName("org.training.csdn.ten:type=HelloWorld");
        //
        HelloWorldMBean helloWorld = JMX.newMBeanProxy(mbsc, mbeanName, HelloWorldMBean.class, true);
        String msg = helloWorld.sayHello();
        System.out.println(msg);
    }
}
