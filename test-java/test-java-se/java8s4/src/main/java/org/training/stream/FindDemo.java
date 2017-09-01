package org.training.stream;

import java.util.Optional;

/**
 * Created by anderson on 17-8-29.
 */
public class FindDemo
{
    public static void main(String[] args)
    {
        // 任意返回一个元素
        Optional<Person> o1 = Person.persons().parallelStream().sequential().findAny();
        if (o1.isPresent()) {
            System.out.println(o1.get());
        }

        // 取性别为女的第一个person
        Optional<Person> person = Person.persons().stream().filter(Person::isFeMale).findFirst();
        if (person.isPresent()) {
            System.out.println(person.get());
        }
    }
}
