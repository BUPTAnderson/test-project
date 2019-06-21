package org.training.lru.case1;

/**
 * Created by Anderson on 2019/6/21
 */
public class Test {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        lruCache.set(3, 3);
        lruCache.set(5, 5);
        lruCache.set(6, 6);
        lruCache.set(3, 3);

        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(6));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(4));
    }
}
