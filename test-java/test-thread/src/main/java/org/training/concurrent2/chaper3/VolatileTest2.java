package org.training.concurrent2.chaper3;

public class VolatileTest2 {
    private static int initValue = 0;
    private static final int MAX_LIMIT = 50;

    public static void main(String[] args) {
        new Thread(() -> {
            while (initValue < MAX_LIMIT) {
//            for (int i = 0; i < 50; i++) {
                System.out.println("T1->" + (++initValue));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ADDRE-1").start();

        new Thread(() -> {
            while (initValue < MAX_LIMIT) {
//            for (int i = 0; i < 50; i++) {
                System.out.println("T2->" + (++initValue));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ADDRE-2").start();
    }
}
