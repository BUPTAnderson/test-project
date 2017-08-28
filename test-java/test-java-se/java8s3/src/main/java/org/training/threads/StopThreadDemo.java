package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
class Thread4
        implements Runnable
{
    private boolean stop = false;

    public void setStop(boolean stop)
    {
        this.stop = stop;
    }

    @Override
    public void run()
    {
        for (int i = 0;; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stop) {
                break;
            }
            System.out.println(i);
        }
    }
}

public class StopThreadDemo
{
    public static void main(String[] args)
            throws InterruptedException
    {
        Thread4 t4 = new Thread4();
        Thread t5 = new Thread(t4);
        //要在调用start之前设置为Daemon,否则会报错，因为调用start()后线程可能就开始
        //运行了，这时候状态以及确定了，再更改为Daemon会报IllegalThreadStateException
        t5.setDaemon(true);
        t5.start();
        Thread.sleep(4000);
    }
}
