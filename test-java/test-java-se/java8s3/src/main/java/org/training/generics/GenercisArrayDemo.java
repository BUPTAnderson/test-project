package org.training.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongyunlong on 2016/5/28.
 */
class Student<T> {
    public Student(){
        //T[] t = new T[10]; //报错,Type parameter 'T' cannot be instantiated directly
    }
}

public class GenercisArrayDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        List<String> stringList = list;
        //Student<String>[] students = new Student<String>[10];   //报错，Generic array creation
//        Student<?>[] students = new Student<?>[10];
//        students[0] = new Student<?>();
//        students[1] = new Student<Integer>();
//        Student<String>[] stringStudent = new Student[2];
//        stringStudent[0] = new Student<String>();
//        Object object = stringStudent;

        List<String>[] lsa = new List[10];
        System.out.println(lsa.length);
//        Object o = lsa;
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li;
        String s = lsa[1].get(0);
        System.out.println(s);

//        List<Integer> integers = new ArrayList<Number>();

        List<String> list1 = null;
        List list2 = new ArrayList();
        list2.add(100);
        list1 = list2;
    }
}
