package org.training.threads2;

/**
 * Created by kongyunlong on 2016/7/24.
 */
class ThreadDemo extends Thread {
    static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    public static synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket--);
        }
    }
}

public class TestStaticSyncMethod {
    public static void main(String[] args) {
        ThreadDemo demo1 = new ThreadDemo();
        ThreadDemo demo2 = new ThreadDemo();
        ThreadDemo demo3 = new ThreadDemo();

        demo1.setName("窗口1");
        demo2.setName("窗口2");
        demo2.setName("窗口3");

        demo1.start();
        demo2.start();
        demo3.start();
    }
}
