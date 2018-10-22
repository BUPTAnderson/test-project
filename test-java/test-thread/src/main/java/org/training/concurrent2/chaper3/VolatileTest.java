package org.training.concurrent2.chaper3;

public class VolatileTest {
    //    private static volatile int initValue = 0;
    private static int initValue = 0;
    private static final int MAX_LIMIT = 5;

    public static void main(String[] args) {
        // 该线程由于是读操作，一直从cpu缓存获取数据，没有去主内存获取INIT_VALUE的最新值，
        // 导致该线程一直判断localValue等于INIT_VALUE，从而该线程不会结束
        new Thread(() -> {
            int localValue = initValue;
            while (localValue < MAX_LIMIT) {
                if (localValue != initValue) {
                    System.out.printf("The value updated to [%d]\n", initValue);
                    localValue = initValue;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = initValue;
            while (initValue < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                initValue = localValue;

                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Update").start();
    }
}
