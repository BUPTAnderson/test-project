package org.training.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by anderson on 17-10-25.
 */
class LockClass
{
    private Lock lock = new ReentrantLock(); // 锁对象

    public void output(String name)
    {
        // TODO 线程输出方法
        try {
            try {
                lock.lockInterruptibly(); // 得到锁
            }
            catch (InterruptedException ee) {
                System.out.println(Thread.currentThread().getName() + "ee");
                ee.printStackTrace();
            }
            Thread.currentThread().sleep(1000L);
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + "------------------");
        }
        finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockTest
{
    public static void main(String[] args)
    {
        final LockClass output = new LockClass();
        Thread t1 = new Thread()
        {
            public void run()
            {
                output.output("zhangsan");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.currentThread().sleep(100L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread()
        {
            public void run()
            {
                output.output("lisi");
            }
        };
        t2.setName("t2");
        t2.start();
        try {
            Thread.currentThread().sleep(200L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        // t2正在阻塞状态等待获取重入锁, 我们将它中断
        t2.interrupt();
    }
}
