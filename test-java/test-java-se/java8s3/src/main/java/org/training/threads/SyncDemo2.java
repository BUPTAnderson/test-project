package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
public class SyncDemo2 {
    public void m1() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A:" + i);
            }
        }
    }

    public void m2() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B:" + i);
            }
        }
    }

    public static void main(String[] args) {
        SyncDemo2 d = new SyncDemo2();
        new Thread(d::m1).start();
        new Thread(d::m2).start();
    }
}
