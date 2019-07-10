package org.training.csdn.eight;

import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * Created by Anderson on 2019/7/9
 */
@Singleton
public class ServiceImpl implements Service {
    @Named("log")
    @Aop
    @Override
    public void sayHello() {
        System.out.println(String.format("[%s#%d] execute %s at %d", this.getClass().getSimpleName(), hashCode(), "sayHello", System.nanoTime()));
    }
}
