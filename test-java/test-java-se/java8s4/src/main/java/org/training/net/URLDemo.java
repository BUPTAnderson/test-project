package org.training.net;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by anderson on 17-11-7.
 * URI URI可以被分为URL、URN或两者的组合。
 * URI uniform resource identifier
 * URL uniform resource location
 * URN uniform resource name
 */
public class URLDemo
{
    public static void main(String[] args)
            throws MalformedURLException, URISyntaxException
    {
        URL url1 = new URL("http://www.baidu.com");
        System.out.println(url1.getHost());
        URI uri = url1.toURI();
    }
}
