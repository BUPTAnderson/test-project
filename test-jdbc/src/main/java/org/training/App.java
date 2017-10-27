package org.training;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App
{
    public static String testException() throws Exception {
        String abc = null;
        try {
            InputStream stream = new FileInputStream("/abc.txt");
            abc = "111";
        } catch (Exception e) {
            throw new Exception("haha");
        } finally {
            return abc;
        }
    }
    public static void main(String[] args)
    {
//        System.out.println("Hello World!");
//
//        String abc = null;
//        try {
//            abc = testException();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(abc);
        System.out.println(Long.MAX_VALUE + 1);
    }
}
