package org.training.threads;

/**
 * Created by anderson on 17-10-25.
 */
public class InterruptDemo3
{
    boolean flag = true;
    public synchronized void testWaitInterrupt() {
        if (flag) {
            try {
                Thread.currentThread().sleep(5000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("error:" + Thread.currentThread().isInterrupted());
            }
            long b = 0L;
            long now = System.currentTimeMillis();
            long a = now + 5000L;
            while (now < a) {
                now = System.currentTimeMillis();
                b = b * 1;
            }

            System.out.println("+++++++++" + Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) {
        InterruptDemo3 demo3 = new InterruptDemo3();
        Thread th = new Thread(() -> {
            demo3.testWaitInterrupt();
        });
        th.start();
        try {
            Thread.currentThread().sleep(100L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        th.interrupt();
        System.out.println("1, " + th.isInterrupted());
        System.out.println("2, " + th.interrupted());
        System.out.println("3, " + th.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("4," + th.interrupted());
        System.out.println("5, " + th.isInterrupted());
        System.out.println("6, " + th.isInterrupted());

        try {
            th.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("join error!");
        }
    }
}
