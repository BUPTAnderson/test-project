package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/26.
 */
class YRun
        implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " i:" + i);
        }
    }
}

public class TestYield
{
    public static void main(String[] args)
    {
        YRun y = new YRun();
        Thread t = new Thread(y);
        t.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                Thread.currentThread().yield();
            }
            System.out.println(Thread.currentThread().getName() + " i:" + i);
        }
    }
}
