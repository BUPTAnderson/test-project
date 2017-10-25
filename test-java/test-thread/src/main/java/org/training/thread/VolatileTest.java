package org.training.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by anderson on 17-10-24.
 */
public class VolatileTest
{
    //  public volatile static int count = 0;
// 改成非静态变量也是可以的, 当然方法也要改成非静态的并且要创建VolatileTest对象, 让所有线程共享该对象
    public static AtomicInteger count = new AtomicInteger(0);

    public static void inc() {

//      count++;
        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service= Executors.newFixedThreadPool(Integer.MAX_VALUE);

        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    VolatileTest.inc();
                }
            });
        }

        service.shutdown();
        //给予一个关闭时间（timeout），但是实际关闭时间应该会这个小
        service.awaitTermination(300, TimeUnit.SECONDS);

        System.out.println("运行结果:Counter.count=" + VolatileTest.count);
    }
}
