package org.training.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by anderson on 17-11-15.
 * 通过NIO实现非阻塞IO
 */
public class TCPServerNoBlocking
{
    public static void main(String[] args)
            throws IOException, InterruptedException
    {
        // 开始是, 这个通道并没有具体监听任何端口. 要把它绑定到一个端口, 可以用socket()方法获取其ServerSocket对象, 然后使用bind()方法绑定到这个对等端.
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 配置为非阻塞模式
        serverChannel.configureBlocking(false);
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;
//        ServerSocket server = serverChannel.socket();
//        server.bind(new InetSocketAddress(address, port));
        // 在java7及以后版本中, 可以直接绑定而不用获取底层java.net.ServerSocket
        serverChannel.bind(new InetSocketAddress(address, port));

        while (true) {
            // 没有连接会直接返回
            System.out.println("server端等待连接到了");
//            Socket socket = server.accept();
            // 如果没有连接, 非阻塞的accept()几乎会立即返回null. 要确保对此进行检查, 否则当视图使用这个socket(而她实际为null)时, 会得到一个讨厌的NullPointerException异常
            SocketChannel clientChannel = serverChannel.accept();
            while (clientChannel == null) {
                clientChannel = serverChannel.accept();
                System.out.println("clientChannel 为null");
                Thread.currentThread().sleep(500L);
            }
            clientChannel.configureBlocking(false);
            System.out.println("server建立一个连接");
            ByteBuffer buffer = ByteBuffer.wrap("Hello Java".getBytes());
            while (buffer.hasRemaining()) {
                clientChannel.write(buffer);
            }
//            InputStream is = socket.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            String msg = null;
//            while ((msg = reader.readLine()) != null) {
//                System.out.println("-----" + msg);
//            }
//            reader.close();
//            is.close();
//            socket.close();
//            System.out.println("server端关闭一个socket");
        }
    }
}
