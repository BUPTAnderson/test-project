package org.training.threads;

import java.time.LocalDateTime;

/**
 * Created by kongyunlong on 2016/6/25.
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                System.out.println(i + ", time:" + (LocalDateTime.now().toString()));
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        for (int i = 1; i <= 20; i++) {
            System.out.println("Main:" + i);
            Thread.sleep(311);
        }
        System.out.println(t1.isInterrupted()); // false
        t1.interrupt();
        System.out.println(t1.isInterrupted()); //true
        System.out.println(t1.interrupted()); //false
        System.out.println(t1.isInterrupted()); //false
    }
}
