package org.training.net;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by anderson on 17-11-7.
 */
public class CoderDemo
{
    public static void main(String[] args)
            throws UnsupportedEncodingException
    {
        String p = "this is 2.5%";
        System.out.println(URLEncoder.encode(p, "UTF-8"));
        String result = URLEncoder.encode(p, "UTF-8");
        System.out.println(URLDecoder.decode(result, "UTF-8"));
    }
}
