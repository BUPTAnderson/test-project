package org.training.concurrent2.chapter6;

public class ReaderWorker extends Thread {
    private final SharedDate data;

    public ReaderWorker(SharedDate data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " read " + String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
