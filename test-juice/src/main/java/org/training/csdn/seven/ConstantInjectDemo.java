package org.training.csdn.seven;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * Created by Anderson on 2018/12/11
 * 除了可以绑定int外，在ConstantBindingBuilder类中还可以绑定其它的基本类型。
 * com.google.inject.binder.ConstantBindingBuilder.to(String)
 * com.google.inject.binder.ConstantBindingBuilder.to(long)
 * com.google.inject.binder.ConstantBindingBuilder.to(boolean)
 * com.google.inject.binder.ConstantBindingBuilder.to(double)
 * com.google.inject.binder.ConstantBindingBuilder.to(float)
 * com.google.inject.binder.ConstantBindingBuilder.to(short)
 * com.google.inject.binder.ConstantBindingBuilder.to(char)
 * ---------------------
 * 作者：TZQ_DO_Dreamer
 * 来源：CSDN
 * 原文：https://blog.csdn.net/u010834071/article/details/46708105
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
public class ConstantInjectDemo {
    @Inject
    @Named("a")
    private int a;

    public static void main(String[] args) {
        ConstantInjectDemo constantInjectDemo = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bindConstant().annotatedWith(Names.named("a")).to(22);
            }
        }).getInstance(ConstantInjectDemo.class);
        System.out.println(constantInjectDemo.a);
    }
}
