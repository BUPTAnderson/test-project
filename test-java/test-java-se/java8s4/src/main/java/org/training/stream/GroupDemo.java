package org.training.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by anderson on 17-8-29.
 */
public class GroupDemo
{
    public static void main(String[] args)
    {
        Map<Person.Gender, List<Person>> map = Person.persons().stream().collect(Collectors.groupingBy(Person::getGender));
        map.forEach(((gender, persons) -> {
            System.out.println(gender);
            persons.forEach(System.out::println);
        }));

        Map<Boolean, List<Person>> parts = Person.persons().stream().collect(Collectors.partitioningBy(Person::isMale));
        parts.forEach(((gender, persons) -> {
            System.out.println(gender);
            persons.forEach(System.out::println);
        }));
    }
}
