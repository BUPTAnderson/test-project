package org.training.imooc.demo;

import com.google.inject.Guice;

/**
 * Created by Anderson on 2019/7/10
 */
public class App {
    public static void main(String[] args) {
        MyApplet mainApplect = Guice.createInjector(new MainModule()).getInstance(MyApplet.class);
        mainApplect.run();
    }
}
