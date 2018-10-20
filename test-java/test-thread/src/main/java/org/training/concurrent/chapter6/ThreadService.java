package org.training.concurrent.chapter6;

/**
 * 优雅的关闭线程
 */
public class ThreadService {
    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();
                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        };

        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - currentTime >= mills) {
                System.out.println("任务超时，需要结束它！");
                executeThread.interrupt();
                break;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
    }

    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(() -> {
//            while (true) {
//                //
//            }
            // 任务提前完成
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.shutdown(10000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
