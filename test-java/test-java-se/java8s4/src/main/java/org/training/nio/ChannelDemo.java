package org.training.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by anderson on 17-11-1.
 */
public class ChannelDemo
{
    public static void main(String[] args)
            throws FileNotFoundException
    {
        FileInputStream fis = new FileInputStream("");
        ReadableByteChannel c1 = Channels.newChannel(fis);

        InputStream is = Channels.newInputStream(c1);

        FileChannel c2 = fis.getChannel(); // 只读
        RandomAccessFile f = new RandomAccessFile("", "r"); // 如果是"rw", 则得到的channel既可以读又可以写
//        f.getChannel();
    }
}
