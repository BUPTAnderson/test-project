package org.training.stream;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by kongyunlong on 2017/8/27.
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("Tom", "Jack", "Rose", "Tim");
        Stream<String> s2 = Stream.<String>builder().add("Jack").add("Tom").build();

        // 产生1~5的stream
        IntStream i1 = IntStream.range(1, 6);
        i1.forEach(System.out::println);
        // 创建1~6的stream
        IntStream i2 = IntStream.rangeClosed(1, 6);
        i2.forEach(System.out::println);

        Stream<String> s3 = Stream.empty();
        IntStream i3 = IntStream.empty();
        System.out.println("-------------------------");
        // 0是第一个输入, +2后得到结果2, 2继续作为输入+2后得到4继续作为输出, 依次类推, 会得到无数个输出, 如果直接输出, 是一个死循环
        Stream<Long> long1 = Stream.iterate(0L, n -> n + 2);
        long1.limit(10).forEach(System.out::println);
        System.out.println("-------------------------");
        Stream.generate(Math::random).limit(5).forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3, 4, 5});
        Arrays.stream(new String[]{"ab", "cd", "ef"});

        "aaaa bbb".chars().forEach(System.out::println);

        Pattern.compile(",").splitAsStream("abc,def,fgr").forEach(System.out::println);
    }
}
