package org.training.concurrent.chapter6;

public class ThreadInterrupt {
    public static final Object MONITOR = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            // 会清楚标志位
                            e.printStackTrace();
                            System.out.println("t1>>" + isInterrupted());
                        }
                    }
                }
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println("t1->" + t.isInterrupted());
        t.interrupt();
        Thread.sleep(10);
        System.out.println("t1->>" + t.isInterrupted());

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("t2>>" + Thread.interrupted());
                    }
                }
            }
        });

        t2.start();
        Thread.sleep(100);
        t2.interrupt();
        System.out.println("t2->" + t2.isInterrupted());
    }
}
