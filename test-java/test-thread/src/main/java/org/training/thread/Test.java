package org.training.thread;

/**
 * Created by anderson on 17-10-24.
 * 一种可能的输出结果:
 * i=1 j=2
 * i=1 j=2
 * i=1 j=2
 * 显然两个线程都去更改数据, 最终数据出现了非预想的结果, 如果volatile能保证线程安全的话, 不管两个线程获取的结果是什么, 最终主线程输出的结果应该是i=2 j=2
 * 也就是说volatile只能保证可见性, 不能保证线程安全(保证线程安全需要使用锁的可见行和互斥性)
 */
class Test {
    static volatile int i = 0, j = 0;
    static void one() {
        try {
            Thread.currentThread().sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        j++;
    }
    static void two() {
//        try {
//            Thread.currentThread().sleep(500L);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("i=" + i + " j=" + j);
    }

    public static void main(String[] args)
    {
        new Thread(() -> {
            Test.one();
            Test.two();
        }).start();

        new Thread(() -> {
            Test.one();
            Test.two();
        }).start();

        // 这里在主程序sleep的原因是防止上面两个线程还没有执行完毕, 主线程就退出了.
        try {
            Thread.currentThread().sleep(2000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test.two();
    }
}
