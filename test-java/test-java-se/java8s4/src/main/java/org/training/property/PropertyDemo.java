package org.training.property;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by anderson on 17-11-3.
 */
public class PropertyDemo
{
    public static void main(String[] args)
            throws IOException
    {
        Properties properties = new Properties();
        // 使用下面这种方式的话, config.properties需要放在main/java下, 编译后会放置到target/classes下
//        InputStream inputStream = PropertyDemo.class.getClassLoader().getResourceAsStream("config.properties");
//        properties.load(inputStream);
        // 使用下面的方式, config.properties需要放在工程目录下, test-project/config.properties
        properties.load(new FileInputStream("config.properties"));

//        properties.forEach((k, v) -> {
//            System.out.println(k + "=" + v);
//        });

//        System.out.println(properties.get("url"));

        // 下面三个方法都可以添加新的属性或修改原有的属性
        properties.setProperty("user", "anderson");
        properties.put("a", "aaa");
        properties.setProperty("b", "bcd");
        properties.store(new FileOutputStream("config.properties"), "hahahah");

        Properties sp = System.getProperties();
        sp.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
