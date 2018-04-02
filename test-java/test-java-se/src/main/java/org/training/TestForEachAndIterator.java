package org.training;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by anderson on 18-3-13.
 */
public class TestForEachAndIterator
{
    public static void main(String[] args)
    {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张三", 20));
        list.add(new Person("李四", 21));
        list.add(new Person("王五", 22));
        list.add(new Person("马六", 23));
        list.add(new Person("张三", 20));

        list.remove(new Person("张三", 20));
        list.remove(new Person("张三", 20));
        System.out.println(list.size());

        for (Person p : list) {
            if (p.getName().equals("张三")) {
                p.setName("aaa");
                p.setAge(11);
            }
        }

        for (Person p : list) {
            System.out.println("name:" + p.getName() + ", age:" + p.getAge());
        }

        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person p = iterator.next();
            if (p.getName().equals("马六")) {
                p.setName("bbb");
                p.setAge(33);
            }
        }

        Iterator<Person> it = list.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println("name:" + p.getName() + ", age:" + p.getAge());
        }
    }
}
