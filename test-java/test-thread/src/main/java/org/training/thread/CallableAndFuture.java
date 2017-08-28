package org.training.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by anderson on 17-8-9.
 */
public class CallableAndFuture
{
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(2000); // 可能做一些事情
            System.out.println(System.currentTimeMillis());
            System.out.println(future.get());
            System.out.println(System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(future.get());
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
