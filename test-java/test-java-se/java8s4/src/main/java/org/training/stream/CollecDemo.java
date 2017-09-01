package org.training.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by anderson on 17-8-29.
 */
public class CollecDemo
{
    public static void main(String[] args)
    {
        List<String> names = Person.persons().stream().map(Person::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(names);

        List<String> names2 = Person.persons().stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(names2);

        Set<String> names3 = Person.persons().stream().map(Person::getName).collect(Collectors.toSet());
        System.out.println(names3);

        SortedSet<String> names4 = Person.persons().stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(names4);

        long num = Person.persons().stream().map(Person::getName).collect(Collectors.counting());
        System.out.println(num);

        Map<Integer, String> map = Person.persons().stream().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println(map);

        String s = Person.persons().stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(s);
    }
}
