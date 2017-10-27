package org.training.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anderson on 17-10-25.
 */
public class TimerTest
{
    static class MyTimerTask1 extends TimerTask
    {
        public void run() {
            System.out.println("爆炸！！！");
        }
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask1(), 2000); // 两秒后启动任务
        try {
            Thread.currentThread().sleep(3000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 不执行下面的语句的话, 虚拟机是不会退出的, 这是因为timer.schedule(new MyTimerTask1(), 2000);实际上是开启了一个新的线程，在当前线程内（main方法），已经感知不到子线程是否执行完，所以程序没有退出。
        System.exit(0);
    }
}
