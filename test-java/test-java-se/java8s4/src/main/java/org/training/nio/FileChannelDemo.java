package org.training.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        write();
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
        FileOutputStream fos = new FileOutputStream("f7.txt");
        FileChannel c = fos.getChannel();
        String text = "supreme";
        ByteBuffer buffer = ByteBuffer.wrap(text.getBytes());
        c.write(buffer);
        fos.close();
        c.close();
    }
}
