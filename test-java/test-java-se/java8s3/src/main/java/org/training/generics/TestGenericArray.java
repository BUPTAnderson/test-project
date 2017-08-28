package org.training.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongyunlong on 2016/5/28.
 */
public class TestGenericArray {
    public static void main(String[] args) {
        List<?>[] lsa = new List<?>[10];
        System.out.println(lsa.length);

        String[] strArray = new String[20];
        Object[] objArray = strArray;
        objArray[0] = new Integer(1);

        List<String>[] ls = new ArrayList[10];
        ArrayList<String> arrayList = new ArrayList();
    }
}
