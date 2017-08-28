package org.training.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anderson on 16-9-28.
 */
public class TestDemo2 {
    public static void main(String[] args) {
//        List<? extends Number> eList = null;
//        eList = new ArrayList<Integer>();
//        Number numObject = eList.get(0);  //语句1，正确

        //Type mismatch: cannot convert from capture#3-of ? extends Number to Integer
//        Integer intObject = eList.get(0);  //语句2，错误

        //The method add(capture#3-of ? extends Number) in the type List<capture#3-of ? extends Number> is not applicable for the arguments (Integer)
//        eList.add(new Integer(1));  //语句3，错误

//        List<? super Integer> sList = null;
//        sList = new ArrayList<Number>();

        //Type mismatch: cannot convert from capture#5-of ? super Integer to Number
//        Number numObj = sList.get(0);  //语句1，错误

        //Type mismatch: cannot convert from capture#6-of ? super Integer to Integer
//        Integer intObj = sList.get(0);  //语句2，错误

//        sList.add(new Integer(1));  //语句3，正确
        List<String> strings = new ArrayList<>();
        Class aClass = strings.getClass();
        System.out.println(aClass.toGenericString());
    }
}
