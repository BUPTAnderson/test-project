package org.training.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by kongyunlong on 2016/10/22.
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> c1 = new ArrayList<>();
        c1.add("a");
        c1.add("b");
        c1.add("c");
        c1.add("d");
        //1.使用Iterator
        Iterator<String> iter = c1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("-------------------");
        //使用for each循环
        for (String str : c1) {
            System.out.println(str);
        }
        System.out.println("----------str ----------");
        //3. 使用forEach方法
        //lambda表达式
        c1.forEach((String str) -> System.out.println(str));
        //方法引用
        c1.forEach(System.out::println);

//        Set<String> set = new HashSet<String>();
//        set.add(null);
//        System.out.println(set.size());
//        Set<String> treeSet = new TreeSet<>();
////        treeSet.add(null);
//        System.out.println(treeSet.size());
//
//        Set<String> set2 = new LinkedHashSet<>();
//        set2.add(null);
//        System.out.println(set2.size());
        Queue<String> s1 = null;
//        s1.add(null);
        s1.offer(null);
//        s1.add("String");
//        s1.add("world");
//        s1.add("hello");
//        s1.remove();
//        s1.remove();
//        s1.poll();
//        s1.element();
//        System.out.println(s1.peek());
//        System.out.println(s1.size());
    }
}
