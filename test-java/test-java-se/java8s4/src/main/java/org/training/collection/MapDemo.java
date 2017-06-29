package org.training.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by kongyunlong on 2016/10/25.
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        m1.put("a", "Acde");
        m1.put(null, "Bcdfe");
        m1.put("c", "Bcdf1e");

        System.out.println("--------------------");
        Set<String> keys = m1.keySet();
        keys.forEach(key -> System.out.println(m1.get(key)));

        System.out.println("----------------------");
        m1.values().forEach(v -> System.out.println(v));

        System.out.println("---------------------");
        Set<Map.Entry<String, String>> entries = m1.entrySet();
        entries.forEach(e -> System.out.println(e.getKey() + "-" + e.getValue()));

        System.out.println("-----------------");
        m1.forEach((k, v) -> System.out.println(k + "," + v));
    }
}
