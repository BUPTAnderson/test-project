package org.training.collection;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

/**
 * Created by kongyunlong on 2016/10/22.
 */
class Person implements Comparable<Person> {
    String name;

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> s1 = new LinkedList<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        // 入队， 在队尾加入元素
        s1.offer("d");

        //add,   element, remove在有边界的队列上可能会抛出异常
        //offer, peek,    poll在有边界的队列上不会抛出异常
        while (s1.peek() != null) {
            //peek只会获取但不删除第一个元素
//            System.out.println(s1.peek());
            //element与peek类似
            System.out.println(s1.element());
//            s1.remove();
            //获取并删除第一个元素， 出队
            s1.poll();
        }

        //PriorityQueue存放的元素要实现Comparable接口或传入比较器
        Queue<Person> s2 = new PriorityQueue<>();
        Person p1 = new Person();
        p1.name = "Tom";
        Person p2 = new Person();
        p2.name = "Jack";
        Person p3 = new Person();
        p3.name = "Rose";

        s2.add(p1);
        s2.add(p2);
        s2.add(p3);

        while (s2.peek() != null) {
            Person p = s2.peek();
            System.out.println(p.name);
//            s2.remove();
            s2.poll();
        }

        Queue<Person> s3 = new PriorityQueue<>(Comparator.comparing(Person::getName));
        s3.add(p1);
        s3.add(p2);
        s3.add(p3);
        while (s3.peek() != null) {
            Person p = s3.peek();
            System.out.println(p.name);
            s3.remove();
        }

        Function<Person, String> function = Person::getName;
        System.out.println("---------------------------");
        //双端队列
        Deque<String> s4 = new LinkedList<>();
        //add与addLast类似，如果链表为空...
        s4.addFirst("");
        //peek类似peekFirst,如果链表为空...
        s4.peekLast();
    }
}
