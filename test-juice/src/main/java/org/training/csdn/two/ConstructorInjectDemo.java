package org.training.csdn.two;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * 构造器注入
 * 链接：https://blog.csdn.net/u010834071/article/details/46706945
 * Created by Anderson on 2019/7/9
 */
public class ConstructorInjectDemo {
    private Service service;
    private HelloGuice helloGuice;

    public Service getService() {
        return service;
    }

    public HelloGuice getHelloGuice() {
        return helloGuice;
    }

    /**
     * 构造函数注入： 好处：可以保证只有一个地方来完成属性注入，
     * 可以确保在构造函数中完成一些初始化工作 不足：类的实例化与参数绑定了，限制了实例化类的方式。
     * 注意：只能用@Inject修饰一个构造器，修饰多个会报错，因为Guice不知道使用哪个构造器来创建对象。
     * @param service
     */
//    @Inject
//    public ConstructorInjectDemo(Service service) {
//        this.service = service;
//    }

    /**
     * 支持多参数构造函数注入 ，但是必须只有一个构造函数上面标注Inject
     * @param service
     * @param helloGuice
     */
    @Inject
    public ConstructorInjectDemo(Service service, HelloGuice helloGuice) {
        this.service = service;
        this.helloGuice = helloGuice;
    }

    public static void main(String[] args) {
        ConstructorInjectDemo instance = Guice.createInjector().getInstance(ConstructorInjectDemo.class);
        instance.getService().execute();
        instance.getHelloGuice().sayHello();
    }
}
