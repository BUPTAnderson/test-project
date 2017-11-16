package org.training.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by anderson on 17-11-7.
 * 通过NIO实现I/O复用
 */
public class NonBlockingServer
{
    public static void main(String[] args)
            throws IOException
    {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;
        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(address, port));
        // 与Selector一起使用时，Channel必须处于非阻塞模式下。这意味着不能将FileChannel与Selector一起使用，因为FileChannel不能切换到非阻塞模式。而套接字通道都可以。
        // 注意register()方法的第二个参数。这是一个“interest集合”，意思是在通过Selector监听Channel时对什么事件感兴趣。可以监听四种不同类型的事件：Connect, Accept, Read, Write
        // 通道触发了一个事件意思是该事件已经就绪。所以，某个channel成功连接到另一个服务器称为“连接就绪”。一个server socket channel准备好接收新进入的连接称为“接收就绪”。一个有数据可读的通道可以说是“读就绪”。等待写数据的通道可以说是“写就绪”。
        // 这四种事件用SelectionKey的四个常量来表示：SelectionKey.OP_CONNECT, SelectionKey.OP_ACCEPT, SelectionKey.OP_READ, SelectionKey.OP_WRITE, 如果你对不止一种事件感兴趣，那么可以用“位或”操作符将常量连接起来，如下：
        // int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
        SelectionKey selectionKey = server.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // select()方法返回的int值表示有多少通道已经就绪。亦即，自上次调用select()方法后有多少通道变成就绪状态。如果调用select()方法，因为有一个通道变成就绪状态，返回了1，若再次调用select()方法，如果另一个通道就绪了，它会再次返回1。如果对第一个就绪的channel没有做任何操作，现在就有两个就绪的通道，但在每次select()方法调用之间，只有一个通道就绪了。
            if (selector.select() <= 0) {
                continue;
            }
            // 一旦调用了select()方法，并且返回值表明有一个或更多个通道就绪了，然后可以通过调用selector的selectedKeys()方法，访问“已选择键集（selected key set）”中的就绪通道。
            processReadySet(selector.selectedKeys());
        }
    }

    private static void processReadySet(Set<SelectionKey> keys)
            throws IOException
    {
        Iterator<SelectionKey> iterator = keys.iterator();
        SelectionKey key = null;
        while (iterator.hasNext()) {
            key = iterator.next();

            if (key.isAcceptable()) {
                processAccept(key);
            }
            if (key.isReadable()) {
                processRead(key);
            }
            // 注意每次迭代末尾的keyIterator.remove()调用。Selector不会自己从已选择键集中移除SelectionKey实例。必须在处理完通道时自己移除。下次该通道变成就绪时，Selector会再次将其放入已选择键集中。
            iterator.remove();
        }
    }

    private static void processAccept(SelectionKey key)
            throws IOException
    {
        ServerSocketChannel sc = (ServerSocketChannel) key.channel();
        SocketChannel c = sc.accept();
        c.configureBlocking(false);
        c.register(key.selector(), SelectionKey.OP_READ);
    }

    private static void processRead(SelectionKey key)
            throws IOException
    {
        // SelectionKey.channel()方法返回的通道需要转型成你要处理的类型，如ServerSocketChannel或SocketChannel等。
        SocketChannel c = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String msg = null;
        // 非阻塞模式下,read()方法在尚未读取到任何数据时可能就返回了。所以需要关注它的int返回值，它会告诉你读取了多少字节。
        while (c.read(buffer) != -1) {
            buffer.flip();
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            msg = charBuffer.toString();
            System.out.println(msg);
            buffer.clear();
        }
    }
}
