package org.training.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongyunlong on 2017/8/27.
 */
public class ToArrayDemo {
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add("a");
        l.add("b");
        // 报错
//        String[] strs=(String[])l.toArray();//throw ClassCastException
        // 通常的做法
        String[] strs = new String[l.size()];
        l.toArray(strs);

        String[] strs2 = new String[4]; //比List多2个元素
        for (int i = 0; i < strs2.length; i++) { //填充4个字符串"x”
            strs2[i] = "x";
        }
        String[] newStrs = (String[]) l.toArray(strs2);
        System.out.println(newStrs == strs2); //为了确定是否传入的参数对象和返回的是同一个对象。
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }

        String[] strs3 = new String[0];
//        String[] newStrs2 = (String[]) l.toArray(new String[0]);
        String[] newStrs2 = (String[]) l.toArray(strs3);
        System.out.println(newStrs2 == strs3);
        for (int i = 0; i < newStrs2.length; i++) {
            System.out.println(newStrs2[i]);
        }
    }
}
