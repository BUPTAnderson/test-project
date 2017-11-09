package org.training.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by anderson on 17-11-7.
 */
public class UDPClient
{
    public static void main(String[] args)
            throws IOException
    {
        DatagramSocket ds = new DatagramSocket();
        String msg = "Hello world";
        DatagramPacket p = new DatagramPacket(msg.getBytes(), msg.getBytes().length);
        p.setAddress(InetAddress.getByName("localhost"));
        p.setPort(9000);
        ds.send(p);

        ds.receive(p);
        byte[] data = p.getData();
        int length = p.getLength();
        int offset = p.getOffset();
        String s = new String(data, offset, length);
        System.out.println(s);
    }
}
