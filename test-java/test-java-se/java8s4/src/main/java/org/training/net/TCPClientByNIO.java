package org.training.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by anderson on 17-11-15.
 * 通过NIO实现阻塞IO
 */
public class TCPClientByNIO
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

        if (connect) {
            ByteBuffer buffer = ByteBuffer.wrap("Hello Java".getBytes());
            int byteRead = client.write(buffer);
            System.out.println("---成功发送" + byteRead + "字节数据");
            Thread.currentThread().sleep(10000L);
            client.close();
        }
    }
}
