package org.training.concurrent2.chapter1;

/**
 * 懒加载，线程安全
 */
public class SingletonObject6 {
    private SingletonObject6() {
    }

    private static class InstanceHolder {
        private static final SingletonObject6 instance = new SingletonObject6();
    }

    public static SingletonObject6 getInstance() {
        return InstanceHolder.instance;
    }
}
