package org.training.thread;

import java.util.Random;
import java.util.concurrent.Callable;
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
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return new Random().nextInt(100);
            }
        });

        try {
            Thread.sleep(2000);
            System.out.println(future.get(1L, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("result:" + future.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 提交的是Runnable, 这样是不会返回结果的, 即future2.get()拿到的用于是null
        Future<?> future2 = threadPool.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Random().nextInt(100));
            }
        });
        try {
            System.out.println("result2:" + future2.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 提交的是Runnable, 这样成功执行完只会拿到agiel固定的值
        Future<?> future3 = threadPool.submit(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Random().nextInt(100));
            }
        }, 100);
        try {
            System.out.println("result3:" + future3.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 提交的是FutureTask, 但是FutureTask里包装的是Runnable, 这样通过future4也是拿不到结果的, 将future4改成futuretask是可以拿到固定的结果的
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

        FutureTask<Integer> futureTask = new FutureTask<Integer>(run, 111) {
            protected void done() {
                // We assume this always comes from a user operation that took the lock.
                System.out.println("++++++++++++++");
            }
        };
        Future<?> future4 = threadPool.submit(futureTask);
        try {
            Thread.sleep(1000); // 可能做一些事情
            try {
//                System.out.println(future4.get(1000, TimeUnit.MILLISECONDS));
                System.out.println(futureTask.get(1000, TimeUnit.MILLISECONDS));
            }
            catch (TimeoutException e) {
                e.printStackTrace();
            }
//            System.out.println(future4.get());
            System.out.println("result4:" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
