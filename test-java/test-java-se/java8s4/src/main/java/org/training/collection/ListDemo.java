package org.training.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by kongyunlong on 2016/10/22.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        // 必须按顺序添加，不能跳跃，可以覆盖之前添加的元素。即不能按0,1,5这样跳跃添加， 可以按0,1,2,1,3添加
        names.add(0, "Tom");
        names.add(1, "Jack");
        //在位置为1的地方加入Rose，之前数据依次向后移动一位，Jack位置变为2
        names.add(1, "Rose");
        //可以存入重复元素
        names.add(3, "Tom");
        //可以存入多个null
        names.add(4, "null");
        names.add(5, "null");
        names.forEach(System.out::println);
        System.out.println("--------------------");
        //使用索引访问元素
        System.out.println(names.get(3));
        //查询特定元素的位置
        System.out.println(names.indexOf("Jack"));
        System.out.println(names.lastIndexOf("Tom"));
        //截取子串
        names.subList(1, 3).forEach(System.out::println);
        System.out.println("---------------------------");
        //使用特别的Iterator
        ListIterator<String> iter = names.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("-------与前面的输出相反-----------");
        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }
    }
}
