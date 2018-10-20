package org.training.concurrent;

import java.time.LocalDateTime;

/**
 * wait被唤醒后需要重新排队获取锁，获取到锁之后才能继续执行wait后面的逻辑
 */
public class TestWait {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " get lock"+ LocalDateTime.now());
                    Thread.sleep(5_000L);
                    System.out.println(Thread.currentThread().getName() + " to release lock"+ LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " get lock" + LocalDateTime.now());
                    Thread.sleep(5_000L);
                    System.out.println(Thread.currentThread().getName() + " to release lock"+ LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " get lock"+ LocalDateTime.now());
                    Thread.sleep(5_000L);
                    System.out.println(Thread.currentThread().getName() + " to release lock"+ LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.currentThread().sleep(5_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            lock.notifyAll();
        }

        try {
            Thread.currentThread().sleep(2_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
