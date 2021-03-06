package org.training.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by anderson on 17-10-25.
 */
public class TimerTest2
{
    static class MyTimerTask1 extends TimerTask {
    public void run() {
        System.out.println("爆炸！！！");
        new Timer().schedule(new MyTimerTask2(), 2000);
    }
}
    static class MyTimerTask2 extends TimerTask
    {
        public void run() {
            System.out.println("爆炸！！！");
            new Timer().schedule(new MyTimerTask1(), 3000);
        }
    }
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask2(), 2000);
        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
