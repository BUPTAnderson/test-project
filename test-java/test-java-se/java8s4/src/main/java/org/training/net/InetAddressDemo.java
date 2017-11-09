package org.training.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by anderson on 17-11-7.
 */
public class InetAddressDemo
{
    public static void main(String[] args)
            throws UnknownHostException
    {
        InetAddress a1 = InetAddress.getLocalHost();
        // 127.0.1.1
        System.out.println(a1.getHostAddress());
        System.out.println(a1.getHostName());
        InetAddress[] a2 = InetAddress.getAllByName("anderson-JD");
        for (InetAddress inetAddress : a2) {
            System.out.println(inetAddress.getHostAddress());
        }

        System.out.println("------------------");
        InetAddress a3 = InetAddress.getByName("www.baidu.com");
        System.out.println(a3.getHostAddress());

        InetSocketAddress a4 = new InetSocketAddress("anderson-JD", 80);
    }
}
