package org.training.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by anderson on 17-11-15.
 * 通过NIO实现非阻塞IO
 */
public class TCPClientNoBlocking
{
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        SocketChannel client = SocketChannel.open();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;
        InetSocketAddress serverAddress = new InetSocketAddress(address, port);
        boolean connect = client.connect(serverAddress);
        // 或者直接创建的时候指定连接目的地
//        SocketChannel client = SocketChannel.open(serverAddress);
        // 设置为非阻塞模式, read的时候不管读没读到数据都会立刻返回
        client.configureBlocking(false);

        if (connect) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            WritableByteChannel out = Channels.newChannel(System.out);
            // 在非阻塞模式下,read()可能因为读不到任何数据而返回0
            while (true) {
                // 把每次循环都要运行的代码都放在这里,
                // 无论有没有数据读到
                int n = client.read(buffer);
                if (n > 0) {
                    buffer.flip();
                    out.write(buffer);
                    buffer.clear();
                } else if (n == -1) {
                    // 这不应当发生, 除非服务器发送故障
                    break;
                }
            }
            client.close();
        }
    }
}
