package org.training.concurrent2.chapter7;

/**
 * 多个join会同时执行
 */
public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            System.out.println("====================");
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - start);
    }
}
