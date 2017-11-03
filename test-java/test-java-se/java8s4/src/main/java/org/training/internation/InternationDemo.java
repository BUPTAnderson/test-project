package org.training.internation;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by anderson on 17-11-3.
 */
public class InternationDemo
{
    public static void main(String[] args)
    {
//        Locale locale = new Locale("en", "US");
        // 对应中文, 对应的msg_zh_CN.properties需要进行转码, 命令: native2ascii -encoding UTF-8 msg.properties msg_zh_CN.properties
        /**
         *  cat msg.properties
         *  name=姓名
         *  password=密码
         *
         *  cat msg_zh_CN.properties
         *  name=\u59d3\u540d
         *  password=\u5bc6\u7801
         */
//        Locale locale = new Locale("zh", "CN");
//        ResourceBundle rb = ResourceBundle.getBundle("msg", locale);
//        String name = rb.getString("name");
//        System.out.println(name);

//        Locale locale = new Locale("en", "US");
        Locale locale = new Locale("zh", "CN");
//        ResourceBundle rb = ResourceBundle.getBundle(Error_en_US.class.getName(), locale);
        ResourceBundle rb = ResourceBundle.getBundle(Error_zh_CN.class.getName(), locale);
        String name = rb.getString("name");
        System.out.println(name);
    }
}
