package org.training.concurrent2.classloader;

/**
 * 1. 链接的准备阶段：为类变量分配内存并设置类变量初始值的阶段
 * install = null;
 * x = 0;
 * y = 0;
 *
 * 2. 初始化阶段：为类的静态变量赋予正确的初始值
 * instance = new Singleton(), 执行构造方法，x = 1; y = 1;
 * 执行：public static int x = 0; x值变为0
 * 执行：public static int y; 因为y已经初始化过了，y值不变，还是1；
 *
 * 所以最终输出：
 * 0
 * 1
 *
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    public static int x = 0;
    public static int y;

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}
