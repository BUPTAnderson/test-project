package org.training;

/**
 * Created by anderson on 16-10-8.
 */
public class StringDemo1 {
    public static void main(String[] args) {
        String str = "str" + new String("01"); //①
        str.intern(); //②
        String str1 = "str01"; //③
        System.out.println(str == str1);

        String str2 = new String("str01"); //④
        str2.intern(); //⑤
        String str3 = "str01"; //⑥
        System.out.println(str == str3);

        String str4 = "str01"; //⑦
        String str5 = new String("str") + new String("01"); //⑧
        str5.intern(); //⑨
        System.out.println(str4 == str5);
    }
}
