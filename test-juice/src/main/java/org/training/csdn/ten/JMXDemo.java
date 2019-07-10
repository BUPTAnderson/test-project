package org.training.csdn.ten;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.tools.jmx.Manager;

import javax.management.MBeanServer;

import java.lang.management.ManagementFactory;

/**
 * Guice与jmx
 * 链接：http://www.blogjava.net/xylz/archive/2009/12/31/307917.html
 * Created by Anderson on 2019/7/9
 */
public class JMXDemo {
    public static void main(String[] args) throws InterruptedException {
        Injector inj = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(MBeanServer.class).toInstance(ManagementFactory.getPlatformMBeanServer());
                // 这里最后要加上asEagerSingleton， （类似Spring的layzload=false）
                // 启动时加载一个对象，可以通过asEagerSingleton方法实现初始化逻辑，通过在Guice必须首先初始化的单件对象上创造依赖关系来控制初始化顺序。
                binder.bind(HelloWorldMBean.class).to(HelloWorld.class).asEagerSingleton();
            }
        });
        //
        Manager.manage("org.training.csdn.ten", inj);
        //
        Thread.sleep(30000L); //sleep for ten minute

        HelloWorld helloWorld = inj.getInstance(HelloWorld.class);
        helloWorld.close();
    }
}
