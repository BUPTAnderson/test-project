package org.training.concurrent2.chapter1;

/**
 * 通过枚举实现单例模式
 */
public class SingletonObject7 {
    private SingletonObject7() {
    }

    private enum Singleton {
        INSTANCT;

        private final SingletonObject7 instance;
        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCT.getInstance();
    }
}
