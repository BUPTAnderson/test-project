package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
class Thread1
        extends Thread
{
    private int num;

    public void setNum(int num)
    {
        this.num = num;
    }

    @Override
    public void run()
    {
        Thread ct = Thread.currentThread();
        System.out.println(ct.getName());
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1:" + i + " num:" + num);
        }
    }
}

class Thread2
        implements Runnable
{
    private int num;

    public Thread2(int num)
    {
        this.num = num;
    }

    @Override
    public void run()
    {
        Thread ct = Thread.currentThread();
        System.out.println(ct.getName());
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2:" + i + " num:" + num);
            if (i % 10 == 0) {
                System.out.println("state:" + Thread.currentThread().getState().name());
            }
        }
    }
}

public class ThreadDemo1
{
    public static void main(String[] args)
            throws InterruptedException
    {
        //1.继承Thread类
        Thread1 t1 = new Thread1();
        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.getPriority());
        t1.setName("线程1");
        t1.setNum(100);
        t1.start();
        t1.join();
        //2.实现Runnable接口
        Runnable r2 = new Thread2(200);
        Thread t2 = new Thread(r2, "线程2");
        t2.start();
        System.out.println("-----------------t2 state:" + t2.getState());
        t2.join(1000);
        //3.使用方法引用(Lambda表达式)
        int num = 300;
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(400);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread3:" + i + " num:" + num);
            }
        });
        t3.start();
        //4.方法引用，这里引用的是静态方法，可以直接使用类名加方法名。如果方法是非静态方法，需要使用new ThreadDemo1()::print的方式
        new Thread(new ThreadDemo1()::print).start();
        //主线程
        for (int i = 0; i < 20; i++) {
            Thread.sleep(400);
            System.out.println("Main:" + i);
        }
    }

    public void print()
    {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread4:" + i);
        }
    }
}
