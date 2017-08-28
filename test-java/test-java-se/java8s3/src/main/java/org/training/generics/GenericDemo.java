package org.training.generics;

import java.util.ArrayList;

/**
 * Created by kongyunlong on 2016/5/26.
 */
public class GenericDemo {
    public static void main(String[] args) {
        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("Hello");
        ArrayList<Integer> listInt = new ArrayList<>();
        listInt.add(100);
        ArrayList list;
        list = listStr;
        listInt = list;
        int a = listInt.get(0);
        System.out.println(a);
    }
}
