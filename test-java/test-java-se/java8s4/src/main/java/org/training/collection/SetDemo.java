package org.training.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by kongyunlong on 2016/10/22.
 */

class Dept implements Comparable<Dept> {
   String name;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dept) {
            return name.equals(((Dept) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Dept o) {
        return name.compareTo(o.name);
    }
}

public class SetDemo {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Tom");
        names.add("Jack");
        names.add("Rose");
        names.add("Tom");
        names.forEach(System.out::println);

        Set<Dept> depts = new HashSet<>();
        Dept d1 = new Dept();
        d1.name = "部门1";
        Dept d2 = new Dept();
        d2.name = "部门1";
        depts.add(d1);
        depts.add(d2);
        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());
        depts.forEach(dept -> System.out.println(dept.name));
        //LinkedHashSet顺序与放入时一致
        LinkedHashSet<String> names2 = new LinkedHashSet<>();
        names2.add("Tom");
        names2.add("Jack");
        names2.add("Rose");
        names2.forEach(System.out::println);

        //TreeSet
        TreeSet<String> names3 = new TreeSet<String>();
        names3.add("Tom");
        names3.add("Jack");
        names3.add("Rose");
        names3.forEach(System.out::println);

        Dept d3 = new Dept();
        d3.name = "dept1";
        Dept d4 = new Dept();
        d4.name = "dept2";
        Dept d5 = new Dept();
        d5.name = "dept3";
        TreeSet<Dept> dept2 = new TreeSet<>(new MyDeptComparator());
        dept2.add(d5);
        dept2.add(d4);
        dept2.add(d3);
        dept2.forEach(dept -> System.out.println(dept.name));
    }

    static class MyDeptComparator implements Comparator<Dept> {
        @Override
        public int compare(Dept o1, Dept o2) {
            return - o1.name.compareTo(o2.name);
        }
    }
}
