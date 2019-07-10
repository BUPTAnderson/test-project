package org.training.csdn.two;

/**
 * Created by Anderson on 2019/7/9
 */
public class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Hello Guice ,this is field inject demo !");
    }
}
