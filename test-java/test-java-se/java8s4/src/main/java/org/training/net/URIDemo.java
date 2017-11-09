package org.training.net;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by anderson on 17-11-7.
 */
public class URIDemo
{
    public static void main(String[] args)
            throws URISyntaxException
    {
        URI uri1 = new URI("https://www.baidu.com/s?wd=java&rsv_spt=1&rsv_iqid=0xedbf89b00003b79d&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=2&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=252&rsv_sug4=1953&rsv_sug=9");

        URI uri2 = URI.create("http://www.baidu.com");

        // scheme即是协议
        System.out.println(uri1.getScheme());
        System.out.println(uri1.getHost());
        System.out.println(uri1.getPort());
        System.out.println(uri1.getPath());
        System.out.println(uri1.getQuery());

        URI uri3 = new URI("index.jsp");
        // resole方法可以进行uri的拼接
        System.out.println(uri1.resolve(uri3));
    }
}
