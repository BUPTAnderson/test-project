package org.training.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;

/**
 * Created by anderson on 17-11-13.
 */
public class ScatterAndGather
{
    public static void main(String[] args)
            throws IOException
    {
//        scatter();
//        gather();
    }

    private static void scatter()
            throws IOException
    {
        FileInputStream fis = new FileInputStream("f2.txt");
        FileChannel channel = fis.getChannel();
        ByteBuffer header = ByteBuffer.allocate(8);
        ByteBuffer body   = ByteBuffer.allocate(32);
        ByteBuffer[] bufferArray = { header, body };
        // 将数组中前面的buffer填充满之后才会填充后面的buffer
        channel.read(bufferArray);
        header.flip();
        body.flip();
        while (header.hasRemaining()) {
            System.out.print((char) header.get());
        }
        System.out.println();
        System.out.println("-----------------------");
        while (body.hasRemaining()) {
            System.out.print((char) body.get());
        }
    }

    private static void gather()
            throws IOException
    {
        ByteBuffer header = ByteBuffer.allocate(32);
        ByteBuffer body   = ByteBuffer.allocate(64);
        header.put("header".getBytes());
        header.flip();
        body.put("\nbody".getBytes());
        body.flip();

        //write data into buffers
        ByteBuffer[] bufferArray = { header, body };
        FileOutputStream fos = new FileOutputStream("f2.txt");
        FileChannel channel = fos.getChannel();
        // 会将每个buffer中从position到limit的数据写入的channel中
        channel.write(bufferArray);
    }
}
