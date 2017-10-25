package org.training.thread;

/**
 * Created by anderson on 17-10-24.
 */
public class Counter
{

    public volatile static int count = 0;
//    public volatile static AtomicInteger count = new AtomicInteger(0);
//    public AtomicInteger count = new AtomicInteger(0);

    public static void inc()
    {

        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        }
        catch (InterruptedException e) {
        }

        count++;
//        count.getAndIncrement();
    }

    public static void main(String[] args)
    {
        //同时启动1000个线程，去进行i++计算，看看实际结果
        Thread threads[] = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(new Runnable()
            {
                public void run()
                {
                    Counter.inc();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < 1000; i++) {
            try {
                threads[i].join();
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}
