package org.training.concurrent;

import java.time.LocalDateTime;

/**
 * notify不会释放锁
 */
public class TestNotify {
    private static final Object LOCK = new Object();
    public static void main(String[] args) {
        Thread t = new Thread("T") {
            @Override
            public void run() {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + " get Lock");
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10_000L);
                        System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " release Lock");
                }
            }
        };
        t.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (LOCK) {
            LOCK.notify();
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now());
            System.out.println("==============");
        }
    }
}
