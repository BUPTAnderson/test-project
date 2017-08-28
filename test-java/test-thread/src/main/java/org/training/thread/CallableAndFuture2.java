package org.training.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by anderson on 17-8-9.
 */
public class CallableAndFuture2
{
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
//            public Integer call() throws Exception {
//                Thread.sleep(5000);
//                return new Random().nextInt(100);
//            }
//        });
//        Future<?> future = threadPool.submit(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                }
//                catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(new Random().nextInt(100));
//            }
//        });
        Runnable run = new Runnable() {
            @Override
            public void run()
            {
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Random().nextInt(100));
            }
        };
        Future<?> future = threadPool.submit(new FutureTask<Void>(run, null) {
            protected void done() {
                // We assume this always comes from a user operation that took the lock.
                System.out.println("++++++++++++++");
            }
        });
        try {
            Thread.sleep(1000); // 可能做一些事情
            try {
                System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
            }
            catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
