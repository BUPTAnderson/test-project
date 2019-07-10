package org.training.csdn.four;

import com.google.inject.Guice;
import com.google.inject.Inject;

/**
 * 基本属性注入（Field Inject）
 * 链接：https://blog.csdn.net/u010834071/article/details/46707181
 * Created by Anderson on 2019/7/9
 */
public class FieldInject {
    @Inject
    private Service service;

    public Service getService() {
        return service;
    }

    public static void main(String[] args) {
        FieldInject fieldInject = Guice.createInjector().getInstance(FieldInject.class);
        fieldInject.getService().execute();
    }
}
