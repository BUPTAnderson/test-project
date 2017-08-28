package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/26.
 */
public class Resource {
    private int num = 0;
    public synchronized void increse() {
        while (num != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        notify();
        System.out.println(num);
    }

    public synchronized void decrese() {
        while (num == 0) {
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
