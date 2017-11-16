package org.training.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by anderson on 17-11-15.
 * 通过NIO实现阻塞IO
 */
public class TCPServerByNIO
{
    public static void main(String[] args)
            throws IOException
    {
        //单线程方式
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;
//        ServerSocket server = serverSocketChannel.socket();
//        server.bind(new InetSocketAddress(address, port));
        // 在java7之后可以直接绑定而不用获取底层java.net.ServerSocket
        serverSocketChannel.bind(new InetSocketAddress(address, port));
        while (true) {
            // 虽然我们使用的NIO, 但是这里使用的是NIO的阻塞模式, 所以线程会阻塞在这里直到有连接到来
            System.out.println("server端等待连接到来");
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("server建立一个连接");
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            WritableByteChannel out = Channels.newChannel(System.out);
            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
            socketChannel.close();
            System.out.println("server端关闭一个socket");
        }
    }
}
