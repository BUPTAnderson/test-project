package org.training.concurrency.chapter12;

import java.util.Arrays;

public class ThreadGroupAPI {
    public static void main(String[] args) {
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t1.start();

        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t2.start();

        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(tg1.activeCount());
        System.out.println(tg1.activeGroupCount());

        t2.checkAccess();

//        t1.destroy();

        System.out.println("================================");
        Thread[] ts1 = new Thread[tg1.activeCount()];
        tg1.enumerate(ts1);
        Arrays.asList(ts1).forEach(System.out::println);

        System.out.println("================================");
        ts1 = new Thread[5];
        tg1.enumerate(ts1, true);
        Arrays.asList(ts1).forEach(System.out::println);

        System.out.println("================================");
        ts1 = new Thread[10];
//        Thread.currentThread().getThreadGroup().enumerate(ts1, true);
        Thread.currentThread().getThreadGroup().enumerate(ts1, false);
        Arrays.asList(ts1).forEach(System.out::println);

        // 会把子group的线程也中断
        tg1.interrupt();
    }
}
