package org.training.lru.case2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Anderson on 2019/6/21
 */
public class LRUCache {
    private LinkedList<Integer> linkList = new LinkedList<>();
    private Map<Integer, String> map = new HashMap<>();
    private int capacity = 3;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(Integer key) {
        if (map.containsKey(key)) {
            boolean result = linkList.remove(key);
            linkList.addFirst(key);
            return map.get(key);
        } else {
            return "--";
        }
    }

    public boolean remove(Integer key) {
            boolean result = linkList.remove(key);
            return result;
    }

    private void setHead(Integer key, String value) {
            linkList.addFirst(key);
    }

    public void set(int key, String value) {
        if (map.containsKey(key)) {
            if (linkList.getFirst() != key) {
                remove(key);
                setHead(key, value);
            }
        } else {
            if (map.size() >= capacity) {
                map.remove(linkList.getLast());
                remove(linkList.getLast());
            }
            map.put(key, value);
            setHead(key, value);
        }
    }
}
