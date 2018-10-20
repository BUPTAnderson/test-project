package org.training.concurrent2.chapter1;

/**
 * 可能存在NPE, instance还未初始化完成，另一个线程拿到instance去使用了
 */
public class SingletonObject4 {
    private static SingletonObject4 instance;

    private SingletonObject4() {
    }

    public static SingletonObject4 getInstance() {
        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance) {
                    instance = new SingletonObject4();
                }
            }
        }

        return SingletonObject4.instance;
    }
}
