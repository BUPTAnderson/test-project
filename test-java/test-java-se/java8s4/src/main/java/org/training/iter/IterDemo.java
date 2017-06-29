package org.training.iter;

import java.util.Iterator;

/**
 * Created by kongyunlong on 2016/10/17.
 */

class Student {
    String name;

    public Student(String name) {
        this.name = name;
    }
}

class Clazz implements Iterable<Student> {
    Student[] students;

    public Clazz(int num) {
        students = new Student[num];
    }

    int index = 0;

    public void add(Student s) {
        students[index++] = s;
    }

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index != students.length;
            }

            @Override
            public Student next() {
                return students[index++];
            }
        };
    }
}

public class IterDemo {
    public static void main(String[] args) {
        Clazz c = new Clazz(3);
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        Student s3 = new Student("s3");
        c.add(s1);
        c.add(s2);
        c.add(s3);

        for (Student s : c) {
            System.out.println(s.name);
        }
    }
}
