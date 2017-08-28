package org.training.threads2;

/**
 * Created by kongyunlong on 2016/7/24.
 * join(long mills)不一定等待mills毫秒，如果提前执行完毕，则join结束。
 */
public class TestJoin {
    public static void main(String[] args) {
        Thread t = new Thread(()-> {
           for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ", i=" + i);
            }
        });
        t.start();
        try {
            t.join(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ",i=" + i);
        }
    }
}
