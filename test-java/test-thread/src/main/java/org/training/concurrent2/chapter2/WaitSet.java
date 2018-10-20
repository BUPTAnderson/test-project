package org.training.concurrent2.chapter2;

import java.util.Optional;
import java.util.stream.IntStream;

public class WaitSet {
    private static final Object LOCK = new Object();

    /**
     * 1. 所有的对象都会有一个wait set,用来存放调用了该对象wait方法之后进入blocked状态的线程
     * 2. 线程被notify之后，不一定立即得到执行
     * 3. 线程从waitset中被唤醒的顺序不一定是FIFO。
     * @param
     *
     */
    public static void main(String[] args) {
        IntStream.of(1, 10, 2, 5, 3, 8, 4, 7, 6, 9).forEach(i ->
        new Thread(String.valueOf(i)) {
            @Override
            public void run() {
                synchronized (LOCK) {
                    try {
                        Thread.sleep(i * 100);
                        Optional.of(Thread.currentThread().getName() + " will come to wait set." + Thread.currentThread().getId()).ifPresent(System.out::println);
                        LOCK.wait();
                        Optional.of(Thread.currentThread().getName() + " will leave wait set." + Thread.currentThread().getId()).ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());

        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1, 10).forEach(i ->
                {
                    try {
                        Thread.sleep(i * 100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (LOCK) {
                        try {
                            Thread.sleep(1_000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        LOCK.notify();
                        try {
                            Thread.sleep(i * 1_00L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                );
    }
}
