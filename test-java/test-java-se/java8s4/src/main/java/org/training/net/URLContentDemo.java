package org.training.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by anderson on 17-11-7.
 */
public class URLContentDemo
{
    public static void main(String[] args)
            throws IOException
    {
        URL url = new URL("http://wwww.baidu.com");
//        getContent(url);
        getContent1();
    }

    private static void getContent(URL url)
            throws IOException
    {
        InputStream is = url.openStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        String s = null;
        while ((s = r.readLine()) != null) {
            System.out.println(s);
        }
    }

    private static void getContent1()
            throws IOException
    {
        URL url = new URL("http://www.baidu.com");
        Class[] c = new Class[] {String.class, BufferedReader.class, InputStream.class};
        Object o = url.getContent();
        if (o instanceof String ) {
            System.out.println(o);
        } else if (o instanceof  BufferedReader) {
            System.out.println("BufferedReader");
        } else if (o instanceof  InputStream) {
            System.out.println("InputStream");
            // sun.net.www.protocol.http.HttpURLConnection
            System.out.println(o);
        } else {
            System.out.println("else");
        }
    }

    private static void getContent2()
            throws IOException
    {
        URL url = new URL("http://www.baidu.com");
        // URLConnection可以向服务端写数据
        URLConnection c = url.openConnection();
        c.setDoOutput(true);
        c.connect();
        InputStream is = c.getInputStream();
        OutputStream os = c.getOutputStream();
    }
}
