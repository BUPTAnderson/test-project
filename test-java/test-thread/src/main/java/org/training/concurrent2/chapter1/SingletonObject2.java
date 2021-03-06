package org.training.concurrent2.chapter1;

/**
 * 存在线程问题
 */
public class SingletonObject2 {
    private static SingletonObject2 instance;

    private SingletonObject2() {
    }

    public static SingletonObject2 getInstance() {
        if (null == instance) {
            instance = new SingletonObject2();
        }

        return SingletonObject2.instance;
    }
}
