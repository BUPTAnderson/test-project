package org.training.concurrent2.chapter1;

/**
 * 解决了线程安全问题
 * 每次调用方法都加锁，影响性能
 */
public class SingletonObject3 {
    private static SingletonObject3 instance;

    private SingletonObject3() {
    }

    public static synchronized SingletonObject3 getInstance() {
        if (null == instance) {
            instance = new SingletonObject3();
        }

        return SingletonObject3.instance;
    }
}
