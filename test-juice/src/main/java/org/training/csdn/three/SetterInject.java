package org.training.csdn.three;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * Setter注入（Setter Inject）
 * 链接：https://blog.csdn.net/u010834071/article/details/46707049
 * Created by Anderson on 2019/7/9
 */
public class SetterInject {
    private Service service;

    public Service getService() {
        return service;
    }

    @Inject
    public void setService(Service service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SetterInject setterInject = Guice.createInjector().getInstance(SetterInject.class);
        setterInject.getService().execute();
    }
}
