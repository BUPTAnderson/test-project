package org.training.thread3;

/**
 * Created by anderson on 17-5-25.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java线程：线程池
 *
 * @author xiho
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
//        ExecutorService pool = Executors.newFixedThreadPool(5);
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        ExecutorService pool = Executors.newCachedThreadPool();
        // 创建线程
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        pool.shutdown();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
