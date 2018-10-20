package org.training.concurrent.chapter11;

public class ThreadException {
    private final static int A = 10;
    private final static int B = 0;
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5_000L);
                int result = A / B;
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 通过这样的话，上面的RuntimeException错误堆栈信息不会被打印出来了
        t.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println(e);
            System.out.println(thread);
        });

        t.start();
    }
}
