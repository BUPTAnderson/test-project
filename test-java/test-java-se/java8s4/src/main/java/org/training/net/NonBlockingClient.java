package org.training.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by anderson on 17-11-7.
 */
public class NonBlockingClient
{
    public static void main(String[] args)
            throws IOException
    {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;
        InetSocketAddress serverAddress = new InetSocketAddress(address, port);
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(serverAddress);
        channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);

        while (true) {
            if (selector.select() > 0) {
                boolean status = processReadySet(selector.selectedKeys());
                if (status) {
                    break;
                }
            }
        }
        channel.close();
    }

    private static boolean processReadySet(Set<SelectionKey> keys)
            throws IOException
    {
        Iterator<SelectionKey> iterator = keys.iterator();
        SelectionKey key = null;
        while (iterator.hasNext()) {
            key = iterator.next();
            iterator.remove();
            if (key.isConnectable()) {
                // a connection was accepted by a ServerSocketChannel.
                processConnect(key);
            }
            if (key.isAcceptable()) {
                // a connection was established with a remote server.
            }
            if (key.isReadable()) {
                // a channel is ready for reading
            }
            if (key.isWritable()) {
                // a channel is ready for writing
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                processWrite(key, reader.readLine());
//                processWrite(key, "Hello Server");
            }
        }
        return false;
    }

    private static boolean processConnect(SelectionKey key) {
        SocketChannel c = (SocketChannel) key.channel();
        try {
            while (c.isConnectionPending()) {
                c.finishConnect();
            }
        } catch (IOException e) {
            key.cancel();
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String processRead() {
        return "";
    }

    private static void processWrite(SelectionKey key, String msg)
            throws IOException
    {
        // SelectionKey.channel()方法返回的通道需要转型成你要处理的类型，如ServerSocketChannel或SocketChannel等。
        SocketChannel c = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        while (buffer.hasRemaining()) {
            c.write(buffer);
        }
    }
}
