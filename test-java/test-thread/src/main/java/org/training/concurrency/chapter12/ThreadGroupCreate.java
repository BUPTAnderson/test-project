package org.training.concurrency.chapter12;

import java.util.Arrays;

public class ThreadGroupCreate {
    public static void main(String[] args) {
        // use the name
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(getThreadGroup().getName());
                        System.out.println(getThreadGroup().getParent());
                        System.out.println(getThreadGroup().getParent().activeCount());
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        // use the parent and group name

        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
        System.out.println(tg2.getName());
        System.out.println(tg2.getParent());

        ThreadGroup tg3 = new ThreadGroup("TG3");
        Thread t3 = new Thread(tg3, "T3") {
            @Override
            public void run() {
                System.out.println(tg1.getName());
                Thread[] theads = new Thread[tg1.activeCount()];
                tg1.enumerate(theads);
                Arrays.asList(theads).forEach(System.out::println);
            }
        };
        t3.start();
    }
}
