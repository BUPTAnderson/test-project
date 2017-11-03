package org.training.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by anderson on 17-11-2.
 */
public class AsycWriteDemo
{
    private static class  Attachment {
        public Path path;
        public ByteBuffer buffer;
        public AsynchronousFileChannel channel;
    }

    private static class WriteHandler implements CompletionHandler<Integer, Attachment> {
        @Override
        public void completed(Integer result, Attachment attachment)
        {
            try {
                attachment.channel.close();
                System.out.println("写数据完成");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable exc, Attachment attachment)
        {
            System.out.println(exc.getMessage());
            try {
                attachment.channel.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
            throws IOException
    {
        Path path = Paths.get("aw.txt");
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        Attachment a = new Attachment();
        a.buffer = getData();
        a.path = path;
        a.channel = afc;

        afc.write(getData(), 0, a, new WriteHandler());
        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成");
    }

    private static ByteBuffer getData() {
        return ByteBuffer.wrap("hello".getBytes());
    }
}
