package org.training;

/**
 * Created by anderson on 17-10-27.
 */
public class ThreadStateTest
{
    static class LockClass implements Runnable{
//        private ReentrantLock lock = new ReentrantLock();
        @Override
        public void run()
        {
//            lock.lock();
            synchronized (this) {
                try {
                    System.out.println(Thread.currentThread().getName() + "-------- begin ------------");
                    try {
                        Thread.currentThread().sleep(20000L);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread().getName());
                    }
                    System.out.println(Thread.currentThread().getName() + "---------- end ---------");
                    for (int i = 0; i < 100; i++) {
                        i -= 1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                finally {
//                    lock.unlock();
//                }
            }
        }
    }

    public static void main(String[] args)
    {
        LockClass lockClass = new LockClass();
        Thread t1 = new Thread(lockClass);
        t1.setName("t1");
        Thread t2 = new Thread(lockClass);
        t2.setName("t2");
        t1.start();
        try {
            Thread.currentThread().sleep(1000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t1.interrupt();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
