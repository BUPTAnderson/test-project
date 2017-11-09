package org.training.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by anderson on 17-11-7.
 */
public class UDPServer
{
    public static void main(String[] args)
            throws IOException
    {
        DatagramSocket ds = new DatagramSocket(9000);
        while (true) {
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            int offset = dp.getOffset();
            String s = new String(data, offset, length);
            System.out.println(s);
            ds.send(dp);
        }
    }
}
