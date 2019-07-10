package org.training.csdn.eight;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;

/**
 * AOP (面向切面的编程)
 * 链接：https://blog.csdn.net/u010834071/article/details/46710745
 * aop是面向切面编程，动态代理是aop的实现手段之一
 * 对比aop包中借助spring的实现
 *
 * Binder绑定一个切面的API是：
 * com.google.inject.Binder.bindInterceptor(Matcher<? super Class<?>>, Matcher<? super Method>, MethodInterceptor...)
 * 第一个参数是匹配类，第二个参数是匹配方法，第三个数组参数是方法拦截器。也就是说目前为止Guice只能拦截到方法，然后才做一些切面工作。
 * Created by Anderson on 2019/7/9
 */
public class AopTest {
    @Inject
    private Service service;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
//                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("log")), new LoggerMethodInterceptor());
                // 也可以使用自定义注解
//                binder.bindInterceptor(Matchers.subclassesOf(Service.class), Matchers.annotatedWith(Aop.class), new LoggerMethodInterceptor());
                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Aop.class), new LoggerMethodInterceptor());
            }
        });
        injector.getInstance(AopTest.class).service.sayHello();
        injector.getInstance(AopTest.class).service.sayHello();
        injector.getInstance(AopTest.class).service.sayHello();
    }
}
