package org.training;

/**
 * Created by anderson on 17-10-30.
 * 该实例我们主要验证两个事情：
 * １. 调用notify之后，　线程只是被唤醒了, 调用notify的线程并不是在调用notify后就立即释放锁的, 是在执行完synchronized方法或代码块之后才释放锁. 被notify唤醒的线程是要重新获取锁然后往下执行的, 如果没有
 * 获取到锁, 则进入BLOCKED 状态
 * ２. notify只会唤醒一条线程, 不能保证优先级高的线程一定会被唤醒
 *
 * 两种可能的结果（有很多种可能，　这里只列出２种有代表性的结果）
 * 可能的结果１：
 * 线程thread3获取到了锁
 * 线程thread1获取到了锁
 * 线程thread2调用了object.notify()
 * 线程thread2释放了锁
 * 线程thread3获取到了锁

 * 可能的结果２：
 * 线程thread3获取到了锁
 * 线程thread1获取到了锁
 * 线程thread2调用了object.notify()
 * 线程thread2释放了锁
 * 线程thread1获取到了锁
 *
 */
public class TestNotify
{
    public static Object object = new Object();
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.setName("thread1");
        Thread2 thread2 = new Thread2();
        thread2.setName("thread2");
        Thread3 thread3 = new Thread3();
        thread3.setName("thread3");

        thread1.setPriority(6);
        thread3.setPriority(10);

        thread1.start();
        thread3.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            }
        }
    }

    static class Thread3 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
                    object.wait();
                } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            }
        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    Thread.currentThread().sleep(20000L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了object.notify()");
                try {
                    Thread.currentThread().sleep(60000L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
            }
        }
    }
}
