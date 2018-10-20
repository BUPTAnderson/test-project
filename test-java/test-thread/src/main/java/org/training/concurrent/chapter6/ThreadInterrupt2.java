package org.training.concurrent.chapter6;

public class ThreadInterrupt2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
//                    System.out.println("---------");
                }
            }
        };

        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 这里调用t.interrupt()是无法终端main线程的,即aa行是不会抛出异常的
                // 调用main.interrupt()，aa行会捕获到异常。不论调用t.interrupt()还是main.interrupt();t线程都不会被中断
                // t.join()最终调用的是wait方法，可以把t.join()看作t.wait(),所以需要调用执行t.join()的线程的interrupt方法才会中断join方法
                t.interrupt();
//                main.interrupt();
                System.out.println("interrupt");
            }
        };

        t2.start();

        try {
            t.join();
        } catch (InterruptedException e) { // aa
            e.printStackTrace();
        }
    }
}
