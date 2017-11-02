package org.training.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by anderson on 17-11-1.
 */
public class MappedByteBufferDemo
{
    public static void main(String[] args)
            throws IOException
    {
        FileInputStream fis = new FileInputStream("f2.txt");
        FileChannel c = fis.getChannel();
//        MappedByteBuffer mbb = c.map(FileChannel.MapMode.READ_ONLY, 0, Integer.MAX_VALUE);
        MappedByteBuffer mbb = c.map(FileChannel.MapMode.READ_ONLY, 0, c.size());
        while (mbb.hasRemaining()) {
            System.out.print((char) mbb.get());
        }
    }
}
