package org.training.threads;

/**
 * Created by anderson on 17-4-13.
 */
// 该实例是线程不安全的，因为每执行一次run方法，ticket的值发生改变，即锁的对象发生了改变。
class Window3b extends Thread {
    static Integer ticket = new Integer(100);
    public void run() {
        while (true) {
            synchronized (Window3b.class) {
                if (ticket.intValue() > 0) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "售票，票号为：" + ticket--);
                }
            }
        }
    }
}

public class TestWindow3b {
    public static void main(String[] args) {
        Window3b w1 = new Window3b();
        Window3b w2 = new Window3b();
        Window3b w3 = new Window3b();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
