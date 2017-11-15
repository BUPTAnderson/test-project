package org.training.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by anderson on 17-11-1.
 */
public class FileChannelDemo
{
    public static void main(String[] args)
            throws IOException
    {
//        read();
//        write();
        // 截取
        truncate();
    }

    private static void read()
            throws IOException
    {
        FileInputStream fis = new FileInputStream("f2.txt");
        FileChannel c = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (c.read(buffer) > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }
    }

    private static void write()
            throws IOException
    {
        // 追加写的方式:
        // 如果是: FileOutputStream, 需要设置为new FileOutputStream("f7.txt", true); true就是追加的意思. 这时通过channel.size()获取到的就是文件内容大小,
        // 设置为true后position也会自动变为末尾, 不用设置position(设置为true后可以调用channel.position()看到position已经变成文件末尾), 如果不设置为true, 可以发现position是为0
        // 如果是: RandomAccessFile, 1. 通过seek将光标设置到文件末尾 2. 通过c.position(c.size())将position设置到channel的最后
        FileOutputStream fos = new FileOutputStream("f7.txt", true);
//        RandomAccessFile raf = new RandomAccessFile("f7.txt", "rw");
        // 追加写, 设置seek到末尾, 不设置的话是覆盖写
//        raf.seek(raf.length());
        // 覆盖写
        FileChannel c = fos.getChannel();
//        FileChannel c = raf.getChannel();
//        System.out.println(c.size());
        System.out.println(c.position());
        String text = "\nsupreme";
        ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
        // 非阻塞模式下，write()方法在尚未写出任何内容时可能就返回了。所以需要在循环中调用write()。
        while (buffer.hasRemaining()) {
            c.write(buffer);
        }
        // FileChannel.force()方法将通道里尚未写入磁盘的数据强制写到磁盘上。出于性能方面的考虑，操作系统会将数据缓存在内存中，所以无法保证写入到FileChannel里的数据一定会即时写到磁盘上。要保证这一点，需要调用force()方法。
        c.force(true);
        fos.close();
//        raf.close();
        c.close();
    }

    private static void truncate()
            throws IOException
    {
//        FileOutputStream fos = new FileOutputStream("f7.txt");
        RandomAccessFile fos = new RandomAccessFile("f7.txt", "rw");
        FileChannel channel = fos.getChannel();
        // 可以使用FileChannel.truncate()方法截取一个文件。截取文件时，文件将中指定长度后面的部分将被删除
        channel.truncate(5);
//        channel.force(true);
        channel.close();
        fos.close();
    }
}
