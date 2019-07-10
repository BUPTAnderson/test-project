package org.training.csdn.aop;

/**
 * Created by Anderson on 2019/7/9
 */
public class InterfaceImplTest implements Interface {
    @Override
    public void hello() {
        System.out.println("hello world!");
    }
}
