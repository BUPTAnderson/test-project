package org.training.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by anderson on 17-8-9.
 */
public class CallableAndFuture3
{
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
        for (int i = 1; i < 5; i++) {
            int taskID = i;
            cs.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    Thread.currentThread().sleep(new Random().nextInt(1000));
                    return taskID;
                }
            });
        }
        // 可能做一些事情
        for (int i = 1; i < 5; i++) {
            try {
                // 拿到的顺序并不是放入的顺序, 即输出并不是1, 2, 3, 4；而是按照那个线程先执行完就先获取到那个线程的Future
                System.out.println(cs.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
