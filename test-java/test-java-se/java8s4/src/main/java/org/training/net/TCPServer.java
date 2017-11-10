package org.training.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by anderson on 17-11-7.
 */
public class TCPServer
{
    public static void main(String[] args)
            throws IOException
    {
        //单线程方式
//        ServerSocket server = new ServerSocket(9000);
//        while (true) {
//            Socket socket = server.accept();
//            InputStream is = socket.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            String msg = null;
//            while ((msg = reader.readLine()) != null) {
//                System.out.println(msg);
//            }
//            socket.close();
//        }

        // 线程池方式
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(9000);
        while (!Thread.currentThread().isInterrupted()) {
            Socket socket = serverSocket.accept();
            executorService.submit(new ProcessSocket(socket));
        }
    }
}

class ProcessSocket extends Thread {
    private Socket socket;

    public ProcessSocket(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
            InputStream is = null;
            try {
                is = socket.getInputStream();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String msg = null;
            try {
                Thread.currentThread().sleep(10000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                while ((msg = reader.readLine()) != null) {
                    System.out.println(currentThread().getName() + ": " + msg);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.currentThread().sleep(10000L);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}