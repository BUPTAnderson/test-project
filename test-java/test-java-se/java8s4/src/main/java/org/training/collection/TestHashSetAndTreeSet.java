package org.training.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by anderson on 17-4-14.
 */
public class TestHashSetAndTreeSet {
    public static void main(String[] args) {
//        Map<String, Integer> map = new TreeMap<>();
//        map.put("abc", 1);
//        map.put("def", 2);
//        System.out.println(map.remove("abc"));
//        // TreeSet底层是使用TreeMap来实现的，value都是同一个常量值：private static final Object PRESENT = new Object();
//        Set<String> tree = new TreeSet<>();
//        tree.add("abc");
//        tree.add("def");
//        System.out.println(tree.remove("abc"));
//
//        Map<String, Integer> hashMap = new HashMap<>();
//        System.out.println(hashMap.put("abc", new Integer(1)));
//        hashMap.put("def", new Integer(2));
//        System.out.println(hashMap.remove("abc"));
//        // HashSet底层是使用HashMap来实现的，value都是同一个常量值：private static final Object PRESENT = new Object();
//        Set<String> hash = new HashSet<>();
//        hash.add("abc");
//        hash.add("def");
//        System.out.println(hash.remove("abc"));
//        int i;
//        System.out.println(i);

//        removeHashMap();
//        testSplit();
        testTime();
    }

    public static void removeHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "abc");
        map.put("2", "def");
        map.put("3", "abc");
        map.put("4", "ghi");
        map.put("5", "abc");
        map.keySet();

        for (String key : map.keySet()) {
            String value = map.get(key);
            if (value.equals("abc")) {
                map.remove(key);
            }
        }
    }

    public static void testSplit() {
        String commaSeparatedTopics = ",abc, cde, test, haha,";
        List<String> topicList;
        topicList = Arrays.asList(commaSeparatedTopics.split("^\\s+|\\s*,\\s*|\\s+$"));
        for (String topic : topicList) {
            System.out.println("#" + topic + "#");
        }
    }

    public static void testTime() {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
//        Runtime.getRuntime().addShutdownHook();
    }
}
