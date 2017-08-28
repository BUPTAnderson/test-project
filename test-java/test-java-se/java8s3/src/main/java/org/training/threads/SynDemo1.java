package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
public class SynDemo1 {
    public  synchronized void m1() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A:" + i);
        }
    }

    public  static synchronized void m2() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B:" + i);
        }
    }

    public static void main(String[] args) {
        SynDemo1 d = new SynDemo1();
        new Thread(d::m1).start();
        new Thread(SynDemo1::m2).start();
    }
}
