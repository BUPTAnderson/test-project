package org.training.concurrent2.chapter6;

public class ReadWriteLockClient {
    public static void main(String[] args) {
        final SharedDate sharedDate = new SharedDate(10);
        new ReaderWorker(sharedDate).start();
        new ReaderWorker(sharedDate).start();
        new ReaderWorker(sharedDate).start();
        new ReaderWorker(sharedDate).start();
        new ReaderWorker(sharedDate).start();

        new WriteWorker(sharedDate, "qwertyuiopasdfg").start();
        new WriteWorker(sharedDate, "QWERTYUIOPASDFG").start();
    }
}
