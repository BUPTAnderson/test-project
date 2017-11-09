package org.training.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by anderson on 17-11-7.
 */
public class TCPClient
{
    public static void main(String[] args)
            throws IOException
    {
        Socket socket = new Socket("localhost", 9000);
        OutputStream os = socket.getOutputStream();
        os.write("Hello Java".getBytes());
        os.flush();
        os.close();
    }
}
