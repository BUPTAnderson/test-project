package org.training.threads;

/**
 *  方式一：同步代码块
 *  synchronized(同步监视器) {
 *     //需要被同步的代码块(即为操作共享数据的代码)
 *  }
 *  1.共享数据：多个线程共同操作的同一个数据(变量)
 *  2.同步监视器：由一个类的对象来充当。哪个线程获取此监视器，谁就执行大括号里被同步的代码。同步监视器俗称：锁
 *  要求：所有的线程必须共用同一把锁！！！
 *  注：在实现的方式（实现Runnable）中，考虑使用this来充当锁。但是在继承的方式(继承Thread类)中，慎用！！，
 *  因为有可能不同线程对应的this不是同一个对象！！
 *
 *  方式二：同步方法
 *  将操作共享数据的方法声明为synchronized.即此方法为同步方法，能够保证当其中一个线程执行此方法时，
 *  其它线程在外等待直至此线程执行完此方法。
 *  ->同步方法的锁就是当前对象(this)。所以说，同步方法也不一定能保证安全（在继承的方式中）。
 */
public class Test {
    public static void main(String[] args) {
        Resource r = new Resource();
        ProductorThread p = new ProductorThread(r);
        new Thread(p).start();
        ProductorThread p2 = new ProductorThread(r);
        new Thread(p2).start();
        ProductorThread p3 = new ProductorThread(r);
        new Thread(p3).start();

        ConsumerThread c = new ConsumerThread(r);
        new Thread(c).start();
        ConsumerThread c2 = new ConsumerThread(r);
        new Thread(c2).start();
    }
}
