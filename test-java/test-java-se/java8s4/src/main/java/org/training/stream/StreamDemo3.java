package org.training.stream;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by anderson on 17-8-28.
 */
public class StreamDemo3
{
    public static void main(String[] args)
    {
//        int num = Stream.of(1, 2, 3, 4, 5)
//                .peek(n -> System.out.println("one:" + n))
//                .filter(n -> n % 2 == 1)
//                .peek(n -> System.out.println("two:" + n))
//                .reduce(0, Integer::sum);
//        System.out.println(num);

        Person.persons().stream().forEach(p -> System.out.println(p.getName()));
        Person.persons().stream().forEach(System.out::println);
//        Person.persons().stream().map(p -> p.getName()).forEach(System.out::println);
        Person.persons().stream().map(Person::getName).forEach(System.out::println);
        IntStream.range(1, 5).map(n -> n * n).forEach(System.out::println);

        Person.persons().stream().filter(Person::isMale).map(Person::getName)
        .forEach(System.out::println);
        Person.persons().stream().filter(p -> p.getIncome() > 5000).map(Person::getName)
                .forEach(System.out::println);

        // 去重
        Stream.of(1, 2, 3, 2, 3, 4, 5).distinct().forEach(System.out::println);
        Stream.of(1, 2, 3, 2, 3, 4, 5).limit(9).forEach(System.out::println);
        System.out.println("--------------------------------------------------------");
        // 丢弃前面几个元素
        Stream.of(1, 2, 3, 2, 3, 4, 5).distinct().skip(2).forEach(System.out::println);
        System.out.println("--------------------------------------------------------");
        // 排序, 默认从小到大，sorted里面可以传入一个比较器
        Stream.of(4, 2, 3, 2, 3, 5, 1).distinct().sorted().forEach(System.out::println);

        //0D是初始值
        double sum = Person.persons().stream().map(Person::getIncome).reduce(0D, Double::sum);
        System.out.println(sum);

        Optional<Double> opSum = Person.persons().stream().map(Person::getIncome).reduce(Double::sum);
        if (opSum.isPresent()) {
            System.out.println(opSum.get());
        }
    }
}
