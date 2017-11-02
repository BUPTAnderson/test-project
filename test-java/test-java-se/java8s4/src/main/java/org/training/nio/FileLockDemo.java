package org.training.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by anderson on 17-11-1.
 */
public class FileLockDemo
{
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        RandomAccessFile r = new RandomAccessFile("f2.txt", "rw");
        FileChannel c = r.getChannel();
        // 排它锁
//        FileLock lock = c.lock();
        // 共享锁
        FileLock lock = c.lock(0, c.size(), true);
        Thread.sleep(20000L);
        lock.release();
    }
}
