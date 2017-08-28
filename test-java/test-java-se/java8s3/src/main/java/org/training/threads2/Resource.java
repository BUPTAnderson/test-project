package org.training.threads2;

/**
 * Created by kongyunlong on 2016/6/26.
 */
public class Resource {
    private int num = 1;
    public synchronized void increse() {
        System.out.println(Thread.currentThread().getName());
        if (num != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        notify();
        System.out.println(Thread.currentThread().getName() + " num:" + num);
    }

    public synchronized void decrese() {
        if (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        notify();
        System.out.println(num);
    }
}
