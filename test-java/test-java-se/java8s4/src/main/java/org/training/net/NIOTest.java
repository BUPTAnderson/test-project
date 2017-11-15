package org.training.net;

import java.util.Scanner;

/**
 * Created by anderson on 17-11-15.
 */
public class NIOTest
{
    //测试主方法
    @SuppressWarnings("resource")
    public static void main(String[] args)
            throws Exception
    {
        //运行服务器
        Server.start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(100);
        //运行客户端
        NIOClient.start();
        while (NIOClient.sendMsg(new Scanner(System.in).nextLine())) {
            ;
        }
    }
}
