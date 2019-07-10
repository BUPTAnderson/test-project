package org.training.csdn.eight;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * 如果一个切面（拦截器）也需要注入一些依赖怎么办？
 * 在这里我们声明一个前置服务，输出所有调用的方法名称。
 * Created by Anderson on 2019/7/9
 */
public class AopTest2 {
    @Inject
    private Service service;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                AfterMethodIntercepter after = new AfterMethodIntercepter();
                binder.requestInjection(after);
                binder.bindInterceptor(Matchers.any(), Matchers.annotatedWith(Names.named("log")), after);
            }
        });
        injector.getInstance(AopTest2.class).service.sayHello();
    }
}
