package org.training;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Anderson on 2018/10/17
 */
public class TestScheduleThreadPoolExecutor {
    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    static class TimerTask implements Runnable {
        private String id;

        public TimerTask(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(id + " " + df.format(new Date()));
            try {
                Thread.currentThread().sleep(20000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(id);
        }
    }

    static class TimerTask2 implements Runnable {
        private String id;

        public TimerTask2(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(id + " " + df.format(new Date()));
            try {
                Thread.currentThread().sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TimerTask3 implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2_000L);
            System.out.println("result:" + df.format(new Date()));
            return "result:" + df.format(new Date());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
//        ScheduledFuture sfa = ses.scheduleAtFixedRate(new TimerTask("a"), 200,
//                10000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfb = ses.scheduleAtFixedRate(new TimerTask2("b"), 400,
//                10000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfc = ses.scheduleAtFixedRate(new TimerTask("c"), 600,
//                1000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfd = ses.scheduleAtFixedRate(new TimerTask("d"), 800,
//                1000, TimeUnit.MILLISECONDS);

        TimerTask2 timerTask2 = new TimerTask2("a");
        ScheduledBaseTask scheduledBaseTask = new ScheduledBaseTask(timerTask2, 200L, 10_000L, TimeUnit.MILLISECONDS);

        TimerTask2 timerTask3 = new TimerTask2("b");
        ScheduledBaseTask scheduledBaseTask2 = new ScheduledBaseTask(timerTask3, 200L, 5_000L, TimeUnit.MILLISECONDS);

        List<ScheduledBaseTask> baseTasks = new ArrayList<>();
        baseTasks.add(scheduledBaseTask);
        baseTasks.add(scheduledBaseTask2);

        baseTasks.forEach(baseTask -> {
            ses.scheduleAtFixedRate(baseTask.getBaseTask(), baseTask.getInitialDelay(), baseTask.getPeriod(), baseTask.getUnit());
        });

//        ses.scheduleAtFixedRate(timerTask2, 200L, 10_000L, TimeUnit.MILLISECONDS);
//        try {
//            System.out.println("-------");
//            Object result = scheduledFuture.get();
//            System.out.println(result);
//            System.out.println("===========");
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        Thread.sleep(50_000);
//        sfa.cancel(true);
//        Thread.sleep(5000);
        ses.shutdown();
    }

    static class ScheduledBaseTask {
        private TimerTask2 baseTask;
        private long initialDelay;
        private long period;
        private TimeUnit unit;

        public ScheduledBaseTask(TimerTask2 baseTask, long initialDelay, long period, TimeUnit unit) {
            this.baseTask = baseTask;
            this.initialDelay = initialDelay;
            this.period = period;
            this.unit = unit;
        }

        public TimerTask2 getBaseTask() {
            return baseTask;
        }

        public void setBaseTask(TimerTask2 baseTask) {
            this.baseTask = baseTask;
        }

        public long getInitialDelay() {
            return initialDelay;
        }

        public void setInitialDelay(long initialDelay) {
            this.initialDelay = initialDelay;
        }

        public long getPeriod() {
            return period;
        }

        public void setPeriod(long period) {
            this.period = period;
        }

        public TimeUnit getUnit() {
            return unit;
        }

        public void setUnit(TimeUnit unit) {
            this.unit = unit;
        }
    }
}
