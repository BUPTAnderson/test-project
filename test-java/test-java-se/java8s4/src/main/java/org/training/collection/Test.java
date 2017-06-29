package org.training.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kongyunlong on 2016/10/25.
 */
class People implements Comparable<People> {
    String name;
    int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
//        return this.age == ((People)o).age;
//        return this.name.equals(((People)o).getName());
        return false;
    }

    @Override
    public int hashCode() {
        return age;
    }

    @Override
    public int compareTo(People o) {
        return this.name.hashCode() - o.name.hashCode();
    }
}

public class Test {
    public static void main(String[] args) {
        People p1 = new People("Tom", 20);
        People p2 = new People("Jack", 20);
        People p3 = new People("Jack", 20);
//        Set<People> set = new LinkedHashSet<>();
//        set.add(p1);
//        set.add(p2);
//        System.out.println(set.size());
//        Set<People> set = new TreeSet<>();
//        set.add(p1);
//        set.add(p2);
//        System.out.println(set.size());
//        System.out.println(set.contains(p3));
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        Map<String, String> map2 = new TreeMap<>();
        map2.put("", null);
        Map<String, String> map3 = new Hashtable<>();
        map3.put(null, "");
    }
}
