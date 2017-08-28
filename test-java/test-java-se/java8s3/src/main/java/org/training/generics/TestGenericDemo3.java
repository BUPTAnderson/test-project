package org.training.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 16-9-22.
 */
public class TestGenericDemo3 {
    public static void main(String[] args) {
        List<?>[] lsa = new List<?>[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(3);
        oa[1] = li;
        String s = (String) lsa[1].get(0);
        System.out.println(s);

        String[] strArray = new String[20];
        Object[] objArray = strArray;
        objArray[0] = new Integer(1); // throws ArrayStoreException at runtime
    }
}
