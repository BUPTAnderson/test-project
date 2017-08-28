package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
class Threadd implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}

public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        Threadd r = new Threadd();
        Thread t = new Thread(r, "子线程");
        t.start();
        t.join(1000);
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
